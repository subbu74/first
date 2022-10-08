<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<title> Add Employee </title>
 <script language = "javascript" type = "text/javascript">
function validateForm() {
var firstnameRef = document.getElementById("firstName");
   if(firstnameRef.value == ""){
    alert("First Name is required");
    firstnameRef.focus();
    return false;
}
var lastNameRef = document.getElementById("lastName");
   if(lastNameRef.value == ""){
   document.getElementById("error_lastName").style.display = "";
    return false;    
} else {
  document.getElementById("error_lastName").style.display = "none";
}

var salaryRef = document.getElementById("salary");
   if(salary.value == ""){
    alert("Salary is required");
    return false;
}
}
</script>
</head>
<body>
<form:form method="post" modelAttribute="employee" action="saveemployeeinfo" onsubmit="return validateForm()">
Add New Employee
<br>
<br>
<table>
<tr>
<td>First Name:</td>
<td><input type="text" name="firstName" id="firstName"></td>
</tr>
<tr>
<td>Last Name:</td>
<td> <input type="text" name="lastName" id="lastName"><span id="error_lastName" style="display:none"> Last Name is required</span></td>
</tr>
<tr>
<td>Middle Name:</td>
<td> <input type="text" name="middleName" id="middleName"></td>
</tr>
<tr>
<td>Salary:</td>
<td> <input type="number" name="salary" id="salary" step="any"></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="Add Employee">
</td>
</tr>
</form:form>
</body>
</html>