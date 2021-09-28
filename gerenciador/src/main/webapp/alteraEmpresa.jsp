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
	<form action="<c:url value="/mostraEmpresa?id=${empresa.id}" />" method='POST' style="display: flex; flex-direction: column;  height: 100px; justify-content: space-around; align-items: center;">
		<label for="nome">Nome da Empresa:</label>
		<input type="text" name="nome" id="nome" value="${empresa.nome }"/>
		<button type='submit'>Enviar</button>
	</form>
</body>
</html>