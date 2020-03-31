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
	<input type="submit" value="Elimina"> <br><br>
</form>

<br><br>
<form action="intro">
<input type="submit" value="Torna in home"> </form>
</body>
</body>
</html>