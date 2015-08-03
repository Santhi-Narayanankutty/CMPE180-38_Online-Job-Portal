<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Job Seekers applied for the job</title>
</head>

<body>

<h2>Job Skills</h2>
<table border ="1" style="width:450px" >
<tr>
  <th>Skills</th>
  <th>Years of Experience</th>
</tr>
<%
try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Online_Job_Portal", "root", "root123");
	System.out.println("got Connection");
	Statement stmt = con.createStatement();
	String sql = "select job_Skills, experience from job_Skills WHERE Id =10015 ";
	ResultSet rs = stmt.executeQuery(sql);
	while(rs.next()){%>
		<tr>
			<td><%out.println(rs.getString(1));%></td>
			<td><%out.println(rs.getString(2));%></td>
			<td><a href ="DeleteJobSkills">Delete</a></td>
		</tr>		
	<%}
	rs.close();
	stmt.close();
	con.close();
}catch(ClassNotFoundException e1){
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

<h2>List of all Job seekers applied for the job</h2>
<table border ="1" style="width:750px">
<tr>
  <th>JobSeeker ID</th>
  <th>Email Address</th> 
</tr>
<%
try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Online_Job_Portal", "root", "root123");
	System.out.println("got Connection");
	Statement stmt = con.createStatement();
	String sql = "select Job_Applied.JobSeeker_ID, Job_Seeker_SignUp.email from Job_Seeker_SignUp, Job_Applied WHERE Job_Applied.JobSeeker_ID = Job_Seeker_SignUp.JobSeeker_ID AND Job_ID =10015";
	ResultSet rs = stmt.executeQuery(sql);
	while(rs.next()){%>
		<tr>
			<td><%out.println(rs.getString(1));%></td>
			<td><%out.println(rs.getString(2));%></td>
			<td><a href = "DeleteJobsApplied">Delete</a></td>
		</tr>		
	<%}
	rs.close();
	stmt.close();
	con.close();
}catch(ClassNotFoundException e1){
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

<a href="EditEmployerList">Go Back</a>
<br/>
<a href="Admin_Homepage.jsp">Home</a>
<a href="Logout.jsp">Log Out</a>
</body>
</html>