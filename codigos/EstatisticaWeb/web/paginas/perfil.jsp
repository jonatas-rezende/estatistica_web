<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="./css/perfil.css" />

<div class="one">
    <div class="box">
       <font color="#0C61B3"><h3>Meu perfil</h3></font>
        <ul>
            <a href="paginas/redefinir_senha.html" target="_blank"><li>Alterar Senha</li></a>
        </ul>
    </div>

    <div class="box">
       <font color="#0C61B3"><h3>Sobre o EstatísticSI</h3></font>
        <span align="justify">O EstatisticSI possibilita a utiliza&ccedil;ão 
de várias fun&ccedil;oes estatisticas, desde medias até mesmo DICs com mapeamento aleatorizado</span>
        <a href="./ProjetoControle?operacao=ExibirAprendizagem"><div class="btn">Vamos Come&ccedil;ar</div></a>
    </div>

</div>
<div class="two">

    <div class="box">
        <font color="#0C61B3"><h3>${usuario.nome}</h3></font>
        <span>   &rarr; ${usuario.email}</span>
    </div>

    <div class="box">
        <font color="#0C61B3"><h3>Projetos</h3></font>
        <ul>
            <c:forEach items="${projetos}" var="projeto">
                <li>${projeto.nome}</li>
            </c:forEach>
        </ul>

        <a href="./ProjetoControle?operacao=ExibirProjetosPagina"><div class="btn">Ver Mais</div></a>
    </div>

</div>
<div class="three">

    <div class="box">
        <iframe src="https://www.youtube.com/embed/GP6TDuu_wwg" frameborder="0" allowfullscreen></iframe>
        <span>DROP: História de Estatística</span>
        <a href="./ProjetoControle?operacao=ExibirDrops"><div class="btn">Ver Mais</div></a>
    </div>
    <div class="box">
        <iframe src="https://www.youtube.com/embed/Er0Ya6BEy2o" frameborder="0" allowfullscreen></iframe>
        <span>DROP: Média</span>
        <a href="./ProjetoControle?operacao=ExibirDrops"><div class="btn">Ver Mais</div></a>
    </div>
    <div class="box">
        <iframe src="https://www.youtube.com/embed/oSdTBYctzpM" frameborder="0" allowfullscreen></iframe>
        <span>DROP: Moda</span>
        <a href="./ProjetoControle?operacao=ExibirDrops"><div class="btn">Ver Mais</div></a>
    </div>

</div>