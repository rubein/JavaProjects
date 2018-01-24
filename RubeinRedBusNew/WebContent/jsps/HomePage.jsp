<!DOCTYPE html>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script> 
$(document).ready(function(){
  $("#flip").click(function(){
    $("#panel").slideToggle("slow");
  });
});
</script>
 
<style> 
#panel,#flip,#redBus
{
padding:5px;
text-align:center;
background-color:#e5eecc;
border:solid 1px #c3c3c3;
}
#panel
{
padding:20px;
display:none;
}
</style>
</head>
<body>
 <jsp:include page = "logo.jsp"></jsp:include>
<div id="flip">login</div>
<div id="panel">
               <form action="authentication.do" method="post">
                     <table>
				     
					     <tr>
					         <td>UserName</td>
					         <td> <input type="email" name="email"></td>				         
					     </tr>
					     
					     <tr>
					         <td>Password</td>	
					         <td><input type="password" name="password"></td>			         
					     </tr>
					     
					     <tr>
					         <td>   <input type="submit" value="Login"></td>  
					     </tr>
				
				     </table>
				</form>
</div>
<br>
<br>
               
<a href="/RubeinRedBusNew/jsps/RegisterPage.jsp">Sign up</a>
 
</body>
</html>
