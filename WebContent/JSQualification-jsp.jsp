<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import = "java.sql.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JS Qualification</title>
</head>
<body>

<h2>Job Seeker Qualifications</h2>
<table border ="1" style="width:450px">
<tr>
  <th>JobSeeker ID</th>
  <th>Qualifications</th>
</tr>
<%ResultSet res = (ResultSet) request.getAttribute("JobSeekerQuali");%>

<%
	while(res.next()){%>
		<tr>
			<td><%out.println(res.getString(1));%></td>
			<td><%out.println(res.getString(2));%></td>
			<td><form action="DeleteJSQualification" method="GET"><input type="hidden" name=JS_ID value=<%=res.getString(1)%>><input type="hidden" name=JS_Quali value=<%=res.getString(2)%>><input type=submit value=Delete></form></td>
		</tr>
	<%}	
%>
</table>

<br/>

<a href="Admin_Homepage.jsp">Home</a>
<a href="Logout">Log Out</a>

</body>
</html>