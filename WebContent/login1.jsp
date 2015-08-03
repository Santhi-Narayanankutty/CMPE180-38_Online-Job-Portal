<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% 
String user_name = (String) request.getAttribute("user_email");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Job Website</title>
</head>
<body>
  <form action="jobseeker">   
<h1>Welcome user</h1>
<input type="hidden" name= Hidden_ID  value= <%=user_name %>>
<input type="submit" value="Submit" />
</form>

</body>
</html>