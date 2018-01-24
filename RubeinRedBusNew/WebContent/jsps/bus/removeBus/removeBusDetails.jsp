<!DOCTYPE html>
<%@ page import="pojos.R_BusDetails"%>
<%@ page import="java.util.*"%>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script> 
$(document).ready(function(){
	  $("#removeBus").click(function(){
	    $("#removeBusDetails").slideToggle("slow");
	  });
	});
</script>
<style> 
#removeBusDetails,#removeBus
{
padding:5px;
text-align:center;
background-color:#e5eecc;
border:solid 1px #c3c3c3;
}

#removeBusDetails
{
padding:20px;
display:none;
}
</style>
</head>
<body>
 <form action="removeBus1.do" method="post">
 <div id="removeBus">Remove Bus</div>
 <div id="removeBusDetails" align="center">  
           <table>
	     <tr>
	     		<td> Select Bus Number</td>
	     		<td> <select name="busNumber">
	     		<%
					ArrayList<R_BusDetails> list =(ArrayList<R_BusDetails>) request.getAttribute("busNo");
					for (R_BusDetails l : list) {
 				%>
					<option value="<%=l.getBusNo() %>">
					<%=l.getBusNo()%></option>
					<%
				}
				%>	
	     	</select></td>
 	     </tr>
	     </table>
    <input type="submit" name="remove_bus" value="RemoveBus" >
 </div>
 </form> 
</body>
</html>
