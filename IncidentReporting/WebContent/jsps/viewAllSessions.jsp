<%@page import="com.incidentReporting.constants.Constants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Sessions In Database</title>
<script type="text/javascript">
		function buttonClick(theButton) {
			document.getElementById('clicked_button').value = theButton.name;
			<%-- <% request.setAttribute("buttonClicked", ""); %> --%> 
			return true;
		}
	</script>
</head>
<body>
	<form action="deleteRequestedSession.do" method="post">
		<sql:setDataSource var="connection" driver="org.sqlite.JDBC"
			url="jdbc:sqlite:incidentReport" />
		<sql:query dataSource="${connection}" sql="Select * from session"
			var="result"></sql:query>

		<input type="hidden" name="clicked_button" id="clicked_button"
			value="" />
		
		<a href="/IncidentReporting/jsps/addSession.jsp" id="createSession">Create New Session</a><br>
		<a href="/IncidentReporting/jsps/HomePage.jsp" id="createIncident">HomePage</a><br>
		
		<table border="2" cellpadding="10" bordercolor="black">
			<thead>
				<th>Session Id</th>
				<th>Incident Id</th>
				<th>Session Name</th>
				<th>Session Creation Date/Time</th>
				<th>Session Status</th>
				<th>Malware Scan Status</th>
				<th>Update</th>
				<th>Delete</th>
			</thead>

			<c:forEach var="rows" items="${result.rows}">
				<tr>
					<td>${rows.sessionId}</td>
					<td>${rows.incidentId}</td>
					<td>${rows.sessionName}</td>
					<td>${rows.time}</td>
					<td><select name="sessionStatus">
							<option value="${rows.sessionStatus}" selected disabled hidden>${rows.sessionStatus}</option>
							<option value="inProgress">inProgress</option>
							<option value="completed">completed</option>
					</select></td>
					<td><select name="malwareScanStatus">
							<option value="${rows.sessionStatus}" selected disabled hidden >${rows.malwareScanStatus}</option>
							<option value="success">success</option>
							<option value="failed">failed</option>
					</select></td>
					<td><input type="submit" name="update"
						value="Update ${rows.sessionId}" id="${rows.sessionId}" /></td>
					<td><input type="submit" name="delete"
						value="Delete ${rows.sessionId}" id="${rows.sessionId}" /></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>