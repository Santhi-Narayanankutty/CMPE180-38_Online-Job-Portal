<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%	String Hidden_ID = (String) request.getAttribute("Hidden_ID");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Qualification</title>
</head>
<body>
<h1> Qualification</h1>
<form name=qualification action=qualification method=get>
<table><tr>
<td>
Qualification</td>
<tr><td>
  <input type = text name = q value = "" /></td>
 
<tr><td>
  <input type = text name = q1 value = "" /></td>

<tr><td>
  <input type = text name = q2 value = "" /></td>

</table>
<input type="hidden" name= Hidden_ID  value=<%=Hidden_ID %>>
<p>
<input type = submit name = submit value = next> </p>
	</form>
</body>
</html>