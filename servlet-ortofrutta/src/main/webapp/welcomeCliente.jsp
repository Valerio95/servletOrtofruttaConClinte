<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/style.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Welcome Cliente</title>
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


<h1>Benvenuto cliente <%=request.getParameter("idCliente")%></h1>
<h1>Cosa vuoi fare?</h1>


<form action="cliente" method="get">

<input type="number" hidden="true" name ="idCliente2" value=<%=Integer.parseInt(request.getParameter("idCliente"))%>><br><br> 
	<input type="submit"  class = "button newClass" name ="azione" value="compra" /> <br><br>
	<input type="submit" class = "button" name ="azione" value="stampaScontrini" /> <br><br>
</form>

<% } %>
</body>
</html>

