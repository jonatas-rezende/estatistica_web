<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		
		<title>Estat&iacute;sticSI</title>
		<link rel="shortcut icon" href="./img/logo.ico" type="x-icon">
                <link rel="stylesheet" type="text/css" href="./css/index.css" />
		
	</head>
	
	<body>		
            
		<main>
			<!--form login-->
                        <form class="login" method="post" action="./UsuarioControle?operacao=Logar">
                            
                                <div class="logo"></div>
                                <font color=green><b>${mensagem}</b></font>
				<input type="email" name="email" placeholder="Digite seu E-mail" required="true"/>
				<input type="password" name="senha" placeholder="Digite sua Senha" required="true" />
				
				<input class="btn btn-login" type="submit" value="login" />
                                
            
                                <font color=red><b>${erro}</b></font><br><br>

				<!--menu login-->
				<nav>
					<ul>
						<li> <a href="paginas/recuperar_senha.html">Esqueceu a Senha?</a></li>
						<li> <a href="cadastro_usuario.jsp">Criar uma conta</a></li>
					</ul>
				</nav>
				
			</form>

			<!--box blue center-->
			<div id="box-blue"></div>
			
			<!--nav bottom view-->
			<nav class="nav-footer">
				<ul>
					<li><a href="paginas/conheca_software.html" target="_blank">CONHE&Ccedil;A NOSSO SOFTWARE ESTATÍSTICO</a></li>
					<li><a href="paginas/como_ajudar.html" target="_blank">COMO AJUDAR?</a></li>
					<li><a href="paginas/contato.html" target="_blank">CONTATO</a></li>
				</ul>
			</nav>
			
		</main>		
	</body>
	
</html>
