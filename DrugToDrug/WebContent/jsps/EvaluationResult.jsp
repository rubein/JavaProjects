<%@page import="com.drugTodrug.pojo.Output"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Drug Evaluation</title>
</head>

<body>

	<TABLE>
		<%@ page import="com.drugTodrug.pojo.Output"%>
		<%@ page import="com.drugTodrug.pojo.Output"%>
		<%@page import="java.util.List"%>


		<%
			for (int row = 1; row <= 5; row++) {
		%>
		<TR>
		</TR>
		<%
			}
		%>
	</TABLE>

	<TABLE border="2" cellpadding="10" bordercolor="black">
		<thead>
			<th>Drug 1</th>
			<th>Relation 1</th>
			<th>Drug 2</th>
			<th>Relation 2</th>
			<th>Enzyme</th>
			<th>DDI Score</th>
		</thead>
		<TR>
		
			<%
				List<String> content = Output.getContent();
				List<Float> ddi = Output.getDdiValues();			
				int pointer = 0;
			%>
			
			<% if(content.size() == 0){
			%>
			 			<td>No Interaction</td> 
						<td>No Interaction</td>
						<td>No Interaction</td>
						<td>No Interaction</td>
						<td>No Interaction</td>
						<td>No Interaction</td>
			<%} %>

			<%
				for (int i = 0; i < content.size() / 5; i++) {
			%>
		
		<tr>
			<%
				for (int j = 0; j < 5; j++) {
			%>
			<td><%=content.get(pointer)%></td>
			<%
				pointer = pointer + 1;
					}
				
			//	for(int k =0; k< ddi.size();k++){
					%>
					<td><%=ddi.get(i)%></td>
				<% 		
			//	}
				
			%>
		</tr>
		<%
		//	Output.content.clear();
		//	Output.ddiValues.clear();
				}
		%>

	</TABLE>
</body>
</html>