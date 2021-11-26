<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>CSO</title>
	<%@ include file="header.jsp" %>
</head>
<body>
	
	<%@ include file="menu.jsp" %>
	
	
	<div class="container">
    	<div class="row">
			<div class="panel panel-default m-2">
				<div class="panel-heading">Login</div>
				<form class="form-inline col-lg-3 col-md-6 col-sm-12 my-1" action=usuario method="post" accept-charset="ISO-8859-1" autocomplete="off">
					<input class="form-control my-1" type="text" name="cpf" placeholder="CPF" required>
					<input class="form-control my-1" type="password" name="senha" placeholder="Senha" required>
					<input type="hidden" name="acao" value="login">
					<button class="btn btn-warning mr-1" type="submit">Entrar</button>
				</form>
			<span class="navbar-text text-danger">${erro}</span>
			</div>
		</div>
	</div>
  
	<%@ include file="footer.jsp" %>
	
</body>
</html>