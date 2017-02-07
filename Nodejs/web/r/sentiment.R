library(rJava)
library(KoNLP)
useSejongDic()
library(mongolite)
setwd("/Users/joinhwan/nodejs/mentos/web")
attach(input[[1]])
number
RELAX <- read.table("relax.txt", header = FALSE, stringsAsFactors = FALSE)
RELAX <- RELAX[,1]
BORING <- read.table("boring.txt", header = FALSE, stringsAsFactors = FALSE)
BORING <- BORING[,1]
HAPPY <- read.table("happy.txt", header = FALSE, stringsAsFactors = FALSE)
HAPPY <- HAPPY[,1]
ANGER <- read.table("anger.txt", header = FALSE, stringsAsFactors = FALSE)
ANGER <- ANGER[,1]
FEAR <- read.table("fear.txt", header = FALSE, stringsAsFactors = FALSE)
FEAR <- FEAR[,1]
HATE <- read.table("hate.txt", header = FALSE, stringsAsFactors = FALSE)
HATE <- HATE[,1]
DEPRESS <- read.table("depress.txt", header = FALSE, stringsAsFactors = FALSE)
DEPRESS <- DEPRESS[,1]
qry <- paste('{"c_no":', 12, '}')
connection <- mongo("mentos", url = "mongodb://localhost:27017/mentos")
mongodata <- connection$find(qry)
no <- mongodata[1]
strNum <- nrow(no)
title <- mongodata[2]
contentarray <- mongodata[3]
content <- contentarray[,1]
STR <- extractNoun(content[1])
PosCount <- match(STR, POSITIVE)
NegCount <- match(STR, NEGATIVE)
PosSum <- sum(!is.na(PosCount))
NegSum <- sum(!is.na(NegCount))