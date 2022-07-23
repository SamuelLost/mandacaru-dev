<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="mandacaru.Person" %>
<%@ page import = "java.util.Enumeration" %>
<%--Importando pacotes --%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>:)</title>
<!-- <link rel="stylesheet" href="css/main.css"> -->
<!-- <script src="js/main.js"></script> -->
</head>
<body>
	<!-- Metodo GET pela URL-->	 
	<!-- http://localhost:8080/HelloMandacaru/main.jsp?first_name=Samuel&last_name=Henrique -->
	<b>First Name: </b>
	<% out.println("" + request.getParameter("first_name")); %>
	
	</br>
	
	<b>Last Name: </b>
	<% out.println("" + request.getParameter("last_name")); %>
	</br>
	
	<b>Matemática: </b>
	<% out.println("" + request.getParameter("maths")); %>
	</br>
	<b>Física: </b>
	<% 
	String req = request.getParameter("physics");
	
	if(req == null) out.println("off");
	else out.println("" + request.getParameter("physics")); %>
	</br>
	<b>Química: </b>
	<% out.println("" + request.getParameter("chemistry")); %>
 
 	<%--Realizada uma coleta genérica
	<%
    Enumeration paramNames = request.getParameterNames();
    while (paramNames.hasMoreElements()) {
        String paramName = (String) paramNames.nextElement();
        out.print("<p>" + paramName + ": ");
        String paramValue = request.getParameter(paramName);
        out.println(paramValue);
    }
    %>
    --%>
</body>

</html>