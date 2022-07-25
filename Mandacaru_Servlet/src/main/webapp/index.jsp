<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="mandacaru.Person"%>

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
	<!-- 	<h1>Hello World</h1> -->
	<!-- 	<img src="images/onix-rs.png" /> -->
	<!-- Scriplet e alternancia entre Java e HTML-->
	<%-- 	<% 
// 	int fontSize = 0;
// 	for (fontSize = 1; fontSize <= 3; fontSize++) {
--%>
	<%-- 	%> --%>
	<%-- 	<font color="green" size="<%=fontSize%>"> JSP Tutorial </font> --%>
	<!-- 	<br /> -->
	<%-- 	<%}%> --%>
	<!-- GET por formulário -->
<!-- 	<form action="main.jsp" method="GET"> -->
<!-- 		First Name: <input type="text" name="first_name"> <br /> -->
<!-- 		Last Name: <input type="text" name="last_name" /> <br />  -->
<!-- 		<input type="submit" value="Submit" /> -->
<!-- 	</form> -->

	<!-- POST - esconde os parametros da URL-->
<!-- 	<form action="main.jsp" method="POST"> -->
<!-- 		First Name: <input type="text" name="first_name"> <br /> -->
<!-- 		Last Name: <input type="text" name="last_name" /> <br />  -->
		
<!-- 		<input type = "checkbox" name = "maths" checked = "checked" /> Maths -->
<!-- 		<input type = "checkbox" name = "physics" /> Physics -->
<!-- 		<input type = "checkbox" name = "chemistry" checked = "checked" /> Chemistry </br>  -->
<!-- 		<input type="submit" value="Submit" /> -->
<!-- 	</form> -->

<!-- 	<form action="Hello" method="GET"> Testando Servlet -->
<!-- 		First Name: <input type="text" name="first_name"> <br /> -->
<!-- 		Last Name: <input type="text" name="last_name" /> <br />  -->
		
<!-- 		<input type = "checkbox" name = "maths" checked = "checked" /> Maths -->
<!-- 		<input type = "checkbox" name = "physics" /> Physics -->
<!-- 		<input type = "checkbox" name = "chemistry" checked = "checked" /> Chemistry </br>  -->
<!-- 		<input type="submit" value="Submit" /> -->
<!-- 	</form> -->

	<form action="ok" method="POST"> <!-- Passa como array -->
        First Name: <input type="text" name="first_name"> <br /> 
        Last Name: <input type="text" name="last_name" /> <br />
        <input type = "checkbox" name="subject" value = "maths" checked = "checked" /> Maths
        <input type = "checkbox" name="subject" value = "physics"  /> Physics
        <input type = "checkbox" name="subject" value = "chemistry" checked = "checked" /> Chemistry
        <input type="submit" value="Submit" />
    </form>

</body>

</html>