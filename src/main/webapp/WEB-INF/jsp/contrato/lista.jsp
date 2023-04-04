<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<meta charset="utf-8">
<title>Listagem de Contratos</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp" />

	<div class="container">

		<h3>Listagem de Contratos</h3>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Atenção!</strong> ${mensagem}
			</div>
		</c:if>

		<form action="/contrato" method="get">
			<button type="submit">Novo</button>
		</form>

		<c:if test="${empty contratos}">
			<h5>Não existem contratos cadastrados!!!</h5>
		</c:if>

		<c:if test="${not empty contratos}">
			<h5>Quantidade de contratos cadastrados: ${contratos.size()}!!!</h5>

			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Descrição do Evento</th>
						<th>Data do Evento</th>
						<th>Contratante</th>
						<th>Artistas</th>
						<th></th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="c" items="${contratos}">
						<tr>
							<td>${c.id}</td>
							<td>${c.descricaoEvento}</td>
							<td>${c.dataEvento}</td>
							<td>${c.contratante.nome}</td>
							<td>${c.artistas.size()}</td>
							<td><a href="/contrato/${c.id}/excluir">excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>