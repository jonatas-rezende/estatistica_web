# instalar o pacote rjson (uma única vez)
# execute o comando no R Console:   install.packages("rjson")

#informa a biblioteca
library("rjson")

#informa a pasta de origem do arquivo
setwd("C:\\Users\\qualq\\Documents\\GitHub\\estatisticaweb\\pesquisas\\interacao_R\\codigos")

# O arquivo é lido e os dados armazenados como uma lista.
result <- fromJSON(file = "saida.json")

# converter os dados para um quadro de dados R
result1 <- as.data.frame(result)

# converter texto em número
aux <- apply(result1,1,as.numeric)

cat(median(aux))
