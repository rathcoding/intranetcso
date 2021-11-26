<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>CSO - Servidor</title>
	<%@ include file="header.jsp" %>
</head>
<body>
	
	<%@ include file="menu.jsp" %>
	
	<!--=== SERVIDOR =====================================================================================-->
	<div class="container-fluid bg-light">
		
		<div class="container-fluid"><p class="h2">Servidor</p></div>
		<div class="row">
			<div class="col-8">
				<table class="table">
					<tbody>
						<tr>
							<th scope="col">Nome</th>
							<td>${servidor.nome}</td>
						</tr>
						<tr>
							<th scope="col">Cargo</th>
							<td>${servidor.cargo}</td>
						</tr>
						
						<tr>
							<th scope="col">CPF</th>
							<td>${servidor.cpf}</td>
						</tr>
						
						<tr>
							<th scope="col">Nascimento</th>
							<td><fmt:formatDate pattern="dd/MM/yyyy" value="${servidor.data_nascimento}"/></td>
						</tr>
						
						<tr>
							<th scope="col">Matrícula</th>
							<td>${servidor.matricula}</td>
						</tr>
						
						<tr>
							<th scope="col">Ingr. Polícia Civil</th>
							<td><fmt:formatDate pattern="dd/MM/yyyy" value="${servidor.data_ingresso}"/></td>
						</tr>
						
						<tr>
							<th scope="col">Ingr. Cargo Atual</th>
							<td><fmt:formatDate pattern="dd/MM/yyyy" value="${servidor.data_cargo}"/></td>
						</tr>
						
						<tr>
							<th scope="col">e-mail</th>
							<td>${servidor.email}</td>
						</tr>
						
						<tr>
							<th scope="col">Telefone</th>
							<td>${servidor.telefone}</td>
						</tr>
						<tr>
							<th scope="col">Celular</th>
							<td>${servidor.celular}</td>
						</tr>
						
						<tr>
							<th scope="col">Unidade</th>
							<td>${servidor.unidade}</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-4">
				<img src="resources/img/avatar.jpg" class="img-fluid img-thumbnail"/>
			</div>
		</div>			
	</div>
	
	<div><hr class="solid"></div>
	<!--=== CASOS ========================================================================================-->
	
	<div class="container-fluid"><p class="h2">Casos</p></div>
	
	<div class="container-fluid">
		<table class="table table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="col"></th>
					<th scope="col">Tipo</th>
					<th scope="col">Data Inicial</th>
					<th scope="col">Data Fim Prevista</th>
					<th scope="col">Data Fim</th>
					<th scope="col">Responsável</th>
			</thead>
			<tbody>
				<c:forEach items="${casos}" var="c">
					<tr>
						<td>
							<div class="d-flex justify-content-start">
								<form method="post" action="caso" accept-charset="ISO-8859-1">
									<div>
										<input type="hidden" name="id" value="${c.id}">
										<input type="hidden" name="acao" value="getOneById">
										<input class="btn btn-secondary btn-sm" type="submit" value="Ver">
									</div>
								</form>
							</div>
						</td>
						<td>${c.tipo}</td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${c.data_inicio}"/></td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${c.data_fim_prev}"/></td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${c.data_fim}"/></td>
						<td>${c.nomePsi}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>		
	</div>
	
	<%@ include file="footer.jsp" %>
	
</body>
</html>