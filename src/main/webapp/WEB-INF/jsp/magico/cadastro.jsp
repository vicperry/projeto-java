<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<meta charset="utf-8">
<title>Cadastro de Mágicos</title>
</head>
<body>


	<c:import url="/WEB-INF/jsp/menu.jsp" />

	<div class="container">

	<form action="/magico/incluir" method="post">
		<h3>Cadastro de Mágicos</h3>

		<c:import url="/WEB-INF/jsp/artista/cadastro.jsp" />

		<div class="form-group">
			<label>Características:</label>
			<div class="form-check">
				<label class="form-check-label"> <input type="checkbox"
					name="fazPirotecnia" value="true" class="form-check-input">
					Faz Pirotecnia
				</label>
			</div>
		</div>

		<div class="form-group">
			<label>Número de truques:</label> <input type="number" name="numeroTruques" value="10"
				class="form-control">
		</div>

			<div class="form-check">
				<label class="form-check-label"> <input type="checkbox"
					name="usaCoelho" value="true" class="form-check-input">
					Usa Coelho
				</label>
			</div>

		<button type="submit">Cadastrar</button>
	</form>
	</div>
</body>
</html>