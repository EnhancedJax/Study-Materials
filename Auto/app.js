import { execSync } from "child_process";
import dotenv from "dotenv";
import enq from "enquirer";
import FormData from "form-data";
import fs from "fs";
import fetch from "node-fetch";
import path from "path";
import readline from "readline";
const { MultiSelect, Toggle } = enq;
dotenv.config();

const HYGRAPH_API_ENDPOINT = process.env.HYGRAPH_API_ENDPOINT;
const HYGRAPH_AUTH_TOKEN = process.env.HYGRAPH_AUTH_TOKEN;
const ROOT_DIR = process.env.ROOT_DIR;
const GREP = process.env.GREP;
const LOG_VERBOSE = process.env.LOG_VERBOSE === "1";

if (LOG_VERBOSE) {
  console.log("Script started");
  console.log(`HYGRAPH_API_ENDPOINT: ${HYGRAPH_API_ENDPOINT}`);
}

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

async function executeGraphQLQuery(query, variables) {
  const response = await fetch(HYGRAPH_API_ENDPOINT, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      Authorization: `Bearer ${HYGRAPH_AUTH_TOKEN}`,
    },
    body: JSON.stringify({ query, variables }),
  });
  return await response.json();
}

async function getAssetIdByFileName(fileName) {
  if (LOG_VERBOSE) console.log("Querying asset ID by file name");
  const query = `#graphql
    query GetAssetByFileName($fileName: String!) {
      assets(where: { fileName: $fileName }) {
        id
      }
    }
  `;

  const result = await executeGraphQLQuery(query, { fileName });
  if (LOG_VERBOSE)
    console.log("Query result:", JSON.stringify(result, null, 2));

  if (result.errors) {
    throw new Error(`Failed to query asset: ${JSON.stringify(result.errors)}`);
  }

  if (!result.data.assets.length) {
    throw new Error(`No asset found with fileName: ${fileName}`);
  }

  return result.data.assets[0].id;
}

async function updateAsset(assetId) {
  if (LOG_VERBOSE) console.log("Step 1: Updating the existing asset");
  const updateAssetMutation = `#graphql
    mutation UpdateAsset($id: ID!) {
      updateAsset(
        where: { id: $id }
        data: { reUpload: true }
      ) {
        id
        upload {
          status
          expiresAt
          error {
            code
            message
          }
          requestPostData {
            url
            date
            key
            signature
            algorithm
            policy
            credential
            securityToken
          }
        }
      }
    }
  `;

  const updateAssetData = await executeGraphQLQuery(updateAssetMutation, {
    id: assetId,
  });
  if (LOG_VERBOSE) {
    console.log(
      "Update asset response:",
      JSON.stringify(updateAssetData, null, 2)
    );
  }

  if (updateAssetData.errors) {
    throw new Error(
      `Failed to update asset: ${JSON.stringify(updateAssetData.errors)}`
    );
  }

  const updatedAsset = updateAssetData.data.updateAsset;
  if (LOG_VERBOSE) console.log(`Asset updated with ID: ${updatedAsset.id}`);
  return updatedAsset;
}

async function uploadFile(uploadData, filePath) {
  if (LOG_VERBOSE) console.log("Step 2: Uploading the file");
  const formData = new FormData();
  const fileStats = fs.statSync(filePath);
  const fileSize = fileStats.size;

  formData.append("key", uploadData.key);
  formData.append("x-amz-algorithm", uploadData.algorithm);
  formData.append("x-amz-credential", uploadData.credential);
  formData.append("x-amz-date", uploadData.date);
  formData.append("policy", uploadData.policy);
  formData.append("x-amz-signature", uploadData.signature);
  formData.append("x-amz-security-token", uploadData.securityToken);
  formData.append("file", fs.createReadStream(filePath), {
    knownLength: fileSize,
  });

  if (LOG_VERBOSE) console.log("Uploading file to:", uploadData.url);
  const uploadResponse = await fetch(uploadData.url, {
    method: "POST",
    body: formData,
    headers: {
      ...formData.getHeaders(),
      "Content-Length": formData.getLengthSync().toString(),
    },
  });

  if (!uploadResponse.ok) {
    const responseText = await uploadResponse.text();
    throw new Error(
      `Failed to upload file: ${uploadResponse.statusText}. Response: ${responseText}`
    );
  }

  if (LOG_VERBOSE) console.log("File uploaded successfully");
}

async function publishAsset(assetId) {
  if (LOG_VERBOSE) console.log("Step 3: Publishing the asset");
  const publishAssetMutation = `#graphql
    mutation PublishAsset($id: ID!) {
      publishAsset(where: { id: $id }, to: PUBLISHED) {
        id
      }
    }
  `;

  let publishAssetData;
  let retryCount = 0;
  const maxRetries = 3;

  while (retryCount < maxRetries) {
    publishAssetData = await executeGraphQLQuery(publishAssetMutation, {
      id: assetId,
    });
    if (LOG_VERBOSE) {
      console.log(
        "Publish asset response:",
        JSON.stringify(publishAssetData, null, 2)
      );
    }

    if (!publishAssetData.errors) {
      break;
    }

    console.log(
      `Attempt ${
        retryCount + 1
      } failed. Press 'r' to retry or any other key to exit.`
    );
    const userInput = await new Promise((resolve) => {
      process.stdin.once("data", (data) => {
        resolve(data.toString().trim().toLowerCase());
      });
    });

    if (userInput === "r") {
      retryCount++;
    } else {
      throw new Error(
        `Failed to publish asset: ${JSON.stringify(publishAssetData.errors)}`
      );
    }
  }

  if (retryCount === maxRetries) {
    throw new Error(
      `Failed to publish asset after ${maxRetries} attempts: ${JSON.stringify(
        publishAssetData.errors
      )}`
    );
  }

  if (LOG_VERBOSE) console.log("Asset published successfully");
}

function getPDFs() {
  const grepCommand = `find "${ROOT_DIR}" -type f -name "*.pdf" | grep "${GREP}" | sort -r`;
  const output = execSync(grepCommand, { encoding: "utf-8" });
  return output.trim().split("\n").filter(Boolean);
}

async function promptUser(question) {
  return new Promise((resolve) => {
    rl.question(question, (answer) => {
      resolve(answer.trim());
    });
  });
}

async function replaceAssets() {
  try {
    if (LOG_VERBOSE) console.log("Starting asset replacement process");
    const PDFs = getPDFs();

    if (PDFs.length === 0) {
      console.log("No modified PDF files found.");
      return;
    }

    const prompt = new MultiSelect({
      name: "files",
      message: "Select the files you want to upload",
      choices: PDFs.map((file, index) => ({
        name: file,
        value: index,
      })),
      result(names) {
        return this.map(names);
      },
    });

    const selectedIndices = await prompt.run();
    const selectedFiles = Object.values(selectedIndices).map(
      (index) => PDFs[index]
    );

    const uploadedAssets = [];

    for (const file of selectedFiles) {
      const fileName = path.basename(file);
      const assetId = await getAssetIdByFileName(fileName);
      if (LOG_VERBOSE) console.log(`Asset ID to replace: ${assetId}`);

      const updatedAsset = await updateAsset(assetId);
      await uploadFile(updatedAsset.upload.requestPostData, file);
      uploadedAssets.push(assetId);
    }

    if (uploadedAssets.length === 0) {
      console.log("No assets were uploaded.");
      return;
    }

    console.log(
      `All selected files have been uploaded. (${uploadedAssets.length}/${selectedFiles.length})...`
    );

    await new Promise((resolve) => setTimeout(resolve, 3000));

    const publishPrompt = new Toggle({
      message: "Do you want to publish all uploaded assets?",
      enabled: "Yes",
      disabled: "No",
    });

    const publishChoice = await publishPrompt.run();

    if (publishChoice) {
      for (const assetId of uploadedAssets) {
        await publishAsset(assetId);
      }
      console.log("All assets have been published.");
    } else {
      console.log("Assets were not published.");
    }
  } catch (error) {
    console.error("Error:", error.message);
  } finally {
    rl.close();
  }
}

replaceAssets();
