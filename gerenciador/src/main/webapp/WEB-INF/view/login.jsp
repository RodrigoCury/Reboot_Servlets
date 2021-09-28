<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style='background: #333; color: white;'>
	<form action="<c:url value="/entrada?acao=Login" />" method='POST' style="display: flex; flex-direction: column;  height: 150px; justify-content: space-around; align-items: center;">
		<label for="login">Login: </label>
		<input type="text" name="login" id="login" />
		<label for="senha">Senha: </label>
		<input type="password" name="senha" id="senha" />
		<c:if test="${not empty error}">
			<p style="color: red;">${error}</p>
		</c:if>
		<button type='submit'>Enviar</button>
	</form>
</body>
</html>