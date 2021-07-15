<%@page import="it.epicode.web.mvc.model.Impiegato"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Impiegati</title>
</head>
<body>
	<h1>Lista Impiegati</h1>

	<%--
	List<Impiegato> imps = (List<Impiegato>) request.getAttribute("ALL_EMPLOYEES");
	for (Impiegato emp : imps) {
		out.print(emp.getFirstname() + "<br>");
	}
	--%>
	
	<c:forEach items="${ALL_EMPLOYEES}" var="employee">
		<p>${employee.id}  ${employee.firstname} ${employee.lastname} ${employee.role} 
		 <a href="mostraFormUpdateImpiegato.do?id=${employee.id}">modifica</a></p>
		<br />
	

	</c:forEach>

	<br>
	<a href="mostraformaggiuntaimpiegato.do">Vai alla form di aggiunta
		impiegato</a>
</body>
</html>