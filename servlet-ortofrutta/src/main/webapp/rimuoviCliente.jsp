<%@page import="java.util.List"%>
<%@page import="it.dstech.servlet.modelli.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/style.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Rimuovi Cliente</title>
</head>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
} th, td {
  border: 1px solid black;
  text-align: left;
	padding: 8px;
}
tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
<body>

<%List<Cliente> listaClienti = (List<Cliente>)request.getAttribute("lista"); %>


<table>
<tr>
  <th>Lista Clienti</th>
    
</tr>	
<tr>
  <td>Id Cliente</td> 
  <td>Nome Cliente</td>
    
</tr>	
<%for(Cliente c : listaClienti){%>
<tr>
    <td>
<%=c.getId()%></td>
    <td>
 <%=c.getNome()%>  
</td>  
  </tr>
<% } %>
</table>

<form action="rimuoviCliente" >
<p>Clienti : <select name="idCliente">
<%for(Cliente c : listaClienti){%>
<option value=<%=c.getId()%> > <%=c.getId()%>
<% } %>
</select></p>
	<input type="submit" class = "button newClass" value="Elimina"> <br><br>
</form>

<br><br>
<form action="intro">
<input type="submit" value="Torna in home"> </form>
</body>
</body>
</html>