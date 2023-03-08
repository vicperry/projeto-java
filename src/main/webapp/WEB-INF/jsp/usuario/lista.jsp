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
		<form action="/usuario" method="get">
			<h3>Listagem de Usuários</h3>
			<button type="submit">Novo</button>
		</form>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Senha</th>
					<th>E-mail</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Vic Pereira</td>
					<td>123</td>
					<td>vic@gmail.com</td>
				</tr>
				<tr>
					<td>Vic Pereira</td>
					<td>123</td>
					<td>vic@gmail.com</td>
				</tr>
				<tr>
					<td>Vic Pereira</td>
					<td>123</td>
					<td>vic@gmail.com</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>