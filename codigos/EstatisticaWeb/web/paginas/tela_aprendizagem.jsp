<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="left">
<iframe width="100%" height="400" src="https://www.youtube.com/embed/GP6TDuu_wwg" frameborder="0" allowfullscreen></iframe>
    <span>
        <p align="justify"><b>Seja bem-vindo(a) ao Estat�sticSI!</b><br><br>
        Aqui voc� tem acesso a um conte�do pensado pra facilitar o aprendizado
        em estat�stica. <b>Feito para voc�</b>, o Estat�sticSI atua na obten��o de an�lises estat�sticas trazendo 
        interatividade e conhecimento ao passo que estimula e promove a import�ncia da estat�stica.<br><br>
        O design do Estat�sticSI foi feito da forma mais intuitiva poss�vel, tudo para
        facilitar e acelerar o seu contato com tudo que a estat�stica pode oferecer.<br><br>
        O sistema oferece ainda os <b>Drops</b> que s�o v�deos curtos,
        de no m�ximo 2 minutos com informa��es essenciais sobre cada c�lculo dispon�vel,
        e cada Drop � traduzido para a L�ngua Brasileira de Sinais, o que aumenta a inclus�o
        do software em um ensino mais igualit�rio para todos.<br><br>
        Desenvolvido pelos alunos da primeira turma do curso de Sistemas de Informa��o
        do Instituto Federal Goiano - Campus Ceres, este software � totalmente colaborativo,
        ou seja, voc� pode desenvolver melhorias que poder�o ser acresentadas ao projeto.<br><br>
        Fique a vontade e aproveite tudo que Estat�sticSI � capaz de oferecer!<br><br></p>

    </span>
</div>
<div class="right">
    <form action="./ProjetoControle?operacao=Calcular" method="post">
        <h3>Vamos come&ccedil;ar!</h3>
        <label for="tipo">Calcular Estat�stica Descritiva (M�dia, Moda, Mediana, Vari�ncia, Desvio Padr�o, Coeficiente de Varia��o, etc).</label>
        <br/>

        <label for="dados">Insira o conjunto de dados separado por ponto e v�rgula</label>
        <input type="text" name="dados" id="dados" placeholder="2;3;5;6;9" value="${dados}">
        <button>Executar</button>
    </form>

    <h3>Resultado</h3>
    <span >
        <fmt:setLocale value="pt_BR" />
        
        M�dia: <fmt:formatNumber type="number" value="${ed.media}" maxFractionDigits="3" /> <br><br>
        Moda: <fmt:formatNumber type="number" value="${ed.moda}" maxFractionDigits="3" /> <br><br>
        Mediana:  <fmt:formatNumber type="number" value="${ed.mediana}" maxFractionDigits="3" /> <br><br>
        Desvio Padr�o:  <fmt:formatNumber type="number" value="${ed.desvioPadrao}" maxFractionDigits="3" /><br><br>
        Vari�ncia: <fmt:formatNumber type="number" value="${ed.variancia}" maxFractionDigits="3" /> <br><br>
        Curtose:  <fmt:formatNumber type="number" value="${ed.curtose}" maxFractionDigits="3" /> <br><br> 
        Amplitude:  <fmt:formatNumber type="number" value="${ed.amplitude}" maxFractionDigits="3" /> <br><br>
        Menor:  <fmt:formatNumber type="number" value="${ed.maior}" maxFractionDigits="3" /> <br><br>
        Maior:  <fmt:formatNumber type="number" value="${ed.menor}" maxFractionDigits="3" /> 
    </span>

    <form class="footer" method="post" action="./ProjetoControle?operacao=Cadastrar">
        <input type="hidden" value="${dadosCopia}" name="dadosCopia" id="dadosCopia" />
        <input type="text" name="nomeProjeto" id="nomeProjeto" placeholder="Digite o nome do projeto">
        <input type="submit" class="btn" value="Salvar Resultados"/>
        

        <hr>
        <span>Conte-nos como foi sua experi�ncia com nosso sistema!</span>

    </form>

</div>
        
<script type="text/javascript">
    function id( el ){
            return document.getElementById( el );
    }
    window.onload = function(){
            id('dados').onkeyup = function(){
                    id('dadosCopia').value = id('dados').value;
            };
    };
</script>