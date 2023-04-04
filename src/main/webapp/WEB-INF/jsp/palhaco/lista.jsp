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
	
		<h3>Listagem de Palhaços</h3>
		
		<c:if test="${not empty mensagem}">		
			<div class="alert alert-success">
			  <strong>Atenção!</strong> ${mensagem}
			</div>		
		</c:if>

		<form action="/palhaco" method="get">
			<button type="submit">Novo</button>
		</form>
		
		<c:if test="${empty palhacos}">
			<h5>Não existem palhacos cadastradas!!!</h5>
		</c:if>
	
		<c:if test="${not empty palhacos}">
			<h5>Quantidade de palhacos cadastradas: ${palhacos.size()}!!!</h5>
	
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th>ID</th>
			      <th>Nome</th>
			      <th>Salário-hora</th>
			      <th>Telefone</th>
			      <th>Tamanho do Sapato</th>
			      <th>Humor adulto</th>
			      <th>Nome artístico</th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>

			  	<c:forEach var="p" items="${palhacos}">
				    <tr>
				      <td>${p.id}</td>
				      <td>${p.nome}</td>
				      <td>${p.salarioHora}</td>
				      <td>${p.telefone}</td>
				      <td>${p.tamanhoSapato}</td>
				      <td>${p.humorAdulto}</td>
				      <td>${p.nomeArtistico}</td>
				      <td><a href="/palhaco/${p.id}/excluir">excluir</a></td>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
		</c:if>	
	</div>
</body>
</html>