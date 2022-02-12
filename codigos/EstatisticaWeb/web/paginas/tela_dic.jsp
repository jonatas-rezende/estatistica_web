<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" type="text/css" href="./css/dic.css" />

<div class="left">
<iframe width="100%" height="400" src="https://www.youtube.com/embed/0C-ORdOqdPU" frameborder="0" allowfullscreen></iframe>
    <span>
        <p align="justify"><b>Seja bem-vindo(a) ao EstatísticSI!</b><br><br>
        Aqui você pode executar o DIC (Delineamento Inteiramente Casualizado).<br><br>
        
        Após preencher os campos, basta clicar em <b>Executar</b>, uma outra página irá abrir e nela
        você poderá continuar todo o processo do DIC!<br><br>
        
        Desenvolvido pelos alunos da primeira turma do curso de Sistemas de Informação
        do Instituto Federal Goiano - Campus Ceres, este software é totalmente colaborativo,
        ou seja, você pode desenvolver melhorias que poderão ser acresentadas ao projeto.<br><br>
         Fique a vontade e aproveite tudo que EstatísticSI é capaz de oferecer!<br><br></p>

    </span>
</div>
<div class="right">
    <form action="./ProjetoControle?operacao=ExibirAleatorizacao" method="post">
        <h3>Vamos come&ccedil;ar!</h3>
        <label for="tipo">Selecione a fun&ccedil;&atilde;o estatística que deseja executar</label>
       <select name="tipo" id="tipo">
            <option value="0" selected="">DIC</option>
       </select>

        <label for="data">Insira a quantidade de repeti&ccedil;&otilde;es</label>
       
        
        <input type="text" name="data" id="data" value="20" placeholder="Ex: 20">

        <label for="data">Insira os tratamentos separados por ponto e vírgula</label>
        <input type="text" name="data" id="data" value="P, K" placeholder="Ex: P, K">

        <label for="data">Insira a variável resposta</label>
        <input type="text" name="data" id="data" value="Tamanho da folha" placeholder="Ex: Tamanho da folha">

        <label for="data">Informe o nome do projeto</label>
        <input type="text" name="data" id="data" value="Tamanho_Folha" placeholder="Ex: Nome_Projeto">

        
        <button>Executar</button>
    </form>

        <hr>
        <span>Conte-nos como foi sua experiência com nosso sistema!</span>

    </form>

</div>