<!DOCTYPE html>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script> 


$(document).ready(function(){
	  $("#addBusStop").click(function(){
	    $("#addBusStopDetails").slideToggle("slow");
	  });
	});
</script>
 
<style> 
#addBusStopDetails,#addBusStop
{
padding:5px;
text-align:center;
background-color:#e5eecc;
border:solid 1px #c3c3c3;
}
#addBusStopDetails
{
padding:50px;
display:none;
}
</style>
</head>
<body>



 <form action="AddStop.do" method="post">
 <div id="addBusStop">Add bus stop </div>
 <div id="addBusStopDetails" align="center">  
           <table>
	     <tr>
	     		<td> Bus Stop Name</td>
	     		<td> <input type="text" name="stop_name" ></td>
	     </tr>  
	      </table>
    <input type="submit" name="add_stop" value="SubmitStop" >  
 </div>
 </form> 
</body>
</html>