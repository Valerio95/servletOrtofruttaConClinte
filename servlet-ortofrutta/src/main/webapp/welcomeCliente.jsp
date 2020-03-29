<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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


<h1>Benvenuto cliente</h1>
<h1>Cosa vuoi fare?</h1>


<form action="cliente" method="get">

<input type="number" hidden="true" name ="idCliente2" value=<%=Integer.parseInt(request.getParameter("idCliente"))%>><br><br> 
	<input type="submit" name ="azione" value="compra" /> <br><br>
	<input type="submit" name ="azione" value="stampaScontrini" /> <br><br>
</form>

<% } %>
</body>
</html>

