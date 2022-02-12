#install.packages("moments", repos='http://cran.us.r-project.org') #Comando para instalar o pacote "moments"

library(moments) #Inclusão da biblioteca "moments"

setwd("/home/andrey/Documentos/projetos/estatisticaweb/scripts/")
library("rjson")

# O arquivo é lido e os dados armazenados como uma lista.
entrada <- fromJSON(file = "entrada.json")

# converter os dados para um quadro de dados R
dados <- as.data.frame(entrada)
x = dados$entrada


k = kurtosis(x) #Calculo do coeficiente de curtose

cat(k)
