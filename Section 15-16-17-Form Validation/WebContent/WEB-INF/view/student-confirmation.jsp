<!-- To use JSTL  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
	<title>Student Confirmation</title>
</head>
<body>

	The student is confirmed: ${student.firstName} ${student.lastName}
	
	<br><br>
	
	Student country: ${student.country}
	
	<br><br>
	
	Favourite language: ${student.favouriteLanguage}
	
	<br><br>
	
	Operating system: 
	
	<!-- Use JSTL to loop over array -->
	<ul>
		<c:forEach var="temp" items="${student.operatingSystems}">
			<li>${temp}</li>
		</c:forEach>
	</ul>

</body>
</html>