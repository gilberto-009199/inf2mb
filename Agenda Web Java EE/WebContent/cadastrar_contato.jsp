<%@page import="br.senai.jandira.dao.ContatoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.senai.jandira.model.Contato"%>
<%@page import="br.senai.jandira.model.Usuario"%>
<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<%
	Usuario usuario = new Usuario();
	usuario = (Usuario) session.getAttribute("usuario");
	if (usuario == null) {
		response.sendRedirect("login.html");
	} else { 
		ContatoDAO contatoDAO = new ContatoDAO();
		/*Contato contato = contatoDAO*/
%>
<!DOCTYPE html >
<html lang="pt">
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="./css/bootstrap.css">
<title>UaiContatos |* ~ *|</title>
</head>
<body>
	<header>
		<div class="navbar navbar-default">
			<h1>UaiAdicionar |* ~ *|</h1>
		</div>
	</header>
	<div class="container" style="border:solid 1px blue;box-shadow:3px 2px 2px blue; border-radius:6px; padding:10px; ">
		<div class="row">
			<div class="col-md-3">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">
							<img src="imagens/user24x24.png" style="margin-right: 9px;">Usuario
						</h3>
					</div>
					<div class="panel-body">
						<p>Usuario: <strong><%=usuario.getNome()%></strong></p>
						<p>E-mail: <strong><%=usuario.getEmail()%></strong></p>
						<p>Cidade: <strong><%=usuario.getCidade()%></strong></p>
						<p>Data Nacimento: <strong><%=usuario.getDtNasc()%></strong></p>
						<p style="font-size: 16px;"><a href="sair.jsp"><img src="imagens/exitv2.png" style="margin-right:6px;">Sair do sistema</a></p>
					</div>
				</div>

				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">
							<img src="imagens/menu24x24.png" style="margin-right: 9px;">Menu
						</h3>
					</div>
					<div class="panel-body">
						<ul class="nav">
							<li class="nav-item"><a href="index.jsp">Home</a></li>
							<li class="nav-item"><a href="cadastrar_contato.jsp">Adicionar contato</a></li>						
						</ul>
					</div>
				</div>
			</div>
			<div class="col-md-9">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">
							<img src="imagens/contato24x24.png" style="margin-right: 9px;">Adicionar contato
						</h3>
					</div>
					<div class="panel-body ">
						<form method="GET" action="GravarContato">
							<!-- LINHA 01 -->
							<fieldset>
								
								<legend>Dados gerais:</legend>
								<div class="form-row">
									<INPUT TYPE="hidden"  NAME="idUsuario" value="<%= usuario.getId()%>">
									<div class="form-group col-md-6">
										<label for="txtNome">Nome:</label>
										<input type="text" name="txtNome" class="form-control">
									</div>
									<div class="form-group col-md-3">
										<label for="txtDtNasc">Dt. Nasc.:</label> <input type="date"
											name="txtDtNasc" class="form-control">
									</div>
									<div class="form-group col-md-3">
										<label for="cbSexo">Sexo:</label> <select name="cbSexo"
											class="form-control">
											<option value="s">Selecione</option>
											<option value="f">Feminino</option>
											<option value="m">Masculino</option>
										</select>
									</div>

								</div>
							</fieldset>
							<!-- LINHA 02 -->
							<fieldset>
								<legend>Dados de contato:</legend>
								<div class="form-row">
									<div class="form-group col-md-6">
										<label for="txtEmail">E-mail:</label> <input type="mail"
											name="txtEmail" class="form-control">
									</div>
									<div class="form-group col-md-3">
										<label for="txtTelefone">Telefone:</label> <input type="text"
											name="txtTelefone" class="form-control">
									</div>
									<div class="form-group col-md-3">
										<label for="txtCelular">Celular:</label> <input type="text"
											name="txtCelular" class="form-control">
									</div>

								</div>
							</fieldset>
							<!-- LINHA 03 -->
							<fieldset>
								<legend>Dados de endereço:</legend>
								<div class="form-row">
									<div class="form-group col-md-8">
										<label for="txtLogradouro">Logradouro:</label> <input
											type="text" name="txtLogradouro" class="form-control">
									</div>
									<div class="form-group col-md-4">
										<label for="txtBairro">Bairro:</label> <input type="text"
											name="txtbBairro" class="form-control">
									</div>
								</div>
								<div class="form-row">
									<div class="form-group col-md-6">
										<label for="txtCidade">Cidade:</label> <input type="text"
											name="txtCidade" class="form-control">
									</div>
									<div class="form-group col-md-3">
										<label for="txtEstado">Estado:</label> <input type="text"
											name="txtEstado" class="form-control">
									</div>
									<div class="form-group col-md-3">
										<label for="txtCep">CEP:</label> <input type="text"
											name="txtCep" class="form-control">
									</div>
								</div>
							</fieldset>
							
							<div class="form-row">
								<div class="col-md-12">
									<input type="submit" value=">> Salvar" class="btn btn-success" />
									<input type="reset" value=">> Limpar" class="btn btn-warning" />
									<a href="index.jsp" class="btn btn-danger">>> Cancelar</a>
								</div>
							</div>
						</form>
						
						
					</div>
					
						
				</div>	




			</div>
		</div>
	</div>
</body>
</html>
<%
	}
%>
