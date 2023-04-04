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
<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
	
		<h3>Listagem de Mágicos</h3>
		
		<c:if test="${not empty mensagem}">		
			<div class="alert alert-success">
			  <strong>Atenção!</strong> ${mensagem}
			</div>		
		</c:if>

		<form action="/magico" method="get">
			<button type="submit">Novo</button>
		</form>
		
		<c:if test="${empty magicos}">
			<h5>Não existem magicos cadastradas!!!</h5>
		</c:if>
	
		<c:if test="${not empty magicos}">
			<h5>Quantidade de magicos cadastradas: ${magicos.size()}!!!</h5>
	
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th>ID</th>
			      <th>Nome</th>
			      <th>Salário-hora</th>
			      <th>Telefone</th>
			      <th>Faz pirotecnia</th>
			      <th>Usa coelhos</th>
			      <th>Número de truques</th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>

			  	<c:forEach var="m" items="${magicos}">
				    <tr>
				      <td>${m.id}</td>
				      <td>${m.nome}</td>
				      <td>${m.salarioHora}</td>
				      <td>${m.telefone}</td>
				      <td>${m.fazPirotecnia}</td>
				      <td>${m.usaCoelho}</td>
				      <td>${m.numeroTruques}</td>
				      <td><a href="/magico/${m.id}/excluir">excluir</a></td>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
		</c:if>	
	</div>
</body>
</html>