<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/style.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<style>


.center {
  position: static;
  left: 0;
  top: 10%;
  width: 100%;
  text-align: center;
  font-size: 18px;
}


</style>
</head>
<body>

<div class="center">

<% String messaggio = (String) request.getAttribute("messaggio"); 
	if (messaggio != null ){
		%>
		<h1>ERRORE</h1>
		<%=messaggio%>
					
	<% }
	else{
%>


<h1>Benvenuto nel nostro negozio</h1>
<h1>Cosa vuoi fare?</h1>

<form action="scegliAzione">
	<input type="submit" class = "button newClass" name ="azione" value="Azioni Magazzino" /> <br><br>
    <input type="submit" class = "button" name ="azione" value="Azioni Cliente" /> <br><br>	
</form>
</div>
<% } %>
</body>
</html>

