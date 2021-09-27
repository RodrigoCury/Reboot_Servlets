<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, java.util.ArrayList, br.dev.rodrigocury.models.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empresas</title>
</head>
<body style='background: #333; color: white;'>
	Empresas: 
	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li>${empresa.nome }@${empresa.id}</li>
		</c:forEach>
	</ul>
</body>
</html>