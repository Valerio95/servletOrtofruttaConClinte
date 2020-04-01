<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/style.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<style>
.center {
  position: static;
  left: 0;
  top: 10%;
  width: 100%;
  text-align: center;
  font-size: 18px;
}
.bottomleft {
  position: static;
  bottom: 8px;
  left: 16px;
  font-size: 18px;
}
</style>
<body>



<% String messaggio = (String) request.getAttribute("messaggio"); 
	if (messaggio != null ){
		%>
		<h1>ERRORE</h1>
		<%=messaggio%>
					
	<% }
	else{
%>
<div class="center">


<h1>Benvenuto nel nostro negozio</h1>
<h1>Cosa vuoi fare?</h1>
<form action="azioniMagazzino">
	<input type="submit" class = "button newClass" name ="azione" value="Aggiungi Prodotto" /> <br><br>
	<input type="submit" class = "button" name ="azione" value="Stampa Prodotti" /> <br><br>
	<input type="submit" class = "button" name ="azione" value="Stampa Vendite" /> <br><br>
	<input type="submit" class = "button" name ="azione" value="Rimuovi Prodotto" /> <br><br>
	<input type="submit" class = "button" name ="azione" value="Modifica Prodotto" /> <br><br>
	

</form>
</div>
<div class="bottomleft">

<form action="intro">
<input type="submit" class = "button newClass" value="Torna in home"> </form>
</div>
<% } %>
</body>
</html>

