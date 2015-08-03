<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>List of Job Seekers</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>

                <th>Job Seeker Id</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>M. Initial</th>
                <th>DOB</th>
                <th>City</th>
                <th>State</th>
                <th>ZipCode</th>
                <th>Country</th>
                <th>Mobile #</th>
                <th>Home Ph#</th>
                <th>Work Ph#</th>
                <th>Resume</th>
                <th>Salary</th>
                <th>Desired Position</th>
                <th>Willing To Relocate</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${jobSeekersList}" var="job_seeker">
                <tr>

                    <td><c:out value="${job_seeker.id}" /></td>
                    <td><c:out value="${job_seeker.fName}" /></td>
                    <td><c:out value="${job_seeker.lName}" /></td>
                     <td><c:out value="${job_seeker.mInit}" /></td>
                    <td><c:out value="${job_seeker.dob}" /></td>
                    <td><c:out value="${job_seeker.city}" /></td>
                     <td><c:out value="${job_seeker.state}" /></td>
                     <td><c:out value="${job_seeker.zipcode}" /></td>
                     <td><c:out value="${job_seeker.country}" /></td>
                    <td><c:out value="${job_seeker.phone_Cell}" /></td>
                    <td><c:out value="${job_seeker.phone_Home}" /></td>
                     <td><c:out value="${job_seeker.phone_Work}" /></td>
                    <td><c:out value="${job_seeker.my_Resume}" /></td>
                    <td><c:out value="${job_seeker.salary}" /></td>
                     <td><c:out value="${job_seeker.desired_Position}" /></td>
                     <td><c:out value="${job_seeker.willing_to_Relocate}" /></td>
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="JobPostServlet?action=insert">Add Job Post</a></p>
</body>
</html>