<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List"%>
<%@ page import = "java.util.Iterator"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employers List page</title>
</head>
<body>

<h2>List of all Employers</h2>
<table border ="1" style="width:750px"> 
			<tr>
 				<th>Employer ID</th>
 				<th>Employer Name</th>
  				<th>Email Address</th> 
 				<th>Password</th>  
 				<th>Security Question</th> 
  				<th>Security Answer</th>
  				<th>Number of Job Openings</th>
  				<th>Account Type</th>
			</tr>

			<%Iterator<String> itr; %>
			<%List<String> data = (List<String>) request.getAttribute("EmployerData");
				for(itr = data.iterator(); itr.hasNext();){
					%>
					<tr>
					<% String s = (String) itr.next(); %>
					<td><form action="EditEmployerList" method="GET"><input type=submit  name=Emp_id value=<%=s%>></form></td> 
					<td><%=itr.next() %></td>
					<td><%=itr.next() %></td>
					<td><%=itr.next() %></td>
					<td><%=itr.next() %></td>
					<td><%=itr.next() %></td>
					<td><%=itr.next() %></td>
					<td><%=itr.next() %></td>
					<td><form action="EditEmpListServlet" method="get"><input type=hidden name=Emp_id value=<%=s%>><input type = submit value = Edit></form></td>
					<td><form action="DeleteEmployerList" method="get"><input type=hidden name=Emp_id value=<%=s%>><input type = submit value = Delete></form></td>
				<%}%>
				</tr>
</table>
<a href="Admin_Homepage.jsp">Home</a>
<a href="Logout">Log Out</a>
</body>
</html>



