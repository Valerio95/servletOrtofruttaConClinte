<%@page import="java.util.List"%>
<%@page import="it.dstech.servlet.modelli.Prodotto"%>
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
Quantità 
</td>  
  </tr>	
<%for(Prodotto p : listaProdotti){%>
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
<%=p.getQuantità()%> 
</td>  
  </tr>
<% } %>
</table>

<form action="rimuovi" method="post">
<p>IdProdotto: <select  name="prodottoScelto" >
<%for(Prodotto p : listaProdotti){%>
<option  value=<%=p.getId()%> > id:<%=p.getId()%> 
<% } %>
</select></p>
	<input type="submit" class = "button newClass" value="RIMUOVI"> <br><br>
</form>

<br><br>
<form action="intro">
<input type="submit" class = "button newClass" value="Torna in home"> </form>
</body>
</body>
</html>