#Valores de teste
#y <- c(5.2,5.1,4.9,4.6,4.7,4.8,4.6,4.9) 
#x <- c(13,15,18,20,19,17,21,16)

setwd("/home/andrey/Documentos/projetos/estatisticaweb/scripts/")
library("rjson")

# O arquivo é lido e os dados armazenados como uma lista.
entrada <- fromJSON(file = "entrada.json")

# converter os dados para um quadro de dados R
dados <- as.data.frame(entrada)
x = dados$entrada


#Calculo do Coeficiente de Determinacao
result = cor(x,y)^2

cat(result)
