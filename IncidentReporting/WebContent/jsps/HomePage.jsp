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
	
	<form name="addIncident" action="viewAllIncidents.do" method="post">
		<h3>Would you like to report an incident</h3>
		<a href="/IncidentReporting/jsps/addIncident.jsp"
			id="createIncident">Create New Incident</a> 
		<br><h3>Click if you would like to view all incident</h3>
		<input type="submit" id="viewAllIncident"
			name="viewAllIncident" value="View All Incidents">
	</form>
	<h3>Click if you would like to view all sessions</h3>
	<form name="viewAllSessions" action="viewAllSessions.do" method="post">
		<input type="submit" id="viewAllSessions" name="viewAllSessions"
			value="View All Sessions">
	</form>

	<script type="text/javascript">
		$("#voteAction").validate();
	</script>


</body>
</html>