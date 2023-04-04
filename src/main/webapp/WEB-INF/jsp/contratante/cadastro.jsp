<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<meta charset="utf-8">
<title>Cadastro de Contratante</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp" />
	<div class="container">

		<form action="/contratante/incluir" method="POST">
			<div class="form-group">
				<label>Nome: </label> <input type="text" name="nome"
					value="Contratante do Mal" class="form-control" />
			</div>

			<div class="form-group">
				<label>Telefone: </label> <input type="tel" name="telefone"
					value="123456789" class="form-control" />
			</div>

			<div class="form-group">
				<label>CPF: </label> <input type="text" name="cpf"
					value="12345678900" class="form-control" />
			</div>

			<c:import url="/WEB-INF/jsp/endereco/cadastro.jsp" />


			<button type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>