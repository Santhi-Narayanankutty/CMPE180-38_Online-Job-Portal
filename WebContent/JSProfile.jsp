<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page import = "java.sql.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JobSeeker Profile Page</title>
</head>
<body>
<h2>JobSeeker Profile</h2>

<table border ="1" style="width:750px"> 
			<tr>
 				<th>JobSeeker Id</th>
 				<th>First Name</th>
  				<th>Middle Initial</th>
  				<th>Last Name</th>
  				<th>Date_Of_Birth</th> 
 				<th>City</th>  
 				<th>State</th> 
  				<th>Country</th>
  				<th>Zipcode</th>
  				<th>Cell Phone</th>  
 				<th>Home Phone</th> 
  				<th>Work Phone</th>
  				<th>Resume</th>
  				<th>Salary</th>
  				<th>Desired Position</th> 
  				<th>Willing to relocate</th>
			</tr>
				
			
			<tr>
			<%ResultSet res = (ResultSet) request.getAttribute("JobSeekerData");%>
			<%if(res.next()){
				%>
				<td><%out.println(res.getString("ID"));%></td>
				<td><%out.println(res.getString("fName"));%></td>
				<td><%out.println(res.getString("mInit"));%></td>
				<td><%out.println(res.getString("lName"));%></td>
				<td><%out.println(res.getString("Date_Of_Birth"));%></td>
				<td><%out.println(res.getString("city"));%></td>
				<td><%out.println(res.getString("state"));%></td>
				<td><%out.println(res.getString("Country"));%></td>
				<td><%out.println(res.getString("zipcode"));%></td>
				<td><%out.println(res.getString("Phone_cell"));%></td>
				<td><%out.println(res.getString("Phone_Home"));%></td>
				<td><%out.println(res.getString("Phone_Work"));%></td>
				<td><%out.println(res.getString("My_Resume"));%></td>
				<td><%out.println(res.getString("Salary"));%></td>
				<td><%out.println(res.getString("Desired_Position"));%></td>
				<td><%out.println(res.getString("Willing_to_Relocate"));%></td>
				<td><form action="EditJSProfileServlet" method="GET"><input type=hidden name = JS_ID value=<%=res.getString("ID")%>><input type=submit value=Edit></form></td>
				<td><form action="DeleteJobSeekerProfile" method="GET"><input type="hidden" name=JS_ID value=<%=res.getString("ID")%>><input type=submit value=Delete></form></td>
				</tr>	
				<tr><form action="JSSkillsServlet" method="GET"><input type=hidden name = JS_ID value=<%=res.getString("ID")%>><input type=submit value=Skills></form></tr>
				<br/>
				<br/>
				<tr><form action="JSQualificationServlet" method="GET"><input type=hidden name = JS_ID value=<%=res.getString("ID")%>><input type=submit value=Qualifications></form></tr>
				<br/>
				<br/>
				<tr><form action="JobsAppliedServlet" method="GET"><input type=hidden name = JS_ID value=<%=res.getString("ID")%>><input type=submit value="Jobs Applied by the Job Seeker"></form></tr>
				<br/>
				<br/>
			<%} %>
			</table>

<br/>

<br/>

<a href="Admin_Homepage.jsp">Home</a>
<a href="Logout">Log Out</a>
</body>
</html>