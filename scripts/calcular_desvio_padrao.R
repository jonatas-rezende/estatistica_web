#Vetor contendo os n�meros utilizado para testar.
#x <- c(65, 72, 70, 72, 60, 67, 69, 68)


setwd("/home/andrey/Documentos/projetos/estatisticaweb/scripts/")
library("rjson")

# O arquivo � lido e os dados armazenados como uma lista.
entrada <- fromJSON(file = "entrada.json")

# converter os dados para um quadro de dados R
dados <- as.data.frame(entrada)
x = dados$entrada


#Fun��o utilizada para calcular o desvio padr�o.
desvioPadrao = sd(x)

cat(desvioPadrao)


