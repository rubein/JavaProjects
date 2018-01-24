<!DOCTYPE html>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script> 


$(document).ready(function(){
	  $("#addBus").click(function(){
	    $("#addBusDetails").slideToggle("slow");
	  });
	});
</script>
 
<style> 
#addBusDetails,#addBus
{
padding:5px;
text-align:center;
background-color:#e5eecc;
border:solid 1px #c3c3c3;
}
#addBusDetails
{
padding:50px;
display:none;
}
</style>
</head>
<body>
  <form action="addBus.do" method="post">
 <div id="addBus">Add bus details</div>
 <div id="addBusDetails" align="center">

        <table>
	     <tr>
	     		<td> Bus Number</td>
	     		<td> <input type="text" name="bus_number" ></td>
	     </tr>
	     <tr>
	     		<td>Status</td>
	     		<td> <select name="Status">
	     			<option>Available</option>
	     			<option>UnAvailable</option>
	     		</select>  </td>     
	     
	     <tr>
	         <!--    <td>Ac/NonAc</td>
	     		<td><input type="text" name="typeOfBus" ></td> -->
	     		
	     		 <td>Ac/NonAc</td>
	     		<td><select name="typeOfBus">
	     		
	     			<option>AC</option>
	     			<option>Non-AC</option>
	     		
	     		</select></td>
	     		
	     </tr>
       </table>
    <input type="submit" name="add_Bus" value="SubmitBus">  
 </div>
 
 
 </form>
</body>
</html>
