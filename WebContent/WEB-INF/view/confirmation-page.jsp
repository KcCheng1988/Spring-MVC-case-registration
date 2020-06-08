<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Registration Confirmation Page</title>
</head>

<body>

	<h3>
	Thank you! You case is successfully registered. Please verify the case details below.
	</h3>
	
	<hr>
	
	
	Registering Officer: ${newCase.lastName} ${newCase.firstName}
	
	<br><br>
	
	Submitting Officer: ${newCase.officer}
	
	<br><br>
	
	Registration Date: ${regDate}
	
	<br><br>
	
	Case Type: ${newCase.tat}
	
	<br><br>
	
	Investigation Type: ${newCase.investigationType }
	
	<br><br>
	
	TAT Date: ${tatDate}
	
	<br><br>
	
	Contact email: ${newCase.emailAddress}
	
	<br><br>
	
	Exhibit submitted:
	
	<ul>
	<c:forEach var="temp" items="${newCase.exhibit}">
		<li>${temp}</li>
	</c:forEach>
	</ul>
	
	
	Estimated manpower: ${newCase.manpower}
	
	
</body>

</html>