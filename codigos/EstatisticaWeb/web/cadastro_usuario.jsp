<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		
		<title>Estat&iacute;sticSI</title>
		<link rel="shortcut icon" href="../img/logo.ico" type="x-icon">
		
		<style>
			*{ box-sizing: border-box;}
			a{color: inherit; text-decoration: none}
			a:hover{text-decoration: underline; color: #0C61B3;}
			body{padding:0; margin:0; font-family: arial; font-size: 12px;}
			main{
				width:100%;
				min-height:100vh;
				
				display:flex;
				justify-content:center;
				align-items:center;
				flex-flow:column wrap;
				
			}
			
			main .login{
				width:350px;
				height:auto;
				border:1px solid #999;
				background-color:#EDEDED;
				
				padding:60px 20px;
				
				display:flex;
				justify-content:center;
				align-items:center;
				flex-flow:column wrap;
			}
			
			
			main .login input[type="text"], input[type="email"], main .login input[type="password"] {
				width:90%;
				margin:5px 0px;
				padding:10px;

				border-radius: 2px;
				border: 1px solid #0C61B3 !important;
				color: #0C61B3;
			}
			
			main .login .logo{
				width:175px;
				height:140px;

				background:url("img/logo_login.png") no-repeat center center;
				margin-bottom: 20px;				
				padding:20px;
			}

			main #box-blue{
				width: 100%;
				height: 180px;
				background-color:#0C61B3;

				position: absolute;
				z-index: -1;
			}
			
			main nav{
				width:100%;
				height:auto;
			}

			main nav ul{
				width:100%;
				height:auto;

				list-style: none;
				display: flex;
				justify-content: center;
				padding: 0px;
				margin:0px;
			}

			main nav ul li{
				margin:0px 20px;
			}
			

			/* CLASSES GENERICAS */
			main .btn{
				padding: 5px 20px; 
				border-radius: 2px;
				height: auto;
				border: 1px solid #0C61B3 !important;
				color: #0C61B3;
				text-transform: uppercase;
			}

			main .btn:hover{
				border: 1px solid #0C61B3 !important;
				background-color: #0C61B3;
				color: #fff;
			}

			main .btn-login{
				margin-top: 15px;
				margin-bottom: 25px;
				padding: 10px 30px; 
			}

			main .nav-footer{

				height: 60px;
				position: absolute;
				bottom: 0;

				display: flex;
				background-color: #f35;
				align-items: center;

				align-self: flex-end;
				background-color:#EDEDED;

				color: #0C61B3;
			}
						
		</style>
	</head>
	
	<body>		
            
	<main>	
            <form class="login" method="post" action="./UsuarioControle?operacao=Cadastrar">
                <nav>
                        <ul>
                                <li><font style='font-weight:bold;' face="arial" color="#0C61B3" size='4px'>Cadastro de Usuário</font></li>
                        </ul>
                </nav>

                <input type="hidden" name="id" value="${usuario.id}" />

                <div class="logo"></div>

                <font style='font-weight:bold;' face="arial" color="#0C61B3">Nome Completo</font>
                <input type="text" name="nome" placeholder="Seu nome" required="true" value="${nome}"/>
                <font style='font-weight:bold;' face="arial" color="#0C61B3">E-mail</font>
                <input type="email" name="email" placeholder="seu_email@email.com" required="true" value="${email}" />
                <font style='font-weight:bold;' face="arial" color="#0C61B3">Senha</font>
                <input type="password" name="senha" placeholder="Sua senha" required="true" value="${senha}"/>

                <input class="btn btn-login" type="submit" value="COMEÇAR" />
            </form>
            <!--box blue center-->
            <div id="box-blue"></div>

            <!--nav bottom view-->
            <nav class="nav-footer">
                    <ul>   
                            <li><a href="paginas/conheca_software.html" target="_blank">CONHEÇA NOSSO SOFTWARE ESTATISTICO</a></li>
                            <li><a href="paginas/como_ajudar.html" target="_blank">COMO AJUDAR?</a></li>
                            <li><a href="paginas/contato.html">CONTATO</a></li>
                    </ul>
            </nav>
        </main>		
    </body>
</html>