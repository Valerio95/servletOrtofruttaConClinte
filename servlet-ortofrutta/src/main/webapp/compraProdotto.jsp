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


<% String messaggio = (String) request.getAttribute("messaggio"); 
	if (messaggio != null ){
		%>
		<h1>ERRORE</h1>
		<%=messaggio%>
					
	<% }
	else{
%>
<%List<Prodotto> listaProdotti = (List<Prodotto>)request.getAttribute("lista"); %>
<%List<Prodotto> carrello = (List<Prodotto>)request.getAttribute("carrello"); %>
<%int costoTotale = (Integer)request.getAttribute("costoTotale"); %>
<table>
<tr>
  <th>Carrello</th>
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
  Prezzo
  </td> 
   <td> 
  Costo Totale
  </td> 
  </tr>	
<% for(Prodotto p : carrello){%>
<tr>
    <td>
<%=p.getId()%>  <br><br>
</td> 
 <td> 
  <%=p.getNome()%>
  </td> 
  <td> 
  <%=p.getQuantità()%>
  </td> 
  <td> 
  <%=p.getPrezzo()%>
  </td> 
  
<% } %>
<td> 
  <%=costoTotale%>
  </td> 
</tr>

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



<% for(Prodotto p : listaProdotti){%>
<tr>
    <td>
<%=p.getId()%>  <br><br>
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

<form  action="compra" method="post">
<input type="number" hidden="true" name ="idCliente" value=<%=request.getAttribute("idCliente")%>><br><br>
	<p>IdProdotto : <select name="id">
<%for(Prodotto c : listaProdotti){%>
<option value=<%=c.getId()%> > id:<%=c.getId()%>
<% } %>
</select></p>
Quantità: <input type="number"  min = "1"name ="qta" ><br><br>
<input type="submit" name ="azione" value="Aggiungi"> <br><br>
<input type="submit" name ="azione" value="Compra"> <br><br>
</form>
<form action="intro">
<input type="submit" value="Torna in home"> </form>
<% } %>
</body>
</body>
</html>