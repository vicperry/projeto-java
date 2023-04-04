<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<meta charset="utf-8">
<title>AnimaShow</title>
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp" />

	<div class="container">

		<h3>Listagem de Usuários</h3>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Atenção!</strong> ${mensagem}
			</div>
		</c:if>

		<c:if test="${empty usuarios}">
			<h5>Não existem usuários cadastrados!!!</h5>
		</c:if>

		<form action="/usuario" method="get">
			<button type="submit">Novo</button>
		</form>

		<c:if test="${not empty usuarios}">
			<h5>Quantidade de usuários cadastrados: ${usuarios.size()}!!!</h5>

			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Senha</th>
						<th>E-mail</th>
						<th>Endereço</th>
						<th>Admin</th>
						<th>Contratantes</th>
						<th>Artistas</th>
						<th>Contratos</th>
						<c:if test="${usuario.admin}">
							<th></th>
						</c:if>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="u" items="${usuarios}">
						<tr>
							<td>${u.id}</td>
							<td>${u.nome}</td>
							<td>${u.senha}</td>
							<td>${u.email}</td>
							<td>${u.endereco}</td>
							<td>${u.admin}</td>
							<td>${u.contratantes.size()}</td>
							<td>${u.artistas.size()}</td>
							<td>${u.contratos.size()}</td>
							<c:if test="${usuario.admin}">
								<td><a href="/usuario/${u.id}/excluir">excluir</a></td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>