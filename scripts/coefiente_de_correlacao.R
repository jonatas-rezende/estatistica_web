# valores para teste
#x=c(1,2,3,4,5); y=c(1,1,2,2,4); 

setwd("/home/andrey/Documentos/projetos/estatisticaweb/scripts/")
library("rjson")

# O arquivo é lido e os dados armazenados como uma lista.
entrada <- fromJSON(file = "entrada.json")

# converter os dados para um quadro de dados R
dados <- as.data.frame(entrada)
x = dados$entrada


# calculando o coeficiente de correlação 
result = cor(x,y)

cat(result)

