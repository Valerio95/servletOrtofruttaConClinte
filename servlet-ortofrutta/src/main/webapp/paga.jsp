<%@page import="it.dstech.servlet.modelli.Scontrino"%>
<%@page import="it.dstech.servlet.modelli.Prodotto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/style.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Paga</title>
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

<%Scontrino scontrino = (Scontrino)request.getAttribute("scontrino"); %>


<table>
<tr>
  <th>Scontrino</th>
</tr>
<tr>
    <td>
Id
</td> 
<td>
Nome
</td>  
<td>
 Quantità
</td> 
<td>
 Descrizione
</td>    
<td>
 Prezzo
</td>   
  </tr>	
<% for(Prodotto p : scontrino.getProdottiAquistati()){%>
<tr>
    <td>
<%=p.getId()%> 
</td> 
<td>
<%=p.getNome()%>
</td>  
<td>
 <%=p.getQuantità()%> 
</td> 
<td>
 <%=p.getDescrizione()%> 
</td>     
<td>
 <%=p.getPrezzo()%> 
</td>   
  </tr>
<% } %>
<tr>
    <td>
Costo Totale <%=scontrino.getPrezzoTotale()%> 

</td>   
  </tr>
</table>
<form action="intro">
<input type="submit" class = "button newClass" value="Paga"> </form>
</body>
</html>