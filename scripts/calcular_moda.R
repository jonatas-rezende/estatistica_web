# Função para calcular a moda

setwd("/home/andrey/Documentos/projetos/estatisticaweb/scripts/")
library("rjson")

# O arquivo é lido e os dados armazenados como uma lista.
entrada <- fromJSON(file = "entrada.json")

# converter os dados para um quadro de dados R
dados <- as.data.frame(entrada)
x = dados$entrada


moda  <- function(x){
  unicox <- unique(x)
  unicox[which.max(tabulate(match(x,unicox)))]
}

# Valores para o teste
#x <- c(15,9,15,7,15,3,9,8,15,8,16,12)

# Calculando a moda
calc_moda <- moda(x)
cat(calc_moda)
