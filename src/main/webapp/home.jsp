<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>CSO - Home</title>
	<%@ include file="header.jsp" %>
</head>
<body>
	
	<%@ include file="intranetoficial.jsp" %>
	<%@ include file="menu.jsp" %>
	
	<div class="container-fluid"><p class="h2">Meus Casos</p></div>
	
	<div class="container-fluid">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Nome</th>
					<th scope="col">Tipo</th>
					<th scope="col">Data Inicial</th>
					<th scope="col">Data Fim Prevista</th>
			</thead>
			<tbody>
				<c:forEach items="${casos}" var="c">
					<tr>
						<td>${c.servidor}</td>
						<td>${c.tipo}</td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${c.data_inicio}"/></td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${c.data_fim_prev}"/></td>
						<td><div class="d-flex justify-content-start">
							<form method="post" action="caso" accept-charset="ISO-8859-1">
								<div>
									<input type="hidden" name="id" value="${c.id}">
									<input type="hidden" name="acao" value="getOneById">
									<input class="btn btn-secondary mx-1" type="submit" value="Ver">
								</div>
							</form>
						</div></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>		
	</div>
	
	<%@ include file="footer.jsp" %>
	
</body>
</html>