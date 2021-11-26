<header class="bg-dark">
	<div class="container">
		<div class="row">
			<div class="col-md-2">
				<img src="resources/img/logo.png"/>
			</div>
			<div class="col-md-10 text-light">
				<h3>Polícia Civil do Estado de Santa Catarina</h3>
				<h4>Intranet CSO</h4>
			</div>
		</div>
	</div>
</header>

<div class="btn-toolbar justify-content-between bg-dark bg-gradient" role="toolbar" aria-label="Toolbar with button groups">
	<div class="btn-group" role="group" aria-label="Esquerda">
		<form class="form-inline m-1" action="caso" method="post" accept-charset="ISO-8859-1">
			<input type="hidden" name="acao" value="getAllByPsi">
			<button class="btn btn-outline-light my-2 my-sm-0" type="submit" ${empty user ? 'disabled' : ''}>Casos</button>
		</form>
		<form class="form-inline m-1" action="servidor" method="post" accept-charset="ISO-8859-1">
			<input type="hidden" name="acao" value="buscarForm">
			<button class="btn btn-outline-light my-2 my-sm-0" type="submit" ${empty user ? 'disabled' : ''}>Servidores</button>
		</form>
	</div>

	<div class="btn-group" role="group" aria-label="Meio">
		<span class="d-flex text-light align-items-center">${user.nome}</span>
	</div>

	<div class="btn-group" role="group" aria-label="Direita">
    	<form class="form-inline m-1" action="alterarSenha.jsp">
			<button class="btn btn-outline-light my-2 my-sm-0" type="submit" ${empty user ? 'hidden' : ''}>Alterar Senha</button>			
		</form>
		<form class="form-inline m-1" action="usuario" method="post" accept-charset="ISO-8859-1">
			<input type="hidden" name="acao" value="logout">
			<button class="btn btn-outline-danger my-2 my-sm-0" type="submit" ${empty user ? 'hidden' : ''}>Sair</button>
		</form>
	</div>
</div>