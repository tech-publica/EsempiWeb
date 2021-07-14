<%@page import="it.epicode.web.mvc.model.Impiegato"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Impiegati</title>
</head>
<body>
   <h1>Lista Impiegati</h1>
   
   <%
       List<Impiegato> imps = (List<Impiegato>) request.getAttribute("ALL_EMPLOYEES");
       for(Impiegato emp : imps) {
    	   out.print(emp.getFirstname() + "<br>");
       }
   %>
   
   <br><a href="aggiungiImpiegato.html">Vai alla form di aggiunta impiegato</a>
</body>
</html>