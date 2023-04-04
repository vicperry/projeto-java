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
	
		<h3>Listagem de Trapezistas</h3>
		
		<c:if test="${not empty mensagem}">		
			<div class="alert alert-success">
			  <strong>Atenção!</strong> ${mensagem}
			</div>		
		</c:if>

		<form action="/trapezista" method="get">
			<button type="submit">Novo</button>
		</form>
		
		<c:if test="${empty trapezistas}">
			<h5>Não existem trapezistas cadastradas!!!</h5>
		</c:if>
	
		<c:if test="${not empty trapezistas}">
			<h5>Quantidade de trapezistas cadastradas: ${trapezistas.size()}!!!</h5>
	
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th>ID</th>
			      <th>Nome</th>
			      <th>Salário-hora</th>
			      <th>Telefone</th>
			      <th>Altura</th>
			      <th>Possui redes de segurança</th>
			      <th>Número de acrobacias realizadas</th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>

			  	<c:forEach var="t" items="${trapezistas}">
				    <tr>
				      <td>${t.id}</td>
				      <td>${t.nome}</td>
				      <td>${t.salarioHora}</td>
				      <td>${t.telefone}</td>
				      <td>${t.altura}</td>
				      <td>${t.possuiRedeSegurança}</td>
				      <td>${t.numeroAcrobaciasRealizadas}</td>
				      <td><a href="/trapezista/${t.id}/excluir">excluir</a></td>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
		</c:if>	
	</div>
</body>
</html>