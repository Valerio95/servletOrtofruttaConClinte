<%@page import="it.dstech.servlet.modelli.Prodotto"%>
<%@page import="java.util.List"%>
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

<%List<Prodotto> listaProdotti = (List<Prodotto>)request.getAttribute("lista");  %>


<table>
<tr>
  <th>Lista Prodotti</th>
</tr>
<tr>
    <td>
Nome
</td>  
<td>
 Descrizione
</td>  
<td>
 Quantità
</td>  
<td>
 Prezzo
</td>  
  </tr>	
<%for(Prodotto p : listaProdotti){%>
<tr>
    <td>
 <%=p.getNome()%>
</td> 
<td>
 <%=p.getDescrizione()%>
</td>   
<td>
 <%=p.getQuantità()%> 
</td> 
<td>
 <%=p.getPrezzo()%> 
</td>   
  </tr>
<% } %>
</table>
<form action="intro">
<input type="submit" value="Torna in home"> </form>
</body>
</html>