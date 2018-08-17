<%@page import="com.incidentReporting.constants.Constants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Incidents In System</title>

<script type="text/javascript">
		function buttonClick(theButton) {
			document.getElementById('clicked_button').value = theButton.name;
			return true;
		}
	</script>

</head>
<body>
	<a href="/IncidentReporting/jsps/addSession.jsp" id="createSession">Create New Session</a><br>
	
	<a href="/IncidentReporting/jsps/HomePage.jsp" id="createIncident">HomePage</a><br>
		
	
	<form action="deleteRequestedIncident.do">
		<input type="hidden" name="clicked_button" id="clicked_button" value="" />
		<sql:setDataSource var="connection" driver="org.sqlite.JDBC"
			url="jdbc:sqlite:incidentReport" />
		<sql:query dataSource="${connection}"
			sql="Select incidentId, incidentName, incidentDesc, time , emailId from incident"
			var="result"></sql:query>
		<table border="2" cellpadding="10" bordercolor="black">
			<thead>
				<th>Incident Id</th>
				<th>Incident Name</th>
				<th>Incident Description</th>
				<th>Incident Creation Date/Time</th>
				<th>EmailId</th>
				<th>Action</th>
			</thead>

			<c:forEach var="rows" items="${result.rows}">

				<tr>
					<td>${rows.incidentId}</td>
					<td>${rows.incidentName}</td>
					<td>${rows.incidentDesc}</td>
					<td>${rows.time}</td>
					<td>${rows.emailId}</td>
					<td><input type="submit" name="delete" value="Delete ${rows.incidentId}"
						id="${rows.incidentId}" onclick="return buttonClick(this)"/></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>