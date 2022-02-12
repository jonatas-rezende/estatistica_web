<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
        <meta charset="utf-8" />

        <title>Estat&iacute;sticSI</title>

        <link rel="stylesheet" type="text/css" href="./css/icones.css" />
        <link rel="stylesheet" type="text/css" href="./css/layout.css" />
    </head>
    <body>
       <main>
            <nav class="principal">
                <div class="logo">
                    <img src="./img/logo_software.png" alt="Logo do Sistema" height="42" width="142">
                </div>
                <ul>
                    <a href="./ProjetoControle?operacao=ExibirAprendizagem" ><font color="#0C61B3"><li>INÍCIO</li></font></a>
                    <a href="./ProjetoControle?operacao=ExibirDIC"><font color="#0C61B3"><li>DIC</li></font></a>
                    <a href="./ProjetoControle?operacao=ExibirProjetosPagina"><font color="#0C61B3"><li>PROJETOS</li></font></a>
                    <a href="./ProjetoControle?operacao=ExibirDrops"><font color="#0C61B3"><li>DROPS</li></font></a>
                    <a href="paginas/cartilhas.html" target="_blank"><font color="#0C61B3"><li>CARTILHAS DE ESTATÍSTICA</li></font></a>
                </ul>
                <div id="user">
                    <a href="./UsuarioControle?operacao=Perfil">${usuario.nome}</a>
                </div>
                <div>
                    <ul>
                    <a href="./UsuarioControle?operacao=Sair"><font color="#FF0000"><li>SAIR</li></font></a>
                    </ul>
                </div>    
            </nav>

            <section class="box-learning">
                <jsp:include page="${pagina}" />
            </section>
       </main>
    </body>
</html>