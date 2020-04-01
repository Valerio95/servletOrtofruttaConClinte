<%@page import="it.dstech.servlet.modelli.Scontrino"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/style.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Stampa Scontrini</title>
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

<%List<Scontrino> listaScontrini = (List<Scontrino>)request.getAttribute("lista"); %>


<table>
<tr>
  <th>Lista Scontrini</th>
</tr>
<tr>
    <td>
Id
</td> 
<td>
Prezzo totale
</td> 
<td>
 Data di emissione
</td>    
  </tr>	
<% for(Scontrino p : listaScontrini){%>

<tr>

    <td>
<%=p.getId()%> 
</td> 
<td>
<%=p.getPrezzoTotale()%>
</td>
<td>
<%=p.getDataDiEmissione()%>
</td> 
<td>
<form action="dettagli">
<input type="number" hidden="true" name ="idScontrino" value=<%=p.getId()%>><br><br>
<input type="submit" class = "button newClass" value="Dettagli">
</form>

</td> 

  </tr>
<% } %>
</table>
<form action="intro">
<input type="submit" class = "button newClass" value="Torna in home"> </form>
</body>
</html>