<%@page import="java.util.List"%>
<%@page import="it.dstech.servlet.modelli.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
<body>
<%List<Cliente> listaClienti = (List<Cliente>)request.getAttribute("lista"); %>


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
<h1>Inserisci il nome del nuovo cliente</h1>

<form action="nuovoCliente" method="post">
	Nome:<input type="text" name="nome" /><br><br>
	<input type="submit" name ="azione" value="Aggiungi" /> <br>
</form>
<form action="intro">
<input type="submit" value="Torna in home"> </form>
</body>
</html>