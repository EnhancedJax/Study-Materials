
PredictTest <- predict(QualityModel2, type="response", newdata=QualityTest)
table(QualityTest$PoorCare, PredictTest > 0.5)

# in class predict: estimate a model with all IDs, then compare the performance of this model with QUalityModel2 using AUC and out-of sample accuracy
QualityModel6 <- glm(PoorCare ~ ., data=QualityTrain, family=binomial(link="logit"))
PredictTrain <- predict(QualityModel6, type="response")

