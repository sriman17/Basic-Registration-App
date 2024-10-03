<%@page import = "com.Registration.Student" %>
<%@page import = "java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Student Details</h1>

<table border = 1>
<thead><td><b>St No</b></td> <td><b>First Name</b></td> <td><b>Last Name</b></td> <td><b>City</b></td>
<td><b>Email</b></td> </thead> 

<% 

ArrayList<Student> sdata = (ArrayList<Student>)session.getAttribute("stdata");
int i =0;

System.out.println("Hello! from jsp");
for(Student s:sdata) {
	i++;
	System.out.println(s.getFirstname()+" "+s.getLastName()+" "+s.getAddress()+" "+s.getEmail());
	%> 
	
	<tr><td><%=i + " " %></td><td><%= s.getFirstname()+" " %> </td> <td><%= s.getLastName()+" " %></td> <td><%= s.getAddress()+" " %></td> <td><%= s.getEmail()+" " %> <br></td></tr>
	
	
	<%
}

%>

</body>
</html>