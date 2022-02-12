# exemplo 1 
#
# entrando com o numero de repeticoes
r <- 4
# entrando com os dados
insulina <- c(1.59, 1.73, 3.64, 1.97, 3.36, 4.01, 3.49, 2.89, 3.92, 4.82, 3.87, 5.39)
# entrando com os niveis da insulina (Tratamentos)
trat <- c(rep("Baixo", r), rep("Medio", r), rep("Alto", r))
# calculando a mÃ©dia geral
m.geral<- mean(insulina) 
# estabelecendo o objeto trat com fator e guardando no proprio objeto trat
trat <- factor(trat)
#trat # Imprime a Aleatorização usada
# armazenando os nomes dos niveis dos fatores
n.trat <- levels(trat)
# aplicando o comando tapply ao objeto insulina para o calculo dos
# totais dos tratamentos
t.trat <- tapply(insulina, trat, sum)
#t.trat #Imprimetotais dos tratamentos
# aplicando o comando tapply ao objeto insulina para o calculo das
# medias dos tratamentos
m.trat <- tapply(insulina, trat, mean)
#m.trat # imprime a medias dos tratamentos
# aplicando o comando tapply ao objeto insulina para o calculo dos
# desvio-padrÃµes dos tratamentos
sd.trat <- tapply(insulina, trat, sd)
#sd.trat # Imprime desvio-padroes dos tratamentos
# mostrando os graficos box plot para cada tratamento
#boxplot(insulina~trat, horizontal=T,xlab="Quantidade de insulina",col="blue")
#boxplot(insulina~trat, vertical=T,ylab="Quantidade de insulina",col="green")
# fazendo a anÃ¡lise de variÃ¢ncia
insulina.av <- aov(insulina~trat)
#imprimindo o quadro da anova
x = summary(insulina.av)

#Quebrando a Tabela
f = data.frame(unclass(summary(insulina.av)), check.names = FALSE, stringsAsFactors = FALSE) 

#Retornando os dados 

cat (f$Df[1]) #Grau de Liberdade Trat.

cat (f$Df[2]) #Grau de Liberdade Erro


cat (f$`Sum Sq`[1])#Soma dos quadrados Trat.

cat (f$`Sum Sq`[2])#Soma dos quadrados Erro


cat (f$`Mean Sq`[1])#Quadrado Medio Trat.

cat (f$`Mean Sq`[2])#Quadrado Medio Erro


cat (f$`F value`[1])#F value


cat (f$`Pr(>F)`[1])#Pr(>F)
