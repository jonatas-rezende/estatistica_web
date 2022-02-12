<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="left">
<iframe width="100%" height="400" src="https://www.youtube.com/embed/GP6TDuu_wwg" frameborder="0" allowfullscreen></iframe>
    <span>
        <p align="justify"><b>Seja bem-vindo(a) ao EstatísticSI!</b><br><br>
        Aqui você tem acesso a um conteúdo pensado pra facilitar o aprendizado
        em estatística. <b>Feito para você</b>, o EstatísticSI atua na obtenção de análises estatísticas trazendo 
        interatividade e conhecimento ao passo que estimula e promove a importância da estatística.<br><br>
        O design do EstatísticSI foi feito da forma mais intuitiva possível, tudo para
        facilitar e acelerar o seu contato com tudo que a estatística pode oferecer.<br><br>
        O sistema oferece ainda os <b>Drops</b> que são vídeos curtos,
        de no máximo 2 minutos com informações essenciais sobre cada cálculo disponível,
        e cada Drop é traduzido para a Língua Brasileira de Sinais, o que aumenta a inclusão
        do software em um ensino mais igualitário para todos.<br><br>
        Desenvolvido pelos alunos da primeira turma do curso de Sistemas de Informação
        do Instituto Federal Goiano - Campus Ceres, este software é totalmente colaborativo,
        ou seja, você pode desenvolver melhorias que poderão ser acresentadas ao projeto.<br><br>
        Fique a vontade e aproveite tudo que EstatísticSI é capaz de oferecer!<br><br></p>

    </span>
</div>
<div class="right">
    <form action="./ProjetoControle?operacao=Calcular" method="post">
        <h3>Vamos come&ccedil;ar!</h3>
        <label for="tipo">Calcular Estatística Descritiva (Média, Moda, Mediana, Variância, Desvio Padrão, Coeficiente de Variação, etc).</label>
        <br/>

        <label for="dados">Insira o conjunto de dados separado por ponto e vírgula</label>
        <input type="text" name="dados" id="dados" placeholder="2;3;5;6;9" value="${dados}">
        <button>Executar</button>
    </form>

    <h3>Resultado</h3>
    <span >
        <fmt:setLocale value="pt_BR" />
        
        Média: <fmt:formatNumber type="number" value="${ed.media}" maxFractionDigits="3" /> <br><br>
        Moda: <fmt:formatNumber type="number" value="${ed.moda}" maxFractionDigits="3" /> <br><br>
        Mediana:  <fmt:formatNumber type="number" value="${ed.mediana}" maxFractionDigits="3" /> <br><br>
        Desvio Padrão:  <fmt:formatNumber type="number" value="${ed.desvioPadrao}" maxFractionDigits="3" /><br><br>
        Variância: <fmt:formatNumber type="number" value="${ed.variancia}" maxFractionDigits="3" /> <br><br>
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
        <span>Conte-nos como foi sua experiência com nosso sistema!</span>

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