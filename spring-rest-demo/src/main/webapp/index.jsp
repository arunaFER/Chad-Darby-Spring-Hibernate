<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Rest Demo</title>
</head>
<body>

	<h2>Spring Rest Demo</h2>
	
	<br>
	
	<a href="test/hello">Hello</a>
	
	<br>
	
	<a href="${pageContext.request.contextPath}/api/students">Students</a>


</body>
</html>