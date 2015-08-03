<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%	String Hidden_ID = (String) request.getAttribute("Hidden_ID");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>skills</title>
</head>
<body>
<h1> Skills and Experience</h1>
<form name=skills action=skills method=get>
<table><tr>
<td>
Skills</td>
<td>Experience</td>
<tr><td>
  <input type = text name = skill1 value = "" /></td>
  <td><input type = text name = exp1 value = "" /></td>
<tr><td>
  <input type = text name = skill2 value = "" /></td>
  <td><input type = text name = exp2 value = "" /></td>
<tr><td>
  <input type = text name = skill3 value = "" /></td>
  <td><input type = text name = exp3 value = "" /></td>
</table>
<input type="hidden" name= Hidden_ID  value=<%=Hidden_ID %>>
<p>
<input type = submit name = submit value = next> </p>
	</form>
</body>
</html>