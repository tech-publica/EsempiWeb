<%@page import="it.epicode.web.mvc.model.data.DataException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Errore connessione dati</title>
</head>
<body>
   <%
   DataException de = (DataException) request.getAttribute("EXCEPTION");
   out.println("errore connessione dati: " + de.getMessage());
   %>
</body>
</html>