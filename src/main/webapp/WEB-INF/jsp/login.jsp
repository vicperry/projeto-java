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
		<h2>Autenticação</h2>

		<form action="/login" method="post">

			<div class="form-group">
				<label>E-mail:</label> <input type="email" class="form-control"
					placeholder="Entre com o seu e-mail" name="email"
					value="vic@gmail.com">
			</div>

			<div class="form-group">
				<label>Senha:</label> <input type="password" class="form-control"
					placeholder="Entre com a sua senha" name="senha"
					value="vic@gmail.com">
			</div>

			<button type="submit" class="btn btn-default">Acessar</button>
		</form>
	</div>

</body>
</html>