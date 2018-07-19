<%@page import="br.senai.jandira.dao.ContatoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.senai.jandira.model.Contato"%>
<%@page import="br.senai.jandira.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	Usuario usuario = new Usuario();
	usuario = (Usuario) session.getAttribute("usuario");
	if (usuario == null) {
		response.sendRedirect("login.html");
	} else {
		ArrayList<Contato> lista= new ArrayList<>(); 
		ContatoDAO contatoDAO = new ContatoDAO();
		lista = contatoDAO.getContatos(usuario.getId());
%>
<!DOCTYPE html >
<html lang="pt">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/bootstrap.css">
<title>UaiContatos |* ~ *|</title>
</head>
<body>
	<header>
		<div class="navbar navbar-default">
			<h1>UaiContatos |* ~ *|</h1>
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
							<img src="imagens/contato24x24.png" style="margin-right: 9px;">Meus
							Contatos
						</h3>
					</div>
					<div class="panel-body ">
						<table class="table table-hover  ">
							<thead>
								<tr>
									<th>ID</th>
									<th>Nome</th>
									<th>Email</th>
									<th>Telefone</th>
									<!-- <th>Editar</th>
									<th>Remover</th> -->
									
								</tr>
							</thead>
							<%	//int i=0;i<lista.size();i++
							for(Contato contato : lista){%>
								<tr>
								<td><%=contato.getId()%></td>
								<td><%=contato.getNome()%></td>
								<td><%=contato.getEmail()%></td>
								<td><%=contato.getTelefone()%></td>
								<td><a href="editar_contato.jsp?id=<%=contato.getId()%>"><img src="imagens/edit24x24.png" alt="editar"></a></td>
								<td><a href="excluir_contato.jsp?id=<%=contato.getId()%>"><img src="imagens/remove24x24.png" alt="remover"></a></td>
							<%}%>

						</table>
					</div>
					<div class="panel-footer">
						<p> Numero de Contatos: <%= lista.size() %></p>
					
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
