<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/style.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Errore</title>
</head>
<body>

<%=request.getAttribute("messaggio")%> 


<form action="intro">
<input type="submit" class = "button newClass" value="Torna in home"> </form>
</body>
</html>