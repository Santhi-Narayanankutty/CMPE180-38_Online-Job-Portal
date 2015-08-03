<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
	String table = (String) request.getAttribute("table");
   	String table1 = (String) request.getAttribute("table1");
   	String Hidden_ID = (String) request.getAttribute("Hidden_ID");
    
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name=skillqual action=skill_qual method=get>
		<h1>Jobs that Matches your Profile</h1>
		<%=table%>
		<%=table1%>
		<input type="hidden" name= Hidden_ID  value=<%=Hidden_ID %>>
		<p>
			<input type=submit name=submit value ='Update' />
			
		</p>
</body>
</html>