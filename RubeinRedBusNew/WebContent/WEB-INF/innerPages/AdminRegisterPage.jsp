<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Registration</title>
<script type="text/javascript">
function validateEmployee(){
	if(CustomerReg.Name.value.length<1){
		window.alert("Empty First Name");
		document.CustomerReg.Name.focus();
		return false;
		}
	
	if(CustomerReg.email.value==""){
		window.alert("Empty Email Field");
		document.CustomerReg.email.focus();
		return false;
		}

	if(CustomerReg.password.value==""){
		window.alert("Empty Password");
		document.CustomerReg.password.focus();
		return false;
		}
	
	if(CustomerReg.password.value.length<6){
		window.alert("Password length less than 6");
		document.CustomerReg.password.focus();
		return false;
		}
	
	if(CustomerReg.mobile.value==""){
		window.alert("Empty Field");
		document.CustomerReg.mobile.focus();
		return false;
		
		}
	
	if(CustomerReg.mobile.value.length!=10){
		window.alert("Incorrect mobile length");
		document.CustomerReg.mobile.focus();
		return false;
		}
	
	if(CustomerReg.age.value.length==""){
		window.alert("Empty age field");
		document.CustomerReg.age.focus();
		return false;
		}
		
	   return( true );
}
</script>
</head>

<body >
<center>
<img src="\C:\Users\rubein.shaikh\Desktop\logo.jpg"></img>

<h3>Admin Registration</h3>

<form name=AdminReg action="RegisterNewAdmin.do" method=post onsubmit="return validateEmployee()">
<table>
<tr><td>Name:</td>
<td><input type="text" name="Name"></td></tr>

<tr><td>Age:</td>
<td><input type="text" name="age"></td></tr>

<tr><td>Mobile No.:</td>
<td><input type="text" name="mobile"></td></tr>

<tr><td>E-mail:</td>
<td><input type="email" name="email"></td></tr>

<tr><td>Password:</td>
<td><input type="password" name="password"></td></tr>

<tr><td><input type=submit name="SUBMISSION" value="Go" /></td>
<td><input type=reset name="SUBMISSION" value=EDIT />

</table>
</form>
</center>
</body>
</html>