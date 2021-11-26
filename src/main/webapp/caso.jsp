<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>CSO - Caso</title>
	<%@ include file="header.jsp" %>
</head>
<body>
	
	<%@ include file="menu.jsp" %>
	
	<!--=== CASO =========================================================================================-->
	
	<div class="container-fluid">
		
		<div class="container-fluid"><p class="h2">Caso</p></div>
		
		<table class="table table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="col"></th>
					<th scope="col">Tipo</th>
					<th scope="col">Data Inicial</th>
					<th scope="col">Data Fim Prevista</th>
					<th scope="col">Data Fim</th>
					<th scope="col">SGPe</th>
					<th scope="col">Responsável</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<div class="d-flex justify-content-start">
							<form method="post" action="caso" accept-charset="ISO-8859-1">
								<div>
									<input type="hidden" name="id" value="${caso.id}">
									<input type="hidden" name="acao" value="updateForm">
									<input class="btn btn-warning btn-sm" type="submit" value="Editar">
								</div>
							</form>
						<!-- Button trigger modal -->
							<button type="button" class="btn btn-danger btn-sm mx-1" data-bs-toggle="modal" data-bs-target="#confirmDelete" ${user.cpf==caso.cpfPsi ? '' : 'disabled'}>x</button>
						</div>
						<!-- Modal -->
						<div class="modal fade" id="confirmDelete" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog moodal-sm">
								<div class="modal-content">
									<div class="modal-header"><h5 class="modal-title" id="exampleModalLabel">Atenção!</h5></div>
									<div class="modal-body">Confirmar exclusão?</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
										<form class="form-inline m-1" action="caso" method="post" accept-charset="ISO-8859-1">
											<input type="hidden" name="acao" value="deleteOne">
											<input type="hidden" name="id" value="${caso.id}">
											<button class="btn btn-danger" type="submit">Excluir</button>
										</form>
									</div>
								</div>
							</div>
						</div>
					</td>
					<td>${caso.tipo}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${caso.data_inicio}"/></td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${caso.data_fim_prev}"/></td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${caso.data_fim}"/></td>
					<td>${caso.sgpe}</td>
					<td>${caso.nomePsi}</td>
				</tr>
			</tbody>
		</table>		
	</div>
	
	<div><hr class="solid"></div>
	<!--=== SERVIDOR =====================================================================================-->
	
	<div class="container-fluid bg-light">
		
		<div class="container-fluid"><p class="h2">Servidor</p></div>
		
		<table class="table table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="col"></th>
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
								<input type="hidden" name="cpf" value="${caso.servidor.cpf}">
								<input type="hidden" name="acao" value="getOneByCPF">
								<input class="btn btn-secondary btn-sm" type="submit" value="Ver">
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
	
	<div><hr class="solid"></div>
	<!--=== INTERVENÇÕES =================================================================================-->
	
	<div class="container-fluid">
		<div class="container-fluid"><p class="h2">Intervenções</p></div>
	
		<table class="table table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="col"></th>
					<th scope="col">Psi</th>
					<th scope="col">Tipo</th>
					<th scope="col">Data</th>
					<th scope="col">Hora</th>
					<th scope="col">Notas</th>
			</thead>
			<tbody>
				<c:forEach items="${caso.intervencoes}" var="i">
					<tr>
						<td>
							<div class="d-flex justify-content-start">
						<!-- Button trigger modal -->
								<button type="button" class="btn btn-danger btn-sm mx-1" data-bs-toggle="modal" data-bs-target="#confirmDelete" ${user.cpf==i.psi ? '' : 'disabled'}>x</button>
							</div>
						<!-- Modal -->
							<div class="modal fade" id="confirmDelete" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
								<div class="modal-dialog moodal-sm">
									<div class="modal-content">
										<div class="modal-header"><h5 class="modal-title" id="exampleModalLabel">Atenção!</h5></div>
										<div class="modal-body">Confirmar exclusão?</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
											<form class="form-inline m-1" action="intervencao" method="post" accept-charset="ISO-8859-1">
												<input type="hidden" name="acao" value="delete">
												<input type="hidden" name="id" value="${i.id}">
												<button class="btn btn-danger" type="submit">Excluir</button>
											</form>
										</div>
									</div>
								</div>
							</div>
						</td>
						<td>${i.nomePsi}</td>
						<td>${i.tipo}</td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${i.data}"/></td>
						<td><fmt:formatDate type="time" pattern="HH:mm" value="${i.hora}"/></td>
						<td>${i.notas}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>		
	</div>
	
	<div><hr class="solid"></div>
	<!--=== FORM INCLUIR INTERVENÇÃO =====================================================================-->
	
	<div class="container-fluid bg-light">
		<div class="container-fluid"><p class="h2">Cadastrar nova intervenção</p></div>
		<div class="d-flex justify-content-start mb-3">
			<form method="post" action="intervencao" accept-charset="ISO-8859-1">
				<fieldset>
					<div class="form-group">
						<label for="id-data" class="col-form-label">Data</label>
						<input type="date" name="data" id="id-data" pattern="dd/mm/yyyy" required>
					</div>
					<div class="form-group">
						<label for="id-hora" class="col-form-label">Hora</label>
						<input type="time" name="hora" id="id-hora" pattern="HH:MM" required>
					</div>
					<div class="form-group">
						<label for="id-tipo" class="col-form-label">Tipo</label>
	 					<select class="browser-default custom-select" id="id_tipo" name="tipo">
							<c:forEach items="${tipos_intervencao}" var="tpi">
								<option value="${tpi}">${tpi}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="id-notas" class="col-form-label">Anotações:</label>
						<textarea class="form-control" name="notas" id="id-notas"></textarea>
					</div>
					<div class="form-group">
						<input type="hidden" name="idCaso" value="${caso.id}">
						<input type="hidden" name="acao" value="cadastrar">
						<input class="btn btn-secondary mt-2" type="submit" value="Cadastrar">
					</div>
				</fieldset>
			</form>
		</div>
	</div>
	
	<%@ include file="footer.jsp" %>
	
</body>
</html>