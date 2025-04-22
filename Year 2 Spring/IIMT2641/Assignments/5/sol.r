# Load the dataset
dailykos <- read.csv("/Users/jax/Documents/Study-Materials/Year 2 Spring/IIMT2641/Assignments/5/DailyKos.csv")


# Compute distances
distances <- dist(dailykos, method = "euclidean")

# Hierarchical clustering
hierClust <- hclust(distances, method = "ward.D") 

# Plot the dendrogram
plot(hierClust, labels = FALSE, main = "Hierarchical Clustering Dendrogram (Daily Kos)", xlab = "", sub = "")

k <- 7 
rect.hclust(hierClust, k = k, border = "red")

# Assign observations to clusters
hierClusters <- cutree(hierClust, k = k)

# How many observations are in each cluster?
table(hierClusters)

# Split data by cluster
hierClusterData <- split(dailykos, hierClusters)

print("Hierarchical Cluster Sizes:")
print(table(hierClusters))

getTopWords <- function(cluster_df) {
  col_means <- colMeans(cluster_df)
  top_words <- tail(sort(col_means), 6)
  return(names(top_words))
}

# Get top words for each cluster
topWordsHier <- lapply(hierClusterData, getTopWords)

# Print top words for description
print("Top 6 words per Hierarchical Cluster:")
print(topWordsHier)

# ==================== K MEANS CLUSTERING =================

# Set seed for reproducibility
set.seed(1) 

kmeans <- kmeans(dailykos, centers = k, iter.max = 1000)

# How many observations are in each cluster?
kmeansClusters <- kmeans$cluster
table(kmeansClusters)

# Compare sizes with Hierarchical clustering.
print("K-means Cluster Sizes:")
print(table(kmeansClusters))

# Split data by K-means cluster
kmeansClusterData <- split(dailykos, kmeansClusters)

# Get top words for each K-means cluster
topWordsKMeans <- lapply(kmeansClusterData, getTopWords)

# Print top words for K-means clusters
print("Top 6 words per K-means Cluster:")
print(topWordsKMeans)