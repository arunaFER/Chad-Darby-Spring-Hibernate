<!-- to use Spring MVC form tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>Customer Registration Form</title>
	
	<style>
	 	.error {color:red}
	</style>
</head>
<body>

	<h2>Customer Registration Form</h2>

	<form:form action="processForm" modelAttribute="customer">
	
		First Name: <form:input path="firstName"/>
		
		<br><br>
		
		Last Name (*): <form:input path="lastName"/>
		<!-- To display errors -->
		<form:errors path="lastName" Class="error" />
		
		<br><br>
		
		Free passes: <form:input path="freePasses"/>
		<form:errors path="freePasses" class="error"/>
		
		<br><br>
		
		Postal code: <form:input path="postalCode"/>
		<form:errors path="postalCode" class="error"/>
		
		<br><br>
		
		Course code: <form:input path="courseCode"/>
		<form:errors path="courseCode" class="error"/>
		
		<br><br>
		
		
		<input type="submit" value="submit" />
	
	</form:form>

</body>
</html>