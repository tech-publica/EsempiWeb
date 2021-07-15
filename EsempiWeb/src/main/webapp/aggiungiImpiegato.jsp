<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="ISO-8859-1">
<title>Form inserimento nuovo impiegato</title>
</head>
<body>
	
	  <c:if test = "${!empty toUpdate}">
         <form method="POST" action="updateimpiegato.do">
      </c:if>
	  <c:if test = "${empty toUpdate}">
         <form method="POST" action="inserisciimpiegato.do">
      </c:if>
	
	
		<label for="id">Id:</label><input <c:if test = "${!empty toUpdate}">readonly</c:if> id ="id" type="text" name="id" value = "${toUpdate.id}"><br>
		<label for="firstname">Nome:</label><input id= "firstname" type="text" name="firstname" value = "${toUpdate.firstname}"><br>
		<label for="lastname">Cognome:</label><input id = "lastname"  type="text" name="lastname" value = "${toUpdate.lastname}"><br>
		<label for="role">Ruolo Aziendale:</label><input id= "role" type="text" name="role" value = "${toUpdate.role}"><br>
		<input type="submit" value="inserisci">

	</form>
	
	<a href="listaimpiegati.do">Vai alla lista degli impiegati</a>
</body>
</html>