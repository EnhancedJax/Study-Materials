# Linear Regression in R 

setwd('/Users/jax/Documents/Study-Materials/Year\ 2\ Spring/IIMT2641/Code')
getwd()

Wine <- read.csv("Wine.csv") # Read the data into R
summary(Wine) # Check summary statistics

par(mfrow=c(2,2)) # Set up a 2x2 grid so we can look at 4 plots in one graph
plot(Wine$Age, Wine$LogPrice, main="Scatterplot of Price vs. Age")
plot(Wine$AGST, Wine$LogPrice, main="Scatterplot of Price vs Average growing season temperature")
plot(Wine$HarvestRain, Wine$LogPrice, main="Scatterplot of Price vs Harvest rain")
plot(Wine$WinterRain, Wine$LogPrice, main="Scatterplot of Price vs Winter rain")
par(mfrow=c(1,1)) # Return to the default setting/size

plot(Wine$AGST, Wine$LogPrice, main="Scatterplot of Price vs Average growing season temperature")
abline(-1.25, 0.5, col="blue")

WineRegOne <- lm(LogPrice ~ AGST, data=Wine) # linear regression model
summary(WineRegOne)
plot(Wine$AGST, Wine$LogPrice, main="Scatterplot of Price vs Average growing season temperature")
abline(WineRegOne, col="red") # plot the regression line

WineRegOne$residuals # residuals of the model 
SSE = sum(WineRegOne$residuals^2) # residuals of the model 

# calculate SST & R-squared
ybar = mean(Wine$LogPrice) 
resi = Wine$LogPrice - ybar
SST = sum(resi^2)
1 - SSE/SST

WineRegTwo <- lm(LogPrice ~ AGST + HarvestRain, data=Wine) # linear regression model2
summary(WineRegTwo)
SSE = sum(WineRegTwo$residuals^2)

WineReg <- lm(LogPrice ~ WinterRain + AGST + HarvestRain + Age + FrancePop, data=Wine) # linear regression model
summary(WineReg)  # Check the regression results
SSE = sum(WineReg$residuals^2)

cor(Wine$HarvestRain, Wine$AGST) # Correlation between Harvest rain and AGST 
plot(Wine$HarvestRain, Wine$AGST, ylab = "Average growing season temperature", xlab = "Harvest rain")
cor(Wine$Age, Wine$FrancePop) # Correlation between Wine age and Population of France
plot(Wine$Age, Wine$FrancePop, ylab = "France population", xlab = "Age of wine")

library(car) #load the car library
vif(WineReg) #calculate the VIF for each predictor variable in the model

WineRegFour <- lm(LogPrice ~ WinterRain + AGST + HarvestRain + Age , data=Wine) # linear regression model
summary(WineRegFour)  # Check the regression results

library(car) #load the car library
vif(WineRegFour) #calculate the VIF for each predictor variable in the model


# Make Predictions
WineTest <- read.csv("WineTest.csv")
WinePredictions <- predict(WineRegFour, newdata=WineTest)
str(WinePredictions)

# Out-of-sample R^2
SSE <- sum((WineTest$Price - WinePredictions)^2)
SST <- sum((WineTest$Price - ybar)^2)
1 - SSE/SST
