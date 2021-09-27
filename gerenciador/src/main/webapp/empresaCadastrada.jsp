<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empresa Cadastrada</title>
</head>
<body style='background: #333; color: white;'>
	<c:if test="${error == true}">
		<h2>Houve um erro</h2>
	</c:if>
	<c:if test="${not empty empresa}">
		<h2>Empresa ${empresa.nome} cadastrada!</h2>
	</c:if>
</body>
</html> 