<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/style.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Welcome Cliente</title>
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

<div class="center">

<% String messaggio = (String) request.getAttribute("messaggio"); 
	if (messaggio != null ){
		%>
		<h1>ERRORE</h1>
		<%=messaggio%>
					
	<% }
	else{
%>


<h1>Benvenuto cliente <%=request.getParameter("idCliente")%></h1>
<h1>Cosa vuoi fare?</h1>


<form action="cliente" method="get">

<input type="number" hidden="true" name ="idCliente2" value=<%=Integer.parseInt(request.getParameter("idCliente"))%>><br><br> 
	<input type="submit"  class = "button newClass" name ="azione" value="compra" /> <br><br>
	<input type="submit" class = "button" name ="azione" value="stampaScontrini" /> <br><br>
</form>
</div>
<div class="bottomleft">
<form action="azioniCliente.jsp">
<input type="submit" class = "button newClass" value="Torna indietro"> </form>
</div>
<% } %>
</body>
</html>

