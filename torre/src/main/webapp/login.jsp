<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="section-login">
			<form method="post" action="login">
				<h4>LOGIN</h4>
				<div class="form-group">
					<div class="col-25">
						<label for="username">Usuario:</label>
					</div>
					<div class="col-75">
						<input id="username" name="username" type="text"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-25">
						<label for="password">Contraseña:</label>
					</div>
					<div class="col-75">
						<input id="password" name="password" type="password"/>
					</div>
				</div>
				<div class="center">
					<input type="submit" value="INGRESAR"/>
				</div>
			</form>
		</div>
	</div>
	
</body>
</html>