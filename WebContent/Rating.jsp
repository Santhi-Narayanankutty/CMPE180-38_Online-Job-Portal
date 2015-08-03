<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
	String table = (String) request.getAttribute("table");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jobs that you applied</title>
</head>
<body>
<form name=rate action=rater method=get>
		<h1>Jobs that you applied</h1>
		<%=table%>
		

	</form>
</body>
</html>