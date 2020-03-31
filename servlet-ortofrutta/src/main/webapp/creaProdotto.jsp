<%@page import="java.util.List"%>
<%@page import="it.dstech.servlet.modelli.Prodotto"%>
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
Quantità 
</td>  
<td>
Descrizione 
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
<%=p.getQuantità()%> 
</td> 
<td>
<%=p.getDescrizione()%></td>
<td>
<%=p.getPrezzo()%>
</td>    
  </tr>
<% } %>
</table>
<h1>Inserisci i parametri del nuovo prodotto</h1>

<form action="negozio" method="post">
	Nome:<input type="text" name="nome" /><br><br>
	Quantità:<input type="number"min = "1" name="qta" /><br><br>
	Descrizione:<input type="text" name="descrizione" /><br><br>
	Prezzo:<input type="number" min = "1" name="prezzo" /><br><br>
	<input type="submit" name ="azione" value="Aggiungi" /> <br>
</form>
<form action="intro">
<input type="submit" value="Torna in home"> </form>
</body>
</html>