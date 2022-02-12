# instalando o pacote ExpDes (Experimental Designs)
#
install.packages("ExpDes")
# requerendo o ExpDes
require(ExpDes)
# sintaxe do comando que faz a ANOVA no ExpDes
# crd(treat, resp, quali = TRUE, mcomp = "tukey", sigT = 0.05, sigF = 0.05)
crd(trat,insulina,mcomp=F)