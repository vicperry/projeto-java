<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<meta charset="utf-8">
<title>Cadastro de Trapezista</title>
</head>
<body>


	<c:import url="/WEB-INF/jsp/menu.jsp" />

	<div class="container">

	<form action="/trapezista/incluir" method="post">
		<h3>Cadastro de Trapezista</h3>

		<c:import url="/WEB-INF/jsp/artista/cadastro.jsp" />

		<div class="form-group">
			<label>Características:</label>
			<div class="form-check">
				<label class="form-check-label"> <input type="checkbox"
					name="possuiRedeSegurança" value="true" class="form-check-input">
					Possui redes de segurança
				</label>
			</div>
		</div>

		<div class="form-group">
			<label>Altura:</label> <input type="number" name="altura" value="1.75"
				class="form-control">
		</div>

		<div class="form-group">
			<label>Número de acrobacias realizadas:</label> <input type="number" name="numeroAcrobaciasRealizadas" value="5"
				class="form-control">
		</div>

		<button type="submit">Cadastrar</button>
	</form>
	</div>
</body>
</html>