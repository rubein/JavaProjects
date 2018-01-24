<!DOCTYPE html>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script> 


$(document).ready(function(){
	  $("#removeRoute").click(function(){
	    $("#removeRouteDetails").slideToggle("slow");
	  });
	});
</script>
 
<style type="text/css"> 

#removeRouteDetails,#removeRoute
{
padding:5px;
text-align:center;
background-color:#e5eecc;
border:solid 1px #c3c3c3;
}
#removeRouteDetails
{
padding:10px;
display:none;
}
</style>

</head>
<body>

<form action="removeRoute.do" method="post"></form>
<a href=> To remove route click here </a>


 <!-- <form action="AfterAuthentication.jsp">
 <div id="removeRoute">removeRoute details MAKE CHANGES</div>
 <div id="removeRouteDetails" align="center">  
           <table>
	     <tr>
	     		<td> Bus Number</td>
	     		<td> <input type="text" name="bus number" ></td>
	     </tr>
	     <tr>
	     		<td>Source</td>
	     		<td> <input type="text" name="Source" >  </td></tr>
	     <tr>
			    <td>destiontion</td>
	     		<td><input type="text" name="destination" ></td></tr>
	     <tr>
	            <td>add urs</td>
	     		<td><input type="text" name="" ></td>
	     </tr>
	     <tr>
	            <td>add urs</td>
	     		<td><input type="text" name="" ></td>
	     </tr>
	
       </table>
    <input type="submit" name="add bus" >  
 </div>
 
 
 </form> -->
</body>
</html>
