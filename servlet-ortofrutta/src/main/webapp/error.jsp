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
<style>

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
<div class="center">

<%=request.getAttribute("messaggio")%> 
</div>
<div class="bottomleft">

<form action="intro">
<input type="submit" class = "button newClass" value="Torna in home"> </form>
</div>
</body>
</html>