#valores pra teste
#x <-c (2,4,5,6)


setwd("/home/andrey/Documentos/projetos/estatisticaweb/scripts/")

library("rjson")


# O arquivo é lido e os dados armazenados como uma lista.
entrada <- fromJSON(file = "entrada.json")

# converter os dados para um quadro de dados R
dados <- as.data.frame(entrada)
x = dados$entrada


#mostrar o maior e o menor numero
#maior_menor = range(x)

#cat(maior_menor)

#calculando a amplitude
resultado = min(x)

cat(resultado)
