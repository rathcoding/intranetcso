<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CSO</title>
<%@ include file="header.jsp" %>
</head>
<body>
	
	<%@ include file="intranetoficial.jsp" %>
	
	<div class="container">
    <br/>
    <br/>
    <div class="row">
		<div class="col-sm-offset-4 col-lg-offset-4 col-sm-4 col-lg-4">
			<div class="panel panel-default">
				<div class="panel-heading">Login</div>
					<div class="panel-body">
						<form role="form" action="/dados/acesso/autenticar" method="post" autocomplete="off">
							<div class="form-group">
								<input type="text" class="form-control" id="cpf" name="cpf" placeholder="CPF" required/>
							</div>
							<div class="form-group">
								<input type="password" class="form-control" id="senha" name="senha" placeholder="Senha" required/>
							</div>
							<div class="form-group">
								<button type="submit" id="submit" class="btn btn-block btn-warning">Autenticar <span class="glyphicon glyphicon-log-in"></span></button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
  
	<%@ include file="footer.jsp" %>
	
</body>
</html>