<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<meta charset="utf-8">
<title>Cadastro de Usuário</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp" />
	<div class="container">
		<form action="/usuario/incluir" method="POST">
			<div class="form-group">
				<label>Nome: </label> <input type="text" name="nome" value="Vic Hug"
					class="form-control" />
			</div>

			<div class="form-group">
				<label>E-mail: </label> <input type="email" name="email"
					value="vic@gmail.com" class="form-control" />
			</div>

			<div class="form-group">
				<label>Senha: </label> <input type="password" name="senha"
					value="123" class="form-control" />
			</div>

			<button type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>