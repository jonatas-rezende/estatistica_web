setwd("/home/andrey/Documentos/projetos/estatisticaweb/scripts/")
library("rjson")

# O arquivo � lido e os dados armazenados como uma lista.
entrada <- fromJSON(file = "entrada.json")

# converter os dados para um quadro de dados R
dados <- as.data.frame(entrada)
x = dados$entrada


#Valores para teste
#x <- c(65, 72, 70, 72, 60, 67, 69, 68)

#Calculando vari�ncia
variancia = var(x)
cat(variancia)
