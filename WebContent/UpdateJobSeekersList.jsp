<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page import = "java.sql.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JobSeeker Update page</title>
</head>
<body>
<form action="UpdateJobSeekerList" method ="get">
<table border ="1" style="width:750px"> 
			<tr>
 				<th>JobSeeker ID</th>
  				<th>Email Address</th> 
 				<th>Password</th>  
 				<th>Security Question</th> 
  				<th>Security Answer</th>
  				<th>Account Type</th>
			</tr>
			
			<tr>
			<%ResultSet res = (ResultSet) request.getAttribute("JobSeekerData");%>
			<%if(res.next()){
				%>
				<td><%out.println(res.getString("JobSeeker_Id"));%></td>  
				<td><input type ="text" name = "email" value = "<%=res.getString("email")%>"></td>
				<td><input type ="text" name = "pass_word" value = <%=res.getString("pass_word")%>></td>
				<td><input type ="text" name = "Security_Question" value = <%=res.getString("Security_Question")%>></td>
				<td><input type ="text" name = "Security_Answer" value = <%=res.getString("Security_Answer")%>></td>
				<td><input type ="text" name = "Account_Type" value = <%=res.getString("Account_Type")%>></td>
				<td><input type=hidden  name=JS_id value=<%=res.getString("JobSeeker_Id")%>><input type="submit" value="Update"></td>  
				</tr>	
			<%} %>
</table>	
</form>		
</body>
</html>