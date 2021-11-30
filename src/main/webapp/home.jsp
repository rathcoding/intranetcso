<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>CSO - Home</title>
	<%@ include file="header.jsp" %>
</head>
<body>
	
	<%@ include file="menu.jsp" %>
	
	<div class="container-fluid">
	
		<div class="container-fluid"><p class="h2">Meus Casos</p></div>
	
		<table class="table table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="col"></th>
					<th scope="col">Nome</th>
					<th scope="col">Tipo</th>
					<th scope="col">Data Inicial</th>
					<th scope="col">Data Fim Prevista</th>
					<th scope="col">Data Fim</th>
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
						<!-- Button trigger modal -->
								<button type="button" class="btn btn-danger btn-sm mx-1" data-bs-toggle="modal" data-bs-target="#confirmDelete">x</button>
							</div>
						<!-- Modal -->
							<div class="modal fade" id="confirmDelete" tabindex="-1" aria-labelledby="excluiCasoModal" aria-hidden="true">
								<div class="modal-dialog moodal-sm">
									<div class="modal-content">
										<div class="modal-header"><h5 class="modal-title" id="excluiCasoModal">Atenção!</h5></div>
										<div class="modal-body">Confirmar exclusão do caso?</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
											<form class="form-inline m-1" action="caso" method="post" accept-charset="ISO-8859-1">
												<input type="hidden" name="acao" value="deleteOne">
												<input type="hidden" name="id" value="${c.id}">
												<button class="btn btn-danger" type="submit">Excluir</button>
											</form>
										</div>
									</div>
								</div>
							</div>
						</td>
						<td>${c.nomeServidor}</td> <!-- INCLUIR LINK PARA PAGINA DO SERVIDOR -->
						<td>${c.tipo}</td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${c.data_inicio}"/></td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${c.data_fim_prev}"/></td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${c.data_fim}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>		
	</div>
	
	<div><hr class="solid"></div>
	<!--=== FORM INCLUIR CASO ============================================================================-->
	
	<div class="container-fluid bg-light">
		<div class="container-fluid"><p class="h2">Cadastrar novo caso</p></div>
		<div class="d-flex justify-content-start mb-3">
			<form method="post" action="caso" accept-charset="ISO-8859-1">
				<fieldset>
					<div class="row">
						<div class="col-2">
							<label for="id-servidor" class="col-form-label">Servidor</label>
						</div>
						<div class="col-10 align-middle">
		 					<select class="browser-default custom-select" id="id_servidor" name="cpfServidor">
								<c:forEach items="${servidores}" var="s">
									<option value="${s.cpf}">${s.nome}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					
					<div class="row">
						<div class="col-2">
							<label for="id-tipo" class="col-form-label">Tipo</label>
						</div>
						<div class="col-10">
		 					<select class="browser-default custom-select" id="id_tipo" name="tipo">
								<c:forEach items="${tipos_caso}" var="tpc">
									<option value="${tpc}">${tpc}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					
					<div class="row">
						<div class="col-2">
							<label for="id-cid" class="col-form-label">CID-10 (opcional)</label>
						</div>
						<div class="col-10">
		 					<select class="browser-default custom-select" id="id_cid" name="cid">
		 						<option value="">Nenhum</option>
								<c:forEach items="${tipos_cid}" var="tcid">
									<option value="${tcid}">${tcid}</option>
								</c:forEach>
							</select>
						</div>
					</div>
										
					<div class="row">
						<div class="col-2">
							<label for="id-data_inicio" class="col-form-label">Data de início</label>
						</div>
						<div class="col-10">
							<input type="date" name="data_inicio" id="id-data_inicio" pattern="dd/mm/yyyy" required>
						</div>
					</div>
					
					<div class="row">
						<div class="col-2">
							<label for="id-data_fim_prev" class="col-form-label">Data fim (prevista)</label>
						</div>
						<div class="col-10">
							<input type="date" name="data_fim_prev" id="id-data_fim_prev" pattern="dd/mm/yyyy" required>
						</div>
					</div>
					
					<div class="row">
						<div class="col-2">
							<label for="id-sgpe" class="col-form-label">SGPE (opcional)</label>
						</div>
						<div class="col-10">
							<input type="text" name="sgpe" id="id-sgpe" placeholder="PCSC NNNNN/AAAA">
						</div>
					</div>
					
					<div class="row" ${user.acesso > 2 ? 'hidden' : ''}>
						<div class="col-2">
							<label for="id-psi" class="col-form-label">Responsável</label>
						</div>
						<div class="col-10">
		 					<select class="browser-default custom-select" id="id_psi" name="psi">
		 							<option value="${user.cpf}">${user.nome}</option>
								<c:forEach items="${psis}" var="p">
									<option value="${p.cpf}">${p.nome}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					
					<div class="form-group">
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