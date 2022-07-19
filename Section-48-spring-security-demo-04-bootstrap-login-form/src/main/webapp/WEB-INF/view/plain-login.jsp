    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
    <!DOCTYPE html>
    
    <html>
    
    <head>
    	<title>Custom Login Page</title>
    	
    	<style>
    		.error{
    		 color: red;
    		}
    	
    	</style>
    </head>
    
    <body>
    
    	<h3>My Custom Login Page</h3>
    	
    	<form:form action="${pageContext.request.contextPath}/authenticateTheUser"
    		method="POST">
    		
    		
    		<!-- Check for login error -->
    		<c:if test="${param.error != null}">
    			<i class="error">Invalid username or password</i>
    		</c:if>    	    		
    		
    		<p>
    			Username: <input type="text" name="username"/>
    		</p>
    		
    		<p>
    			Password: <input type="text" name="password"/>
    		</p>
    		
    		<input type="submit" value="Login"/>
    		
    	</form:form>
        
    </body>
   
    </html>