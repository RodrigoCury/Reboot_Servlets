<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deleta Empresa</title>
</head>
<body style='background: #333; color: white;'>
	<form action="<c:url value="/entrada?acao=RemoveEmpresa" />" method='POST' style="display: flex; flex-direction: column;  height: 100px; justify-content: space-around; align-items: center;">
		<label for="id">ID da Empresa:</label>
		<input type="number" min="1" name="id" id="id" />
		<button type='submit'>Enviar</button>
	</form>
</body>
</html>