#install.packages("rjson",repos = "http://cran.us.r-project.org")

setwd("/home/aluno/git/estatisticaweb/scripts/")
library("rjson")

# O arquivo é lido e os dados armazenados como uma lista.
entrada <- fromJSON(file = "entrada.json")

# converter os dados para um quadro de dados R
dados <- as.data.frame(entrada)
x = dados$entrada

# valores testes
#x <- c(2, 4, 6, 8, 10, 20, 30, 8)
# contador (qtde de numeros)
#length(x)#A impressão desse valor, pode ser interpretado como resposta se for impresso
# calculando a mÃ©dia

media = sum(x)/length(x)

cat(media)
