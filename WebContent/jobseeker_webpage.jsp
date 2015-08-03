<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String table = (String) request.getAttribute("table");
String Hidden_ID = (String) request.getAttribute("Hidden_ID");
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JobWebsite_jobseeker</title>
</head>
<body>
	<form name=js action=jsweb method=get>
		<h1>Jobs that Matches your Profile</h1>
		<%=table%>
		<p>
		<input type="hidden" name= Hidden_ID  value=<%=Hidden_ID %>>
			<input type=submit name=submit value ='Apply_for_Jobs' />
		</p>
		</form>
		<form action = "Edit_Profile" >
			<input type="hidden" name= Hidden_ID  value=<%=Hidden_ID %>>
			<input type=submit name=submit value ='Create Profile' />
			</form>
		<form action = "Rate" >
			<input type="hidden" name= Hidden_ID  value=<%=Hidden_ID %>>
			<input type=submit name=submit value ='Rate' />
			</form>
			<form action = "Edit1" >
			<input type="hidden" name= Hidden_ID  value=<%=Hidden_ID %>>
			<input type=submit name=submit value ='Edit_Profile' />
			</form>	
	
</body>

</html>