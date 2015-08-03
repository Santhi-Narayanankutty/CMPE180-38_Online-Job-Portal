
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<%! String userdbEmail;
String userdbPsw;
String dbUsertype;

%>
<%
Connection con= null;
PreparedStatement ps = null;
ResultSet rs = null;

String driverName = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/test";
String user = "root";
String dbpsw = "root";

String sql = "select * from user_info where user_email=? and user_password=? and UserType=?";

String user_email = request.getParameter("user_email");
String user_password = request.getParameter("user_password");
String UserType = request.getParameter("UserType");
if((!(user_email.equals(null) || user_email.equals("")) && !(user_password.equals(null) || 
user_password.equals(""))) && !UserType.equals("select"))
{
try{
Class.forName(driverName);
con = DriverManager.getConnection(url, user, dbpsw);
ps = con.prepareStatement(sql);
ps.setString(1, user_email);
ps.setString(2, user_password);
ps.setString(3, UserType);
rs = ps.executeQuery();
if(rs.next())
{ 
userdbEmail = rs.getString("user_email");
userdbPsw = rs.getString("user_password");
dbUsertype = rs.getString("UserType");
if(user_email.equals(userdbEmail) && user_password.equals(userdbPsw) && UserType.equals(dbUsertype))
{
session.setAttribute("user_email",userdbEmail);
session.setAttribute("UserType", dbUsertype); 
System.out.println("user type" + dbUsertype);
if(dbUsertype.equalsIgnoreCase("Employer")) {
	response.sendRedirect("index.jsp");
	}
	else if(dbUsertype.equalsIgnoreCase("jobseeker")) {
		response.sendRedirect("login1.jsp");}
		/*if (dbUsertype == "Employer" ){
response.sendRedirect("welcome.jsp");
}else if (dbUsertype == "JobSeeker" ){
response.sendRedirect("jobseeker_webpage.jsp");
}*/
else if (dbUsertype.equalsIgnoreCase("admin")){
response.sendRedirect("Admin_Homepage.jsp"); }}
}
else
response.sendRedirect("error.jsp");
rs.close();
ps.close(); 
}
catch(SQLException sqe)
{
out.println(sqe);
} 
}
else
{
%>
<center><p style="color:red">Error In Login</p></center>
<% 
getServletContext().getRequestDispatcher("login.jsp").include(request, response);
}
%>
<input type=hidden name= Hidden_ID  value=user_email>
</body>
</html>