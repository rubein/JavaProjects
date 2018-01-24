<!DOCTYPE html>
<%@page import="java.util.LinkedHashSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pojos.R_Stops"%>
<%@ page import="java.util.*"%>
<html>
<head>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script> 

$(document).ready(function(){
	  $("#addRoute").click(function(){
	    $("#addRouteDetails").slideToggle("slow");
	  });
	});
</script>
 
<style> 
#addRouteDetails,#addRoute
{
padding:5px;
text-align:center;
background-color:#e5eecc;
border:solid 1px #c3c3c3;
}

</style>
</head>
<body>

 <form action="addRouteToDatabase.do" method="post">
 <div id="addRoute">Add Route details</div>
 <div id="addRouteDetails" align="center">  
    <table align="center">
		<tr>
			<td>
				<label>Enter the Src Path:</label>
			</td>
			<td>
		<select id="source" name="srcc" onchange="validate()" >
		
		<option value="" selected="selected"></option>

			<%	List listOfIds =new ArrayList();  
				System.out.println(session.getAttribute("Stop"));
				String end=(String)session.getAttribute("Stop");
				if(end==null){
				ArrayList<R_Stops> list = (ArrayList<R_Stops>) request.getAttribute("List");
				
				for (R_Stops l : list) {
			%>
			<option value="<%=l.getName()%>">
				<%=l.getName()%></option>
			<%
				}
				}
			else{
				%>
					<option value="<%=end %>">
					<%=end %></option>
					<%
				}
			%>
			

		
		</select><br>
		</td>
		
		
		<tr><td>
		 <label>Enter the Destination Path: </label> </td>
		 <td>
		 <select id="destination" name="destt"  onchange="validate()">
		<option value="" selected="selected"></option>
			<%
				ArrayList<R_Stops> list = (ArrayList<R_Stops>) request.getAttribute("List");
				for (R_Stops l : list) {
			%>
			
			<option value="<%=l.getName()%>">
				<%=l.getName()%></option>


			<%
				}
			%>
		</select> <br>
		</td>
		<tr> <td>
				<button type="submit" name="submits" value="submit" class="button">Add more</button>
		     </td>
		 <td>
			<button type="submit" name="submits" value="confirm" class="button">Done!!!</button>
		</td>
	</table>
    <input type="submit" name="addRoute" >  
 </div>
 </form>
</body>
</html>
