<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page import = "java.sql.*"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JS Skills</title>
</head>
<body>
<h3>JobSeeker Skills</h3>
<table border ="1" style="width:450px" >
<tr>
  <th>JobSeeker ID</th>
  <th>Skills</th>
  <th>Years of Experience</th>
</tr>
<%ResultSet res = (ResultSet) request.getAttribute("JobSeekerSkills");%>
			<%while(res.next()){
			%>
			<td><%out.println(res.getString("JS_ID"));%></td>
			<td><%out.println(res.getString("JS_Skills"));%></td>
			<td><%out.println(res.getString("JS_Experience"));%></td>
			<td><form action="DeleteJSSkills" method="GET"><input type=hidden name = Skill value=<%=res.getString("JS_Skills")%>><input type=hidden name = JS_ID value=<%=res.getString("JS_ID")%>><input type=submit value=Delete></form></td>
		</tr>
	<%} %>
</table>
</body>
<br/>
<a href="Admin_Homepage.jsp">Home</a>
<a href="Logout">Log Out</a>
</html>