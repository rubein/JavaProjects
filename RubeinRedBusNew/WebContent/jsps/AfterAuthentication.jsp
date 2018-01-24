<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AfterAuthentication</title>

<script> 


$(document).ready(function(){
	  $("#addBus").click(function(){
	    $("#addBusDetails").slideToggle("slow");
	  });
	});

function myFunction() {
    document.getElementById("demo").innerHTML = Date();
}
</script>

<style> 
#redBus,#addBusDetails,#addBus,#removeRoute,#removeBusDetails
{
padding:5px;
text-align:center;
background-color:#e5eecc;
border:solid 1px #c3c3c3;
}
#addBusDetails,#addRouteDetails
{
padding:20px;
display:none;
}
</style>

</head>
<body>

<jsp:include page = "logo.jsp"></jsp:include>
<p id="demo"></p>
<a href="/RubeinRedBusNew/jsps/bus/addBus/addBusDetails.jsp"> To add bus click here </a><br>
<a href="REMOVEBUS.do"> To remove bus click here </a><br>
<a href="routelist.do"> To add route click here </a><br>
<a href="/RubeinRedBusNew/jsps/bus/removeRoute/removeRouteDetails.jsp"> To remove route click here </a><br>
<a href="/RubeinRedBusNew/jsps/bus/addStop/addBusStop.jsp"> To add bus stop click here </a><br>
</body>
</html>