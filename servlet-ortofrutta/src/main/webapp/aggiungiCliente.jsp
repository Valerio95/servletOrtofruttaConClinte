<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Inserisci il nome del nuovo cliente</h1>

<form action="nuovoCliente" method="post">
	Nome:<input type="text" name="nome" /><br><br>
	<input type="submit" name ="azione" value="Aggiungi" /> <br>
</form>
</body>
</html>