<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Case Registration Form</title>
	
	<style>
		.error {color:red}
	</style>
	
</head>

<body>

	<h2>Case Registration Form</h2>
	
	<hr>

	<i>Fill out the form. Field marked with asterisk (*) is compulsory.</i>
	
	<form:form action="confirm" modelAttribute="newCase">
	
	First Name (*): <form:input path="firstName" />
	<form:errors path="firstName" cssClass="error" />
	
	<br><br>
	
	Last Name: <form:input path="lastName" />
	
	<br><br>
	
	Submitting officer: 
	<form:select path="officer">
		<form:options items="${theOfficerOptions}"/>
	</form:select>
	
	<br><br>
	
	<%-- Registration Date: <form:input path="registrationDate" />
	
	<br><br> --%>
	
	Email Address: <form:input path="emailAddress" />
	
	<br><br>
	
	TAT: 
	<%-- <form:select path="tat">
		<form:option value="30" label="30" />
		<form:option value="60" label="60" />
		<form:option value="90" label="90" />
		<form:option value="120" label="120" />
	</form:select> --%>
	
	<form:select path="tat">
		<form:options items="${newCase.TATOptions}" />
	</form:select>
	
	
	<br><br>
	
	Investigation type:
	
	<br><br>
	
	<form:radiobuttons path="investigationType"
					items="${newCase.investigationTypeOptions}"
					/>
	
	<%-- <form:radiobutton 
		path="investigationType" 
		value='Traffic Accident Reconstruction'/>
	Traffic Accident Reconstruction
	
	<br><br>
		
	<form:radiobutton 
		path="investigationType" 
		value='Paint Transfer Analysis' />
	Paint Transfer Analysis
	
	<br><br>
		
	<form:radiobutton 
		path="investigationType" 
		value='Urine Analysis' />
	Urine Analysis
	
	<br><br>
		
	<form:radiobutton 
		path="investigationType" 
		value='Crime Scene Reconstruction' />
	Crime Scene Reconstruction --%>
		
	<br><br>
	
	Submitted exhibits:
	
	<form:checkbox path="exhibit" value="DVD"/>
	DVD
	
	<br><br>
	
	<form:checkbox path="exhibit" value="Sketch plan"/>
	Sketch plan
	
	<br><br>
	
	<form:checkbox path="exhibit" value="Vehicle"/>
	Vehicle
	
	<br><br>
	
	<form:checkbox path="exhibit" value="Clothing" />
	Clothing
	
	<br><br>
	<form:checkbox path="exhibit" value="Compound"/>
	Compound
		
	<br><br>
	
	Manpower: <form:input path="manpower"/>
	<form:errors path="manpower" cssClass="error"/>
	
	<br><br>
	
	<input type="submit" value="Register" />
	
	</form:form>
	
	

</body>
	
</html>