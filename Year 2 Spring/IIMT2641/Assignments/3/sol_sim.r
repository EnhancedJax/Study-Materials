setwd("/Users/jax/Documents/Study-Materials/Year 2 Spring/IIMT2641/Assignments/3/")

data <- read.csv("ClimateChange.csv")

# Split to training and test (2006 sep)
train <- subset(data, Year <= 2006)
test <- subset(data, Year > 2006)

# The predictors are: CFC.11, CFC.12, CO2, N2O, CH4, Aerosols, TSI, MEI
full_model <- lm(Temp ~ CFC.11 + CFC.12 + CO2 + N2O + CH4 + Aerosols + TSI + MEI, data = train)
full_summary <- summary(full_model)
print(full_summary)

indep_vars <- train[, c("CFC.11", "CFC.12", "CO2", "N2O", "CH4", "Aerosols", "TSI", "MEI")]
cor_matrix <- cor(indep_vars, use = "complete.obs")
print(cor_matrix)

simpl_model <- lm(Temp ~ MEI + TSI + Aerosols + N2O, data = train)
simpl_summary <- summary(simpl_model)

print("Simplified model summary:")
print(simpl_summary)

n2o_coeff_full <- full_summary$coefficients["N2O", "Estimate"]
n2o_coeff_simpl <- simpl_summary$coefficients["N2O", "Estimate"]
print(paste("Coefficient for N2O in full model:", round(n2o_coeff_full, 3)))
print(paste("Coefficient for N2O in simplified model:", round(n2o_coeff_simpl, 3)))

test_predictions <- predict(simpl_model, newdata = test)

# Compute the R-squared on the test set
SSE <- sum((test$Temp - test_predictions)^2)
SST <- sum((test$Temp - mean(train$Temp))^2)
r_squared_test <- 1 - SSE/SST

print(paste("Test set R-squared (simplified model):", round(r_squared_test, 4)))