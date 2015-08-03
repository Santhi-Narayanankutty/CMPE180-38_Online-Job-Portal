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

<form action="UpdateEmployerList" method ="get">
<table border ="1" style="width:750px"> 
			<tr>
 				<th>Employer ID</th>
  				<th>Employee Name</th> 
 				<th>Email Address</th> 
 				<th>Password</th> 
 				<th>Security Question</th> 
  				<th>Security Answer</th>
  				<th>Number of Openings</th>
  				<th>Account Type</th>
			</tr>
			
			<tr>
			<%ResultSet res = (ResultSet) request.getAttribute("JobSeekerData");%>
			<%if(res.next()){
				%>
				
				<td><%out.println(res.getString("Employer_ID"));%></td>  
				<td><input type ="text" name = "eName" value = "<%=res.getString("eName")%>"></td>
				<td><input type ="text" name = "e_email" value = <%=res.getString("e_email")%>></td>
				<td><input type ="text" name = "e_password" value = "<%=res.getString("e_password")%>"></td>
				<td><input type ="text" name = "Security_Question" value = <%=res.getString("Security_Question")%>></td>
				<td><input type ="text" name = "Security_Answer" value = <%=res.getString("Security_Answer")%>></td>
				<td><input type ="text" name = "Number_of_openings" value = <%=res.getString("Number_of_openings")%>></td>
				<td><input type ="text" name = "Account_Type" value = <%=res.getString("Account_Type")%>></td>
				<td><input type=hidden  name=Emp_id value=<%=res.getString("Employer_ID")%>><input type="submit" value="Update"></td>  
				</tr>	
			<%} %>
</table>	
</form>		
</body>
</html>