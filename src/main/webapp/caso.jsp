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
	
	
	<!--=== CASO =========================================================================================-->
	
	<div class="container-fluid">
		
		<div class="container-fluid"><p class="h2">Caso</p></div>
		
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Tipo</th>
					<th scope="col">Data Inicial</th>
					<th scope="col">Data Fim Prevista</th>
					<th scope="col">Data Fim</th>
			</thead>
			<tbody>
				<tr>
					<td>${caso.tipo}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${caso.data_inicio}"/></td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${caso.data_fim_prev}"/></td>
					<td><div class="d-flex justify-content-start">
						<form method="post" action="caso" accept-charset="ISO-8859-1">
							<div>
								<input type="hidden" name="id" value="${caso.id}">
								<input type="hidden" name="acao" value="update">
								<input type="date" name="data_fim" pattern="dd/mm/yyyy" value="${caso.data_fim}">
								<!-- <input class="btn btn-secondary mx-1" type="submit" value="Ver"> -->
							</div>
						</form>
					</div></td>
				</tr>
			</tbody>
		</table>		
	</div>
	
	
	<!--=== SERVIDOR =====================================================================================-->
	
	<div class="container-fluid">
		
		<div class="container-fluid"><p class="h2">Servidor</p></div>
		
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Ação</th>
					<th scope="col">Nome</th>
					<th scope="col">Cargo</th>
					<th scope="col">Unidade</th>
					<th scope="col">Telefone</th>
					<th scope="col">Celular</th>
					<th scope="col">e-mail</th>
			</thead>
			<tbody>
				<tr>
					<td><div class="d-flex justify-content-start">
						<form method="post" action="servidor" accept-charset="ISO-8859-1">
							<div>
								<input type="hidden" name="id" value="${caso.servidorCPF}">
								<input type="hidden" name="acao" value="getOneById">
								<input class="btn btn-secondary mx-1" type="submit" value="Ver">
							</div>
						</form>
					</div></td>
					<td>${caso.servidor.nome}</td>
					<td>${caso.servidor.cargo}</td>
					<td>${caso.servidor.unidade}</td>
					<td>${caso.servidor.telefone}</td>
					<td>${caso.servidor.celular}</td>
					<td>${caso.servidor.email}</td>
				</tr>
			</tbody>
		</table>		
	</div>
	
	
	<!--=== INTERNÇÕES ===================================================================================-->
	
	<div class="container-fluid">
		<div class="container-fluid"><p class="h2">Intervenções</p></div>
	
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Ações</th>
					<th scope="col">Tipo</th>
					<th scope="col">Data</th>
					<th scope="col">Hora</th>
					<th scope="col">Notas</th>
			</thead>
			<tbody>
				<c:forEach items="${caso.intervencoes}" var="i">
					<tr>
						<td><div class="d-flex justify-content-start">
							<form method="post" action="intervencao" accept-charset="ISO-8859-1">
								<div>
									<input type="hidden" name="id" value="${i.id}">
									<input type="hidden" name="acao" value="getOneById">
									<input class="btn btn-secondary mx-1" type="submit" value="Edit">
								</div>
							</form>
						</div></td>
						<td>${i.tipo}</td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${i.data}"/></td>
						<td><fmt:formatDate type="TIME" pattern="HH:MM:SS" value="${i.hora}"/></td>
						<td>${i.notas}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>		
	</div>
	
	<%@ include file="footer.jsp" %>
	
</body>
</html>