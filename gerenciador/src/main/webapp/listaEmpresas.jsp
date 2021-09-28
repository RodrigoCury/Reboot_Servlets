<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, java.util.ArrayList,br.dev.rodrigocury.gerenciador.models.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empresas</title>
</head>
<body style='background: #333; color: white; display: flex; flex-direction: column;' >

	<c:if test="${error == true}">
		<h2>Houve um erro</h2>
	</c:if>
	
	<c:if test="${error == null }">
		<c:if test="${not empty empresa}">
			<h2>Empresa ${empresa.nome} cadastrada!</h2>
		</c:if>
		
		<c:if test="${empty empresas }">
			<h2>Não há empresas cadastradas</h2>
			
		</c:if>
		
		<c:if test="${not empty empresas }">
			Empresas: 
			<ul>
				
				<c:forEach items="${empresas}" var="empresa">
					<li style="width: 150px; display: flex; flex-direction: row; justify-content: space-between;">
						${empresa.nome }@${empresa.id} 
						<a href="<c:url value='/entrada?acao=RemoveEmpresa&id=${empresa.id}'/>">x</a>
						<a href="<c:url value='/entrada?acao=MostraEmpresa&id=${empresa.id}'/>">Editar</a>
					</li>
				</c:forEach>
			</ul>	
		</c:if>	
	</c:if>
	<a href='<c:url value="/novaEmpresa"/>'>Cadastrar nova Empresa</a>
</body>
</html>