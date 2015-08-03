<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
<%
Connection con= null;
PreparedStatement ps = null;
ResultSet rs = null;

String driverName = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/test";
String user = "root";
String password = "root";

String sql = "select UserType from user_info";

try {
Class.forName(driverName);
con = DriverManager.getConnection(url, user, password);
ps = con.prepareStatement(sql);
rs = ps.executeQuery(); 
%>
<form method="post" action="1.jsp">
<left><h2 style="color:black">Sign In</h2></left>
<table border="1" align="left">
<tr>
<td>Enter Your Email :</td>
<td><input type="text" name="user_email"/></td>
</tr>
<tr>
<td>Enter Your Password :</td>
<td><input type="password" name="user_password"/></td>
</tr>
<tr>
<td>Select UserType</td>
<td><select name="UserType">
<option value="select">select</option>
<%
while(rs.next())
{
String UserType = rs.getString("UserType");
%>
<option value=<%=UserType%>><%=UserType%></option>
<% 
}
}
catch(SQLException sqe)
{
out.println("home"+sqe);
}
%>
</select>
</td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="submit"/></td>
</table>
</form>
<div>
<left><h2 style="color:black">New User? Register</h2></left>
<table border="1" align="left">
	</div>
		<br><a href="/SJSUDBProject/register.jsp"><input type="button" name="Employer" value="Employer"></a><br>
		<br><a href="/SJSUDBProject/jobseekerregister.jsp"><input type="button" name="JobSeeker" value="Job Seeker"><br></a></right>
</body>
</html>