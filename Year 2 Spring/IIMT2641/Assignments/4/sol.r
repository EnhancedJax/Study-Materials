setwd("/Users/jax/Documents/Study-Materials/Year 2 Spring/IIMT2641/Assignments/4/")

loans <- read.csv("Loans.csv")
set.seed(1)
# Seems to need to use caTools to randomly split with ratio
library(caTools)
split <- sample.split(loans$NotFullyPaid, SplitRatio = 0.7)
Train <- subset(loans, split == TRUE)
Test <- subset(loans, split == FALSE)

# (a)(i)
baseline_accuracy=mean(Test$NotFullyPaid == 0)
cat("Baseline accuracy:", baseline_accuracy, "\n")

# (a)(ii)
model1=glm(NotFullyPaid ~ ., data=Train, family="binomial")
print(summary(model1))

# (a)(iii) 
loanA=loanB=Train[1, ]
loanA$Fico=700
loanB$Fico=710
logitA=predict(model1, newdata=loanA, type="link")
logitB=predict(model1, newdata=loanB, type="link")
logit_diff=logitA - logitB
cat("Logit(A) - Logit(B):", logit_diff, "\n")

# (a)(iv) 
TestPrediction1=predict(model1, newdata=Test, type="response")
print(table(Test$NotFullyPaid, TestPrediction1 >= 0.5)) # Confusion matrix

# (b)(i) Build model with only IntRate
model2=glm(NotFullyPaid ~ IntRate, data=Train, family="binomial")
print(summary(model2))

# (b)(ii)
TestPrediction2=predict(model2, newdata=Test, type="response")
max_prob=max(TestPrediction2)
num_predicted_unpaid=sum(TestPrediction2 >= 0.5)
cat("Highest predicted probability of non-payment:", max_prob, "\n")
cat("Number predicted as not paid (threshold 0.5):", num_predicted_unpaid, "\n")
