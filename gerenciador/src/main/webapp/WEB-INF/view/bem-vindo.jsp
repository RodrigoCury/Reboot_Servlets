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
	<h1>Bem-Vindo!</h1><br/>
	<a href="<c:url value="/entrada?acao=ListaEmpresas" />">Empresas</a>
</body>
</html>