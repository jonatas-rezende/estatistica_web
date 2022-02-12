# exemplo 1 
#
# entrando com o número de repetições
r <- 4
# entrando com os dados
insulina <- c(1.59, 1.73, 3.64, 1.97, 3.36, 4.01, 3.49, 2.89, 3.92, 4.82, 3.87, 5.39)
# entrando com os níveis da insulina (Tratamentos)
trat <- c(rep("Baixo", r), rep("Medio", r), rep("Alto", r))
# calculando a média geral
m.geral<- mean(insulina) 
# estabelecendo o objeto trat com fator e guardando no próprio objeto trat
trat <- factor(trat)
trat
# armazenando os nomes dos níveis dos fatores
n.trat <- levels(trat)
# aplicando o comando tapply ao objeto insulina para o cálculo dos
# totais dos tratamentos
t.trat <- tapply(insulina, trat, sum)
t.trat
# aplicando o comando tapply ao objeto insulina para o cálculo das
# médias dos tratamentos
m.trat <- tapply(insulina, trat, mean)
m.trat
# aplicando o comando tapply ao objeto insulina para o cálculo dos
# desvio-padrões dos tratamentos
sd.trat <- tapply(insulina, trat, sd)
sd.trat
# mostrando os gráficos box plot para cada tratamento
boxplot(insulina~trat, horizontal=T,xlab="Quantidade de insulina",col="blue")
boxplot(insulina~trat, vertical=T,ylab="Quantidade de insulina",col="green")
# fazendo a análise de variância
insulina.av <- aov(insulina~trat)
#imprimindo o quadro da anova
summary(insulina.av)

#Separar os dados

cat(GLTratamento)
cat(GLResiduo)
cat(SomaQuadradosTratamento)
