<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%	String Hidden_ID = (String) request.getAttribute("Hidden_ID");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Profile</title>
</head>
<body>
<form name=profile action=profile method=get>
    first name:<input type = text name = fname value = "" /><br>
    last name:<input type = text name = lname value = "" /><br>
    middle name:<input type = text name = mname value = "" /><br>
    Date of Birth:<input type = text name = dob value = "" /><br> 
    street name:<input type = text name = street value = ""/><br>
	city:<input type = text name = city value = "" /><br>
	country:<input type = text name = country value = ""/><br>
	zip code:<input type = text name = zip value = ""/><br>
	Phone cell:<input type = text name = pcell value = ""/><br>
	Phone home:<input type = text name = phome value = "" /><br>
	Phone Office:<input type = text name = office value = ""/><br>   
    Resume:<input type = text name = resume value = ""/><br>
	salary expectation:<input type = text name = salary_exp value = "" /><br>
	Desired Position:<input type = text name = position value = "" /><br>
    willing to relocate:<input type = text name = relocate value = "" /><br>
    <input type="hidden" name= Hidden_ID  value=<%=Hidden_ID %>>
	
<p>
<input type = submit name = submit value = next> </p>
	</form>
</body>
</html>