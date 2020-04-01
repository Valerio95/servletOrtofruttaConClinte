<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/style.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>



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
	<input type="submit" class = "button newClass" name ="azione" value="Aggiungi" /> <br><br>
	<input type="submit" class = "button" name ="azione" value="Stampa" /> <br><br>
	<input type="submit" class = "button" name ="azione" value="StampaVendite" /> <br><br>
	<input type="submit" class = "button" name ="azione" value="Rimuovi" /> <br><br>
	<input type="submit" class = "button" name ="azione" value="aggiungiCliente" /> <br><br>
	<input type="submit" class = "button" name ="azione" value="rimuoviCliente" /> <br><br>
	<input type="submit" class = "button" name ="azione" value="accedi" /> 

</form>

<% } %>
</body>
</html>

