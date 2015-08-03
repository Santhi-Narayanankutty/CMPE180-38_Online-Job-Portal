<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Add New Job Post</title>
</head>
<body>
 

    <form method="POST" action='JobPostServlet' name="JobPostAddEditForm">
         <input type="hidden" readonly="readonly" name="employer_ID"
            value="<c:out value="${jobPost.employer_ID}" />" /> <br />
            <input type="hidden" readonly="readonly" name="job_ID"
            value="<c:out value="${jobPost.job_ID}" />" /> <br /> 
        Company Name : <input
            type="text" name="company_Name"
            value="<c:out value="${jobPost.company_Name}" />" /> <br /> 
        Job Title : <input
            type="text" name="job_Title"
            value="<c:out value="${jobPost.job_Title}" />" /> <br /> 
        Job Description : <input
            type="text" name="job_description"
            value="<c:out value="${jobPost.job_description}" />" /> <br /> 
        Job Location : <input
            type="text" name="job_location"
            value="<c:out value="${jobPost.job_location}" />" /> <br /> 
         Skill Sets: <input
            type="text" name="skillsets"
            value="<c:out value="${jobPost.skillsetsString}" />" /> <br />  
            
            Minimum Experience <input
            type="text" name="experience"
            value="<c:out value="${jobPost.experience}" />" /> <br />       
            
         Job Salary : <input
            type="text" name="job_salary"
            value="<c:out value="${jobPost.job_salary}" />" /> <br />     
            
             ContactPerson : <input
            type="text" name="contact_Person"
            value="<c:out value="${jobPost.contact_Person}" />" /> <br />     
                
        
        Phone Number : <input type="text" name="phone_Number"
            value="<c:out value="${jobPost.phone_Number}" />" /> <br /> <input
            type="submit" value="Submit" />
    </form>
</body>
</html>