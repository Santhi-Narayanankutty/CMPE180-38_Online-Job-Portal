<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import = "java.util.List"%>
<%@ page import = "java.util.Iterator"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jobs Posted by employer</title>
</head>
<body>

<h2>List of all jobs posted by the employer</h2>

<table border ="1" style="width:750px"> 
			<tr>
 				<th>Employer ID</th>
 				<th>Job ID</th>
  				<th>Job Title</th> 
 				<th>Job Description</th>  
 				<th>Company</th> 
  				<th>Location</th>
  				<th>Date Posted</th>
  				<th>Salary</th>
  				<th>Contact Person</th>
  				<th>Phone Number</th> 
			</tr>
			
			<%Iterator<String> itr; %>
			<%List<String> data = (List<String>) request.getAttribute("FetchData");
				for(itr = data.iterator(); itr.hasNext();){
					%>
					<tr>
					<% String s = (String) itr.next(); %>
					<td><%=s%></td>
					<td><form action="JobSeekersJobServlet" method="get"><input type= Submit name=Job_id value=<%=itr.next()%>></form></td>
					<td><%=itr.next() %></td>
					<td><%=itr.next() %></td>
					<td><%=itr.next() %></td>
					<td><%=itr.next() %></td>
					<td><%=itr.next() %></td>
					<td><%=itr.next() %></td>
					<td><%=itr.next() %></td>
					<td><%=itr.next() %></td>
					<td><form action=DeleteJobs method="get"><input type = hidden name=Emp_id value=<%=s%>><input type = hidden name=Job_id value=10017><input type = "submit" value = "Delete"></form></td>
			<%}%>
				</tr>
</table>

<br/>

<a href="Admin_Homepage.jsp">Home</a>
<a href="Logout">Log Out</a>

</body>
</html>