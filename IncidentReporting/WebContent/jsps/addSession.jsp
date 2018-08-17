<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Session Management</title>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script>
	src = "js/jquery.validate.js" >
</script>

</head>

<body>
	<h1>Incident Report</h1>
	<form name="addSession" action="addSession.do" method="post">
		<h1>Would you like to add session?</h1>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="/IncidentReporting/jsps/HomePage.jsp" id="createIncident">New
			Incident</a>&nbsp;
		<table>
			<tr>
				<td>Session Name: &nbsp;</td>
				<td><input type="text" id="sessionName" name="sessionName"
					required> &nbsp; <br></td>
			</tr>

			<tr>
				<td>Session Description: &nbsp;</td>
				<td><input type="text" id="sessionDesc" name="sessionDesc"
					required></td>
			</tr>

			<tr>
				<td>Session Status: &nbsp;</td>
				<td><select id="sessionStatus" name="sessionStatus">
						<option value="inProgress" selected>In Progress</option>
						<option value="completed">Completed</option>
				</select></td>
			</tr>

			<tr>
				<td>Session Malware Scan Status: &nbsp;</td>
				<td><select name="malwareStatus" id="malwareStatus">
						<option value="success" selected>Success</option>
						<option value="failed">Failed</option>
				</select></td>
				
			</tr>

		</table>

		<input type="submit" id="newSession" name="newSession"
			value="Create Session" required>
	</form>

	<script type="text/javascript">
		$("#addSession").validate();
	</script>

</body>
</html>