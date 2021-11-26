<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>CSO - Buscar Servidor</title>
	<%@ include file="header.jsp" %>
</head>
<body>
	
	<%@ include file="menu.jsp" %>
	
	<div class="container-fluid bg-light">
		<div class="container-fluid"><p class="h2">Buscar Servidor</p></div>
		<div class="d-flex justify-content-start mb-3">
			<form class="form-inline" method="post" action="servidor" accept-charset="ISO-8859-1">
				<fieldset>
					<div class="control-group">
						<label for="id-servidor" class="col-form-label">Servidor</label>
	 					<select class="browser-default custom-select" id="id_servidor" name="cpf">
							<c:forEach items="${servidores}" var="s">
								<option value="${s.cpf}">${s.nome}</option>
							</c:forEach>
						</select>
					</div>
					
					<div class="control-group">
						<input type="hidden" name="acao" value="getOneByCPF">
						<input class="btn btn-secondary mt-2" type="submit" value="Buscar">
					</div>
					
				</fieldset>
			</form>
		</div>
	</div>
	
	
	
	
	
	<%@ include file="footer.jsp" %>
	
</body>
</html>