<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page import = "java.sql.*"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Webpage</title>
</head>
<body>

<div id = "mainContainer">
	<div id = "header">
	<h1>Jobs posted by Employer</h1>
	</div>
</div>
<table border ="1" style="width:750px" >
<tr>
  <th>Select</th>
  <th>Job ID</th>
  <th>Title</th> 
  <th>Description</th>
  <th>Company</th>
  <th>Location</th> 
  <th>Date Posted</th>
  <th>Salary</th>
  <th>Contact Person</th> 
  <th>Cell Phone</th>
</tr>

<%
try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Online_Job_Portal", "root", "root123");
	System.out.println("got Connection");
	Statement stmt = con.createStatement();
	String sql = "select job_ID, job_Title, job_description, company_Name, job_location, Date_Posted, job_salary, contact_Person, Phone_Number from Job_Post WHERE Employer_ID=4;;";
	ResultSet rs = stmt.executeQuery(sql);
	while(rs.next()){%>
		<tr>
			<td><INPUT TYPE="checkbox" NAME="Edit" VALUE="0"></td>
			<td><a href="JobSeekersJob.jsp"><%out.println(rs.getString("job_ID"));%></a></td>
			<td><%out.println(rs.getString("job_Title"));%></td>
			<td><%out.println(rs.getString("job_description"));%></td>
			<td><%out.println(rs.getString("company_Name"));%></td>
			<td><%out.println(rs.getString("job_location"));%></td>
			<td><%out.println(rs.getString("Date_Posted"));%></td>
			<td><%out.println(rs.getString("job_salary"));%></td>
			<td><%out.println(rs.getString("contact_Person"));%></td>
			<td><%out.println(rs.getString("Phone_Number"));%></td>
		</tr>
	<%}
	rs.close();
	stmt.close();
	con.close();
}catch (ClassNotFoundException e1){
	System.out.println(e1.toString());
}

catch(SQLException e2){
	System.out.println(e2.toString());
	
}
catch(Exception e3){
	System.out.println(e3.toString());
}	
%>
</table>

<br/>
<a href="#">Edit</a> 
<a href="#">Delete</a>
<br/>
<a href="index.jsp">Home</a>
<a href="Logout.jsp">Log Out</a>
</body>
</html>