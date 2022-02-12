# inserindo valores observados na pesquisa
A <- c(289,27) # criando o vetor da linha 1 com 2 colunas
B <- c(737,83) # criando o vetor da linha 2 com 2 colunas
# somando as linhas 1 e 2
tot.A <- sum(A)
tot.B <- sum(B)
# para somar as colunas basta fazer o calculo uma vez, ele soma v1 da A com a v1 da B
# e assim até terminar as colunas
som.colunas <- (A+B) 
# basta somar o resultado das linhas
tot.geral <- (tot.A+tot.B) 
# calculando o valor esperado de cada valor, só calcula uma vez para cada linha
# o valor esperado é igual a soma da coluna multiplicado pela soma da linha dividido
# pela soma geral
esp.A <- som.colunas*tot.A/tot.geral
esp.B <- som.colunas*tot.B/tot.geral
# para facilitar separei a formula do qui-quadrado
# nessa fase, calcula a diferença entre o valor observado e o valor esperado
# novamente, calcula correspondente a linha, onde todos os valores existentes são calculados
dif.A <- A - esp.A
dif.B <- B - esp.B
# calculando o qui-quadrado individual
A.qui2 <- dif.A^2/esp.A
B.qui2 <- dif.B^2/esp.B
# calculando e exibindo o valor de qui-quadrado da pesquisa
qui2total <- sum(A.qui2)+sum(B.qui2)
qui2total