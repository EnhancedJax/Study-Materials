setwd("/Users/jax/Documents/Study-Materials/Year 2 Spring/IIMT2641/Assignments/3/")

data <- read.csv("ClimateChange.csv")

# Split to training and test (2006 sep)
train <- subset(data, Year <= 2006)
test <- subset(data, Year > 2006)

# The predictors are: CFC.11, CFC.12, CO2, N2O, CH4, Aerosols, TSI, MEI
full_model <- lm(Temp ~ CFC.11 + CFC.12 + CO2 + N2O + CH4 + Aerosols + TSI + MEI, data = train)
full_summary <- summary(full_model)

# (a)(i) Print the linear regression equation produced by your model.
coeffs <- coef(full_model)
equation <- paste0("Temp = ", round(coeffs[1], 3))
for (i in 2:length(coeffs)) {
  term <- paste0(" + ", round(coeffs[i], 3), " * ", names(coeffs)[i])
  equation <- paste0(equation, term)
}
print("Full model regression equation:")
print(equation)

# (a)(ii) Evaluate the quality of the model: print the Multiple R-squared and list significant variables.
r_squared_full <- full_summary$r.squared
print(paste("Multiple R-squared (full model):", round(r_squared_full, 4)))

# Extract p-values for all coefficients
coef_table <- full_summary$coefficients
p_values <- coef_table[, "Pr(>|t|)"]
signif_vars <- names(p_values)[p_values < 0.05]
print("Significant independent variables (p < 0.05) in the full model:")
print(signif_vars)

# (a)(iii) Provide explanation for unexpected signs of N2O and CFC.11 coefficients.
print("Explanation for negative coefficients for N2O and CFC.11:")
print("These unexpected negative coefficients can arise from multicollinearity. When predictors are highly correlated,")
print("their individual coefficients can have signs that seem counter-intuitive, even though they collectively contribute")
print("to predicting the outcome. In other words, the overlap in predictive information among the correlated variables")
print("can distort the individual coefficient estimates.")

# (a)(iv) Compute correlations between all independent variables in the training set.
# Variables: CFC.11, CFC.12, CO2, N2O, CH4, Aerosols, TSI, MEI.
indep_vars <- train[, c("CFC.11", "CFC.12", "CO2", "N2O", "CH4", "Aerosols", "TSI", "MEI")]
cor_matrix <- cor(indep_vars, use = "complete.obs")
print("Correlation matrix among independent variables (training set):")
print(cor_matrix)

# Find which variables are highly correlated with N2O (absolute correlation > 0.7)
n2o_cor <- cor_matrix["N2O", ]
high_n2o <- names(n2o_cor)[abs(n2o_cor) > 0.7 & names(n2o_cor) != "N2O"]
print("Variables highly correlated with N2O (|r| > 0.7):")
print(high_n2o)

# Find which variables are highly correlated with CFC.11 (absolute correlation > 0.7)
cfc11_cor <- cor_matrix["CFC.11", ]
high_cfc11 <- names(cfc11_cor)[abs(cfc11_cor) > 0.7 & names(cfc11_cor) != "CFC.11"]
print("Variables highly correlated with CFC.11 (|r| > 0.7):")
print(high_cfc11)

print("=======")

# ================================
# (b) Simplified Model using MEI, TSI, Aerosols, and N2O
# ================================
simpl_model <- lm(Temp ~ MEI + TSI + Aerosols + N2O, data = train)
simpl_summary <- summary(simpl_model)

print("Simplified model summary:")
print(simpl_summary)

# (b)(i) Compare the coefficient for N2O in the simplified model to the coefficient in the full model.
n2o_coeff_full <- full_summary$coefficients["N2O", "Estimate"]
n2o_coeff_simpl <- simpl_summary$coefficients["N2O", "Estimate"]
print(paste("Coefficient for N2O in full model:", round(n2o_coeff_full, 3)))
print(paste("Coefficient for N2O in simplified model:", round(n2o_coeff_simpl, 3)))

# (b)(ii) Compare model quality: R-squared and significance of independent variables.
r_squared_simpl <- simpl_summary$r.squared
print(paste("Multiple R-squared (simplified model):", round(r_squared_simpl, 4)))
print("Summary of the simplified model coefficients and their significance:")
print(simpl_summary$coefficients)
print("Comparison:")
print("The simplified model may have a lower (or higher) R-squared than the full model, and the significance of the")
print("coefficients might change when fewer predictors (and thus, less collinearity) are included. This helps illustrate")
print("the impact of multicollinearity and model parsimony on the estimates.")

print("=======")

# ================================
# (c) Evaluate Model on Test Set (Using the simplified model)
# ================================
# Generate predictions for the testing dataset
test_predictions <- predict(simpl_model, newdata = test)

# Compute the R-squared on the test set
RSS <- sum((test$Temp - test_predictions)^2)
TSS <- sum((test$Temp - mean(test$Temp))^2)
r_squared_test <- 1 - RSS/TSS

print(paste("Test set R-squared (simplified model):", round(r_squared_test, 4)))
print("Interpretation: The test set R-squared shows how well the model performs on unseen data. A lower value")
print("relative to the training set R-squared is indicative of potential overfitting or that the model may not")
print("generalize well to new data.")
print("=======")