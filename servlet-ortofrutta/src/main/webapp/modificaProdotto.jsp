<%@page import="java.util.List"%>
<%@page import="it.dstech.servlet.modelli.Prodotto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/style.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Modifica Prodotto</title>
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
<td>
Prezzo 
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
<td>
<%=p.getPrezzo()%> 
</td>  
  </tr>
<% } %>
</table>
<div class="center">

<form action="modificaProdotto" method="post">
<p>IdProdotto: <select  name="idProdotto" >
<%for(Prodotto p : listaProdotti){%>
<option  value=<%=p.getId()%> > id:<%=p.getId()%> 
<% } %>
</select></p>
    Nome:<input type="text" name="nome" /><br><br>
	Quantità:<input type="number"min = "1" name="qta" /><br><br>
	Descrizione:<input type="text" name="descrizione" /><br><br>
	Prezzo:<input type="number" min = "1" name="prezzo" /><br><br>
	<input type="submit" class = "button newClass" value="Modifica"> <br><br>
</form>
</div>

<div class="bottomleft">
<form action="azioniMagazzino.jsp">
<input type="submit" class = "button newClass" value="Torna indietro"> </form>
</div>

</body>
</body>
</html>