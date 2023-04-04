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

		<h3>Listagem de Artistas</h3>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Atenção!</strong> ${mensagem}
			</div>
		</c:if>

		<c:if test="${empty artistas}">
			<h5>Não existem artistas cadastrados!!!</h5>
		</c:if>

		<c:if test="${not empty artistas}">
			<h5>Quantidade de artistas cadastrados: ${artistas.size()}!!!</h5>

			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Telefone</th>
						<th>Salário-hora</th>
						<th>Usuário</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="a" items="${artistas}">
						<tr>
							<td>${a.id}</td>
							<td>${a.nome}</td>
							<td>${a.telefone}</td>
							<td>${a.salarioHora}</td>
							<td>${a.usuario.nome}</td>
							<td><a href="/artista/${a.id}/excluir">excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>