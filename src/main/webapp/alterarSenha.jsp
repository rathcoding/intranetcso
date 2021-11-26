<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>CSO</title>
	<%@ include file="header.jsp" %>
</head>
<body>
	
	<%@ include file="menu.jsp" %>
	
	<div class="container-fluid bg-light">
		<div class="container-fluid"><p class="h2">Cadastrar nova senha</p></div>
		<div class="d-flex justify-content-start mb-3">
			<form method="post" action="usuario" accept-charset="ISO-8859-1">
				<fieldset>
					<div class="form-group">
						<input class="form-control my-1" type="password" name="senha" placeholder="Senha antiga" required>
					</div>
					<span class="navbar-text text-danger">${senhaErrada}</span>
					<div class="form-group">
						<input class="form-control my-1" type="password" name="senhaNova1" placeholder="Nova senha" required>
					</div>
					<div class="form-group">
						<input class="form-control my-1" type="password" name="senhaNova2" placeholder="Repita a nova senha" required>
					</div>
					<span class="navbar-text text-danger">${senhaNovaErrada}</span>
					<div class="form-group">
						<input type="hidden" name="acao" value="alterarSenha">
						<input class="btn btn-secondary mt-2" type="submit" value="Alterar">
					</div>
					<span class="navbar-text text-success">${sucesso}</span>
				</fieldset>
			</form>
		</div>
	</div>

  
	<%@ include file="footer.jsp" %>
	
</body>
</html>