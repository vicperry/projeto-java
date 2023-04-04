<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<meta charset="utf-8">
<title>Cadastro de Contratos</title>
</head>
<body>

	<c:set var="botao" value=""/>

<c:import url="/WEB-INF/jsp/menu.jsp"/>
	
	<div class="container">
	
		<form action="/contrato/incluir" method="post">
			<h3>Cadastro de Contratos</h3>

			<div class="form-group">
				<label>Descrição do Evento:</label> 	
				<input type="text" name="descricaoEvento" value="30º Aniversário de Mesquita" class="form-control">
			</div>
			
			<div class="form-group">
				<label>Data do Evento:</label> 	
				<input type="datetime-local" name="dataEvento" value="2018-06-07T00:00" class="form-control">
			</div>
		

			<div class="form-group">
				<c:if test="${not empty contratantes}">
					<label>Contratante:</label>
					<select name="contratante" class="form-control">
						<c:forEach var="c" items="${contratantes}">
							<option value="${c.id}">${c.nome}</option>
						</c:forEach>
					</select>
				</c:if>
				<c:if test="${empty contratantes}">
					<c:set var="botao" value="disabled"/>
					<label>Não existem contratantes cadastrados!</label>
				</c:if>
			</div>
			
			<div class="form-group">
				<c:if test="${not empty artistas}">
					<label>Artistas:</label>
				    <c:forEach var="a" items="${artistas}">
				    <div class="form-check">
				      <label class="form-check-label">
			        		<input type="checkbox" name="artistas" value="${a.id}" class="form-check-input"> ${a.nome}
				      </label>
				    </div>
				    </c:forEach>
				</c:if>
				<c:if test="${empty artistas}">
					<c:set var="botao" value="disabled"/>
					<label>Não existem artistas cadastrados!</label>
				</c:if>
			</div>
			
			<button ${botao} type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>