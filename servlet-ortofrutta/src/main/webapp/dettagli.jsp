<%@page import="it.dstech.servlet.modelli.Prodotto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/style.css" rel="stylesheet" type="text/css">
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

<%List<Prodotto> listaProdotti = (List<Prodotto>)request.getAttribute("lista"); %>


<table>
<tr>
  <th>Lista Prodotti</th>
</tr>
<tr>
    <td>
Id
</td> 
<td>
Nome
</td> 
<td>
 Descrizione
</td>    
<td>
 Quantit�
</td> 
<td>
 Prezzo
</td>     
  </tr>	
<% for(Prodotto p : listaProdotti){%>
<tr>
    <td>
<%=p.getId()%> 
</td> 
<td>
<%=p.getNome()%>
</td>
<td>
<%=p.getDescrizione()%>
</td>    
<td>
 <%=p.getQuantit�()%> 
</td> 
<td>
<%=p.getPrezzo()%>
</td>    
  </tr>
<% } %>
</table>
<form action="intro">
<input type="submit" class = "button newClass" value="Torna in home"> </form>
</body>
</html>