<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" type="text/css" href="./css/dic.css" />

<div class="left">
<iframe width="100%" height="400" src="https://www.youtube.com/embed/0C-ORdOqdPU" frameborder="0" allowfullscreen></iframe>
    <span>
        <p align="justify"><b>Seja bem-vindo(a) ao Estat�sticSI!</b><br><br>
        Aqui voc� pode executar o DIC (Delineamento Inteiramente Casualizado).<br><br>
        
        Ap�s preencher os campos, basta clicar em <b>Executar</b>, uma outra p�gina ir� abrir e nela
        voc� poder� continuar todo o processo do DIC!<br><br>
        
        Desenvolvido pelos alunos da primeira turma do curso de Sistemas de Informa��o
        do Instituto Federal Goiano - Campus Ceres, este software � totalmente colaborativo,
        ou seja, voc� pode desenvolver melhorias que poder�o ser acresentadas ao projeto.<br><br>
         Fique a vontade e aproveite tudo que Estat�sticSI � capaz de oferecer!<br><br></p>

    </span>
</div>
<div class="right">
    <form action="./ProjetoControle?operacao=ExibirAleatorizacao" method="post">
        <h3>Vamos come&ccedil;ar!</h3>
        <label for="tipo">Selecione a fun&ccedil;&atilde;o estat�stica que deseja executar</label>
       <select name="tipo" id="tipo">
            <option value="0" selected="">DIC</option>
       </select>

        <label for="data">Insira a quantidade de repeti&ccedil;&otilde;es</label>
       
        
        <input type="text" name="data" id="data" value="20" placeholder="Ex: 20">

        <label for="data">Insira os tratamentos separados por ponto e v�rgula</label>
        <input type="text" name="data" id="data" value="P, K" placeholder="Ex: P, K">

        <label for="data">Insira a vari�vel resposta</label>
        <input type="text" name="data" id="data" value="Tamanho da folha" placeholder="Ex: Tamanho da folha">

        <label for="data">Informe o nome do projeto</label>
        <input type="text" name="data" id="data" value="Tamanho_Folha" placeholder="Ex: Nome_Projeto">

        
        <button>Executar</button>
    </form>

        <hr>
        <span>Conte-nos como foi sua experi�ncia com nosso sistema!</span>

    </form>

</div>