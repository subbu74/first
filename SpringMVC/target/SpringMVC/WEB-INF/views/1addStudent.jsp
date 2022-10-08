<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<!DOCTYPE html>
<html>
<head>
<script  language="javascript"  type="text/javascript">
function validate()
{
	var firstnameRef = document.getElementById("sFirstName");
	if(firstnameRef.value == "")
	{
	 alert("First Name is required");
	/* firstnameRef.focus();*/
	 return false;
	}
	 
	 var firstnameRef = document.getElementById("sLastName");
		if(firstnameRef.value == ""){
		 alert("last Name is required");
		 firstnameRef.focus();
		 return false;
		}
}
	 </script>
</head>
<body>

<form:form  method="post" modelAttribute="student" action="saveStudentInfo"  onsubmit="return validate()">
<table>
<tr>
<td>FirstName:</td>
<td><input type="text" name="sFirstName" id="sFirstName" ></td>
</tr>

<tr>
<td>lastName:</td>
<td><input type="text" name="sLastName" id="sLastName" ></td>
</tr>

<tr>
<td>phoneNumber:</td>
<td><input type="text"  id="sPhoneNumber" ></td>
</tr>

<tr>
<td>Address:</td>
<td> <textarea  id="sAddress"  rows="5"  coloums="5"  ></textarea></td>
</tr>

<tr>
<td><input type="submit"  value="add Student" ></td>
</tr>

</table>


</form:form>

</body>
</html>