<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Vote for Your Fav Game</title>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script>
	src = "js/jquery.validate.js" >
</script>

</head>

<body>
	<h1>Start Voting now</h1>
	<form name="voteAction" action="validateUser.do" method="post">
		<h1>What is the best video game of all time?</h1>

		<div id="options" required>
			<input type="radio" id="option1" name="bestGame" value="Overwatch">
			Overwatch <br> <input type="radio" id="option2" name="bestGame"
				value="warcraft"> World of Warcraft <br> <input
				type="radio" id="option3" name="bestGame" value="PUBG"> PUBG
			<br> <input type="radio" id="option4" name="bestGame"
				value="legends"> League of Legends <br>
		</div>

		<input type="email" id="emailId" name="emailId" required> <input
			type="submit" id="submit" name="submit" value="Vote">

		<table>
			<tr>
				<td>OverWatch</td>
				<td><%=request.getAttribute("Overwatch")%></td>

			</tr>

			<tr>
				<td>World of Warcraft</td>
				<td><%=request.getAttribute("Warcraft")%></td>
			</tr>

			<tr>
				<td>PUBG</td>
				<td><%=request.getAttribute("PUBG")%></td>
			</tr>

			<tr>
				<td>League of Legends</td>
				<td><%=request.getAttribute("Legends")%></td>
			</tr>
		</table>
	</form>

	<script type="text/javascript">
		$("#voteAction").validate();
	</script>


</body>
</html>