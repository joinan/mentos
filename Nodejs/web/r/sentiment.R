args <- commandArgs(TRUE)
id <- args[1]
library(rJava)
library(KoNLP)
useSejongDic()
library(mongolite)
library(jsonlite)
setwd("/Users/joinhwan/git/mentos/Nodejs/web/r")
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
connection <- mongo("mentos", url = "mongodb://localhost:27017/mentos")
mongodata <- connection$find(paste0('{"_id": {"$oid":"',id,'"}}'))
contentarray <- mongodata[3]
c_content <- contentarray[,1]
STR <- extractNoun(c_content)
RELAXCount <- match(STR, RELAX)
BORINGCount <- match(STR, BORING)
HAPPYCount <- match(STR, HAPPY)
ANGERCount <- match(STR, ANGER)
FEARCount <- match(STR, FEAR)
HATECount <- match(STR, HATE)
DEPRESSCount <- match(STR, DEPRESS)
RELAXSum <- sum(!is.na(RELAXCount))
BORINGSum <- sum(!is.na(BORINGCount))
HAPPYSum <- sum(!is.na(HAPPYCount))
ANGERSum <- sum(!is.na(ANGERCount))
FEARSum <- sum(!is.na(FEARCount))
HATESum <- sum(!is.na(HATECount))
DEPRESSSum <- sum(!is.na(DEPRESSCount))
sum1 <- c(RELAXSum, BORINGSum, HAPPYSum, ANGERSum, FEARSum, HATESum, DEPRESSSum)
sum2 <- c(DEPRESSSum, HATESum, FEARSum, ANGERSum, HAPPYSum, BORINGSum, RELAXSum)
if(which.max(sum1) == which.max(sum2)) {
  if(which.max(sum1)==4){
    index <- 4
  }else {
    index <- 0
  }
}else {
  index <- which.max(sum1)
}
connection$update(query = paste0('{"_id": {"$oid":"',id,'"}}'),update = paste0('{ "$set" : { "c_sentiment" : ',index,'} }'))