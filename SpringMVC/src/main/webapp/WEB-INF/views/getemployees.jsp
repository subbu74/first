<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<html>
<head>
<title> Employees </title>
</head>
<body>
Employees List
<br>
<br>
<table border="1">
<tr>
<th>Id</th>
<th>First Name</th>
<th>Last Name</th>
<th>Middle Name</th>
<th>Salary</th>
<th>Action</th>
</tr>
<c:forEach items="${employees}" var="emp">
<tr>
<td>${emp.id}</td>
<td>${emp.firstName}</td>
<td>${emp.lastName}</td>
<td>${emp.middleName}</td>
<td>${emp.salary}</td>
<td><a href="editemployee/${emp.id}">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="deleteemployee/${emp.id}">Delete</a></td>
</tr>
</c:forEach>
</table>
<br>
<a href="dispalyaddemployeepage">Add Employee</a>
</body>
</html>