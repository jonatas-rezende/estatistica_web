# Valores para o teste
#x <- c(15,9,1,7,18,3,98,-15,13,-5,17,-1)

# Calculando a mediana
setwd("/home/andrey/Documentos/projetos/estatisticaweb/scripts/")
library("rjson")

# O arquivo é lido e os dados armazenados como uma lista.
entrada <- fromJSON(file = "entrada.json")

# converter os dados para um quadro de dados R
dados <- as.data.frame(entrada)
x = dados$entrada

mediana <- median(x)

cat(mediana)
