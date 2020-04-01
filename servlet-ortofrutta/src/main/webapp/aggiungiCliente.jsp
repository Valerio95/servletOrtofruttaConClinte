<%@page import="java.util.List"%>
<%@page import="it.dstech.servlet.modelli.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/style.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Nuovo Cliente</title>
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
<%List<Cliente> listaClienti = (List<Cliente>)request.getAttribute("lista"); %>

<div>
<table>
<tr>
  <th>Lista Clienti</th>
</tr>
<tr>
    <td>
Id
</td>  
<td>
Nome
</td>  
  </tr>	
<%for(Cliente p : listaClienti){%>
<tr>
    <td>
<%=p.getId()%>
</td>  
<td>
 <%=p.getNome()%>
</td>  
  </tr>
<% } %>
</table>
</div>
<div class="center">
<h1>Inserisci il nome del nuovo cliente</h1>

<form action="nuovoCliente" method="post">
	Nome:<input type="text" name="nome" /><br><br>
	<input type="submit" class = "button newClass" name ="azione" value="Aggiungi" /> <br>
</form>
</div>
<div class=bottomleft>
<form action="azioniCliente.jsp">
<input type="submit" class = "button newClass" value="Torna indietro"> </form>
</div>
</body>
</html>