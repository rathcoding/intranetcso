<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>CSO - Home</title>
	<%@ include file="header.jsp" %>
</head>
<body>
	
	<%@ include file="menu.jsp" %>
	
	<div class="container-fluid bg-light">
		<div class="container-fluid"><p class="h2">Editar caso</p></div>
		<div class="d-flex justify-content-start mb-3">
			<form method="post" action="caso" accept-charset="ISO-8859-1">
				<fieldset>
					<div class="form-group">
						<label for="id-nomeServidor" class="col-form-label">Servidor</label>
	 					<select class="browser-default custom-select" id="id_nomeServidor">
							<option>${caso.servidor.nome}</option>
						</select>
					</div>
					
					<div class="form-group">
						<label for="id-tipo" class="col-form-label">Tipo</label>
	 					<select class="browser-default custom-select" id="id_tipo" name="tipo">
	 						<option value="${caso.tipo}">${caso.tipo}</option>
							<c:forEach items="${tipos_caso}" var="tpc">
								<option value="${tpc}">${tpc}</option>
							</c:forEach>
						</select>
					</div>
					
					<div class="form-group">
						<label for="id-cid" class="col-form-label">CID-10 (opcional)</label>
	 					<select class="browser-default custom-select" id="id_cid" name="cid">
	 						<option value="${caso.cid}">${caso.cid}</option>
							<c:forEach items="${tipos_cid}" var="tcid">
								<option value="${tcid}">${tcid}</option>
							</c:forEach>
						</select>
					</div>
					
					<div class="form-group">
						<label for="id-data_inicio" class="col-form-label">Data de início</label>
						<input type="date" name="data_inicio" id="id-data_inicio" pattern="dd/mm/yyyy" value="${caso.data_inicio}" required>
					</div>
					
					<div class="form-group">
						<label for="id-data_fim_prev" class="col-form-label">Data fim (prevista)</label>
						<input type="date" name="data_fim_prev" id="id-data_fim_prev" pattern="dd/mm/yyyy" value="${caso.data_fim_prev}" required>
					</div>
					
					<div class="form-group">
						<label for="id-data_fim" class="col-form-label">Data fim</label>
						<input type="date" name="data_fim" id="id-data_fim_prev" pattern="dd/mm/yyyy" value="${caso.data_fim}">
					</div>
					
					<div class="form-group">
						<label for="id-sgpe" class="col-form-label">SGPE (opcional)</label>
						<input type="text" name="sgpe" id="id-sgpe" value="${caso.sgpe}">
					</div>
					
					<div class="form-group" ${user.acesso > 2 ? 'hidden' : ''}>
						<label for="id-psi" class="col-form-label">Responsável</label>
	 					<select class="browser-default custom-select" id="id_psi" name="psi">
	 							<option value="${caso.cpfPsi}">${caso.nomePsi}</option>
							<c:forEach items="${psis}" var="p">
								<option value="${p.cpf}">${p.nome}</option>
							</c:forEach>
						</select>
					</div>
					
					<div class="form-group">
						<input type="hidden" name="id" value="${caso.id}">
						<input type="hidden" name="acao" value="updateOne">
						<input class="btn btn-secondary mt-2" type="submit" value="Atualizar">
					</div>
					
				</fieldset>
			</form>
		</div>
	</div>
	
	
	<%@ include file="footer.jsp" %>
	
</body>
</html>