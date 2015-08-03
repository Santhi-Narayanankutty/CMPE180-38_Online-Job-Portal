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

<form action="UpdateJSProfileServlet" method ="get">
<table border ="1" style="width:750px"> 
			<tr>
 				<th>JobSeeker ID</th>
  				<th>First Name</th> 
 				<th>Last Name</th>  
 				<th>Middle Initial</th> 
  				<th>DOB</th>
  				<th>city</th>
  				<th>State ID</th>
  				<th>ZipCode</th> 
 				<th>Country</th>  
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
				<td><input type ="text" name = "fName" value = "<%=res.getString("fName")%>"></td>
				<td><input type ="text" name = "lName" value = <%=res.getString("lName")%>></td>
				<td><input type ="text" name = "mInit" value = <%=res.getString("mInit")%>></td>
				<td><input type ="text" name = "Date_Of_Birth" value = <%=res.getString("Date_Of_Birth")%>></td>
				<td><input type ="text" name = "city" value = <%=res.getString("city")%>></td>
				<td><input type ="text" name = "state" value = <%=res.getString("state")%>></td>
				<td><input type ="text" name = "zipcode" value = <%=res.getString("zipcode")%>></td>
				<td><input type ="text" name = "Country" value = <%=res.getString("Country")%>></td>
				<td><input type ="text" name = "Phone_Cell" value = <%=res.getString("Phone_Cell")%>></td>
				<td><input type ="text" name = "Phone_Home" value = <%=res.getString("Phone_Home")%>></td>
				<td><input type ="text" name = "Phone_Work" value = <%=res.getString("Phone_Work")%>></td>
				<td><input type ="text" name = "My_Resume" value = <%=res.getString("My_Resume")%>></td>
				<td><input type ="text" name = "Salary" value = <%=res.getString("Salary")%>></td>
				<td><input type ="text" name = "Desired_Position" value = <%=res.getString("Desired_Position")%>></td>
				<td><input type ="text" name = "Willing_to_Relocate" value = <%=res.getString("Willing_to_Relocate")%>></td>
				<td><input type=hidden  name=JS_id value=<%=res.getString("ID")%>><input type="submit" value="Update"></td>  
				</tr>	
			<%} %>
</table>	
</form>		
</body>
</html>