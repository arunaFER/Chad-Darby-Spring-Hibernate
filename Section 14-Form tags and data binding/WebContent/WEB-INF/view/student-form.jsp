<!-- to use Spring MVC form tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>Student Form</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="student">
	
	First Name: <form:input path="firstName" />
	
	<br><br>
	
	Last Name: <form:input path="lastName" />
	
	<br><br>
	
	Country:
	<form:select path="country">
	
		<!-- Spring MVC will dynamically fill country options from student object -->
		<form:options items="${student.countryOptions}" />
		
	</form:select>
	
	<br><br>
	
	Favourite Language:
	
	Java <form:radiobutton path="favouriteLanguage" value="Java" />
	C# <form:radiobutton path="favouriteLanguage" value="C#" />
	PHP <form:radiobutton path="favouriteLanguage" value="PHP" />
	Ruby <form:radiobutton path="favouriteLanguage" value="Ruby" />
	
	<br><br>
	
	Operating systems
	
	<br>
	
	linux <form:checkbox path="operatingSystems" value="Linux"/>
	Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
	MS Windows <form:checkbox path="operatingSystems" value="MS Windows"/>
	
	<br><br>
	
	<input type="submit" value="submit"/>
	
	</form:form>

</body>
</html>