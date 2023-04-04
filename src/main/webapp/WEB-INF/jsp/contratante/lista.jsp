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

		<h3>Listagem de Contratantes</h3>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Atenção!</strong> ${mensagem}
			</div>
		</c:if>

		<c:if test="${empty contratantes}">
			<h5>Não existem contratantes cadastrados!!!</h5>
		</c:if>

		<form action="/contratante" method="get">
			<button type="submit">Novo</button>
		</form>

		<c:if test="${not empty contratantes}">
			<h5>Quantidade de contratantes cadastrados: ${contratantes.size()}!!!</h5>

			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Telefone</th>
						<th>CPF</th>
						<th>Usuário</th>
						<th>Endereço</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="c" items="${contratantes}">
						<tr>
							<td>${c.id}</td>
							<td>${c.nome}</td>
							<td>${c.telefone}</td>
							<td>${c.cpf}</td>
							<td>${c.usuario.nome}</td>
							<td>${c.endereco}</td>
							<td><a href="/contratante/${c.id}/excluir">excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>