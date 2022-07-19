<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    

<!DOCTYPE html>
<html>
<head>
	<title>luv2code company home page</title>
</head>
<body>

	<h2>luv2code company home page yoo-hoo!</h2>
	
	<hr>
	
	<!-- Display username and role -->
	<p>
		User: <sec:authentication property="principal.username"/>
		<br><br>
		Roles: <sec:authentication property="principal.authorities"/>
	</p>
	
	<hr>
	
	<p>Welcome!</p>
	
	<br><br>
	
	<sec:authorize access="hasRole('MANAGER')">

		<p>
			<a href="${pageContext.request.contextPath}/leaders">LeaderShip
				Meeting</a> (For Managers)
		</p>

	</sec:authorize>
	
	
	<sec:authorize access="hasRole('ADMIN')">
		<p>
			<a href="${pageContext.request.contextPath}/systems">Administrator
				Meeting</a> (For admins)
		</p>
	</sec:authorize>
	
	
	<!-- logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
    		method="POST">
    		
    		<input type="submit" value="Logout"/>
    		
    </form:form>

</body>
</html>