<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page import = "java.sql.*"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jobs Applied</title>
</head>
<body>
<h3>Jobs Applied by the Job Seeker</h3>

<table border ="1" style="width:650px">
<tr>
  <th>JobSeeker ID</th>
  <th>Job ID</th>
  <th>Job Title</th>
  <th>Company</th>
</tr>
<%ResultSet res = (ResultSet) request.getAttribute("JSAppliedJobs");%>
<%
	while(res.next()){%>
		<tr>
			<td><%out.println(res.getString("Job_Applied.JobSeeker_ID"));%></td>
			<td><%out.println(res.getString("Job_Applied.job_Id"));%></td>
			<td><%out.println(res.getString("Job_Post.job_Title"));%></td>
			<td><%out.println(res.getString("Job_Post.company_Name"));%></td>
			<td><form action="deleteJSAppliedJobs" method="GET"><input type=hidden name = Job_ID value=<%=res.getString("Job_Applied.job_Id")%>><input type=hidden name = JS_ID value=<%=res.getString("Job_Applied.JobSeeker_ID")%>><input type=submit value=Delete></form></td>
		</tr>
	<%}	
%>

</table>	

<br/>


<a href="Admin_Homepage.jsp">Home</a>
<a href="Logout">Log Out</a>

</body>
</html>