<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
	Integer ID = (Integer) request.getAttribute("ID");
	String fname = (String) request.getAttribute("fname");
	String lname = (String) request.getAttribute("lname");
	String mname = (String) request.getAttribute("mname");
	String dob = (String) request.getAttribute("dob");
	String city = (String) request.getAttribute("city");
	String state = (String) request.getAttribute("state");
	String zipcode = (String) request.getAttribute("zipcode");
	String phone_cell = (String) request.getAttribute("phone_cell");
	Integer phone_work = (Integer) request.getAttribute("phone_work");
	Integer phone_home = (Integer) request.getAttribute("phone_home");
	Integer Salary = (Integer) request.getAttribute("salary");
	String country = (String) request.getAttribute("country");
	String My_resume = (String) request.getAttribute("My_resume");
	String Relocate = (String) request.getAttribute("Relocate");
	String Desired_Position = (String) request.getAttribute("Desired_Position");
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<title>Edit profile</title>

<form name=Edit1_profile action="update1" method=get>
   ID:<input type = text name = ID value = "<%=ID %>"><br>
   first name:<input type = text name = fname value = "<%=fname %>"><br>
   last name:<input type = text name = lname value = "<%=lname %>" ><br>
   middle name:<input type = text name = mname value = "<%=mname %>"><br>
   date of birth:<input type = text name = dob value = "<%=dob %>"><br>
   city:<input type = text name = city value = "<%=city %>"><br>
   state:<input type = text name = state value = "<%=state %>"><br>
   zipcode:<input type = text name = zipcode value = "<%=zipcode %>" ><br>
   country:<input type = text name = country value = "<%=country %>"><br>
   Phone cell:<input type = text name = phone_cell value = "<%=phone_cell %>" ><br>
   Phone Home:<input type = text name = phone_home value = "<%=phone_home %>" ><br>
   Phone Work:<input type = text name = phone_work value = "<%=phone_work %>" ><br>
   Resume:<input type = text name = My_resume value = "<%=My_resume %>" ><br>
   Salary:<input type = text name = Salary  value = "<%=Salary %>"><br>
   Desired Position:<input type = text name = Desired_Position value = "<%=Desired_Position %>" ><br>
   Willing to Relocate:<input type = text name = Relocate value = "<%=Relocate %>" ><br>
  <input type=submit name=submit value ='Update' />    
    </form>
</body>
</html>