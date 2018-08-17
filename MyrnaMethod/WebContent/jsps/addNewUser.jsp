<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New User</title>
</head>
<body>
<h1> New User Details</h1>
 <form action="addNewUser.do" style="border:1px solid #ccc">
  <div class="container">
    
    <p>Please fill in this form to create an account.</p>
    <hr>

	<label for="firstName"><b>First Name</b></label>
    <input type="text" placeholder="Enter FirstName" name="firstName" required>
    
    <label for="lastName"><b>Last Name</b></label>
    <input type="text" placeholder="Enter LastName" name="lastName" required>

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" required>

    <label for="pswd"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" required>

	<label for="startDate"><b>Start Date</b></label>
    <input type="text" placeholder="mm/dd/yyyy" name="startDate" required>
    
	<label for="validFor"><b>Membership Term</b></label>
    <input type="text" placeholder="ex: 6 (months)" name="validFor" required>

    <label>
      <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
    </label>

    <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

    <div class="clearfix">
      <button type="button" class="cancelbtn">Cancel</button>
      <button type="submit" class="signupbtn">Sign Up</button>
    </div>
  </div>
</form> 
</body>
</html>