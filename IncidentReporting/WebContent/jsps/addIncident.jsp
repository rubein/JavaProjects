<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Incident Management</title>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script>
	src = "js/jquery.validate.js" >
</script>

</head>

<body>
	<h1>Incident Report</h1>
	<form name="addIncident" action="addIncident.do" method="post">
		<h1>Please fill in all the fields?</h1>

		<table>
			<tr>
				<td>Incident Name: &nbsp;</td>
				<td><input type="text" id="incidentName" name="incidentName"
					required> &nbsp; <br></td>
			</tr>

			<tr>
				<td>Incident Description: &nbsp;</td>
				<td><input type="text" id="incidentDesc" name="incidentDesc"
					required></td>
			</tr>
			
			<tr>
				<td>Email: &nbsp;</td>
				<td><input type="email" id="email" name="email"
					required> &nbsp; <br></td>
			</tr>
		</table>


		<input type="submit" id="newIncident" name="newIncident"
			value="Create Incident" required>

	</form>

	<script type="text/javascript">
		$("#addIncident").validate();
	</script>


</body>
</html>