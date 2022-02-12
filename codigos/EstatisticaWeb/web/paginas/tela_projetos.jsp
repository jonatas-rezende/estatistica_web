<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="./css/projetos.css" />
    
            <section class="box-learning">
                <div class="left">
                    <div class="box">
                        <font color="#0C61B3"><h3>Projetos</h3></font>
                        <ul>
                        <c:forEach items="${projetos}" var="projeto">
                            <li>${projeto.nome}</li>
                        </c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="right">
                    
		<img id="imagem" src="./img/logo_grande.png" alt="Logo do sistema" height="500" width="800">

		<a href="./ProjetoControle?operacao=ExibirAprendizagem"><div class="btn">Novo projeto</div></a>

                        
                </div>
            </section>