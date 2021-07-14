<%@page import="it.epicode.web.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>jsp educata</title>
</head>
<body>
   <jsp:useBean id="pers" scope="session" class = "it.epicode.web.Persona"  ></jsp:useBean>
   <jsp:setProperty property="*" name="pers"/>
  
  <p>ciao  <%= request.getParameter("firstname") %> </p>
  
  
  <% // questo scriplet e'equivalente a riga 12
     String fn = request.getParameter("fistname");
     Persona pp = (Persona) request.getAttribute("pers");
     pp.setFirstname(fn);
     String ln = request.getParameter("lastname");
     pp.setLastname(ln);
     
  
  
  
    String name = request.getParameter("firstname");
    String surname = request.getParameter("lastname");
    Persona persona = new Persona(0, name, surname);
    
    request.setAttribute("myP", persona);
    // 1) leggere parametri
    // 2) creare oggetti con i valori di questi parametri
    // 3) mettere questi oggetti in uno degli "sgabuzzini"
   
  %>




  <%
     out.println(persona.getLastname());
     Persona p = (Persona) request.getAttribute("myP");
  %>
  <jsp:getProperty property="lastname" name="pers"/>

</body>
</html>