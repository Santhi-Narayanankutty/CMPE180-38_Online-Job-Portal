<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Job Posts</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>Job Id</th>
                <th>Company Name</th>
                <th>Job Title</th>
                <th>Job Description</th>
                 <th>Min Experience</th>
                  <th>SkillSets</th>
                <th>Job Location</th>
                <th>Job Salary</th>
                <th>Contact Person</th>
                <th>Phone Number</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${jobPosts}" var="job">
                <tr>
                    <td><c:out value="${job.job_ID}" /></td>
                    <td><c:out value="${job.company_Name}" /></td>
                    <td><c:out value="${job.job_Title}" /></td>
                     <td><c:out value="${job.job_description}" /></td>
                      <td><c:out value="${job.experience}" /></td>
                       <td><c:out value="${job.skillsetsString}" /></td>
                    <td><c:out value="${job.job_location}" /></td>
                    <td><c:out value="${job.job_salary}" /></td>
                     <td><c:out value="${job.contact_Person}" /></td>
                     <td><c:out value="${job.phone_Number}" /></td>
                    <td><a href="JobPostServlet?action=edit&Job_Id=<c:out value="${job.job_ID}"/>">Update</a></td>
                    <td><a href="JobPostServlet?action=delete&Job_Id=<c:out value="${job.job_ID}"/>">Delete</a></td>
                    <td><a href="JobPostServlet?action=listOfJobSeekers&Job_Id=<c:out value="${job.job_ID}"/>">List Job Seekers</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="JobPostServlet?action=insert">Add Job Post</a></p>
</body>
</html>