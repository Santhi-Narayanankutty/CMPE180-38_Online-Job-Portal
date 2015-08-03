<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List"%>
<%@ page import = "java.util.Iterator"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JobSeekers List page</title>
</head>
<body>

<h2>List of all JobSeekers</h2>
<form action="JobSeekerProfile" method="GET">
<table border ="1" style="width:750px"> 
			<tr>
				
 				<th>JobSeeker ID</th>
  				<th>Email Address</th> 
 				<th>Password</th>  
 				<th>Security Question</th> 
  				<th>Security Answer</th>
  				<th>Account Type</th>
			</tr>
			
			<%Iterator<String> itr; %>
			<%List<String> data = (List<String>) request.getAttribute("JobSeekerData");
			
				for(itr = data.iterator(); itr.hasNext();){
					%>
					<tr>
					<% String s = (String) itr.next(); %>
				
					<td><input type=submit  name=JS_id value=<%=s%>></td>  
					<td><%=itr.next() %></td>
					<td><%=itr.next() %></td>
					<td><%=itr.next() %></td>
					<td><%=itr.next() %></td>
					<td><%=itr.next() %></td>
					<td><form action="EditJobSeekerList" method="get"><input type=hidden name=JS_ID value=<%=s%>><input type = submit value = Edit></form></td>
					<td><form action="DeleteJobSeekerList" method="get"><input type=hidden name=JS_ID value=<%=s%>><input type = submit value = Delete></form></td>
			<%}%>
				</tr>			
</table>
</form>

<a href="Admin_Homepage.jsp">Home</a>
<a href="Logout">Log Out</a>

</body>
</html>



