<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Again</title>
</head>
<body>

	<%@ page import="com.myrnaMethod.servlets.UploadExcelFile"%>

	<script type="text/javascript">
	foo();
    function foo() {
        var value = "<%=UploadExcelFile.filename%>";
		}

		var r = confirm("Data Added. Would you like to add more data?");
		if (r == true) {
			console.log("true");
			window.location.href = "/MyrnaMethod/jsps/AfterAuthentication.jsp";
		} else {
			console.log("false");
			window.location.href = "/MyrnaMethod/";
		}
		document.getElementById("demo").innerHTML = txt;
	
	</script>
</body>
</html>
