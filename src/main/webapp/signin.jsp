<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>CSO - signin</title>
	<%@ include file="header.jsp" %>
</head>
<body>
	
	<%@ include file="intranetoficial.jsp" %>
	
	<div class="container-fluid p-2">
		<form class="form-inline col-sm-3 my-1" action="usuario" method="post" accept-charset="ISO-8859-1">
			<input class="form-control my-1" type="text" name="cpf" placeholder="CPF" required>
			<input class="form-control my-1" type="password" name="senha" placeholder="Senha" required>
			<input class="form-control my-1" type="text" name="lotacao" placeholder="Lotacao" required>
			<input class="form-control my-1" type="number" name="acesso" placeholder="acesso" required>
			<input type="hidden" name="acao" value="criar">
			<button class="btn btn-primary my-3" type="submit">Criar</button>
		</form>
	</div>
	<%@ include file="footer.jsp" %>
	
</body>
</html>