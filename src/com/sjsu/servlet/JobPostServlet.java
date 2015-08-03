package com.sjsu.servlet;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjsu.dao.JobPostDao;
import com.sjsu.model.JobPost;



public class JobPostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT_JOB_POST = "/addEditJobPost.jsp";
    private static String LIST_JOB_POSTS = "/listJobPosts.jsp";
    private static String LIST_OF_JOB_SEEKERS="/listOfJobSeekers.jsp";
    
    private JobPostDao dao;

    public JobPostServlet() {
        super();
        dao = new JobPostDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
       // int employerId = Integer.parseInt(request.getParameter("Employer_ID"));
        int employerId = 8;
        if (action.equalsIgnoreCase("delete")){
            int jobId = Integer.parseInt(request.getParameter("Job_Id"));
            dao.deleteJobPost(jobId);
            forward = LIST_JOB_POSTS;
            request.setAttribute("jobPosts", dao.getJobPostsForEmployer(employerId));    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT_JOB_POST;
            int jobId = Integer.parseInt(request.getParameter("Job_Id"));
            JobPost jobPost = dao.getJobPostById(jobId);
            request.setAttribute("jobPost", jobPost);
        } else if (action.equalsIgnoreCase("listJobPosts")){
            forward = LIST_JOB_POSTS;
            request.setAttribute("jobPosts", dao.getJobPostsForEmployer(employerId));
        }  else if(action.equalsIgnoreCase("listOfJobSeekers")) {
        	forward = LIST_OF_JOB_SEEKERS;
        	int jobId = Integer.parseInt(request.getParameter("Job_Id"));
        	request.setAttribute("jobSeekersList", dao.getJobSeekersListByJobId(jobId));
        	request.setAttribute("jobInfo", dao.getJobPostById(jobId));
        }else {
        	
            forward = INSERT_OR_EDIT_JOB_POST;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JobPost jp = new JobPost();
        jp.setCompany_Name(request.getParameter("company_name"));
        //int employerId = 8;
        int employerId = Integer.parseInt(request.getParameter("employer_ID"));
        jp.setEmployer_ID(employerId);
        jp.setJob_Title(request.getParameter("job_Title"));
        jp.setJob_description(request.getParameter("job_description"));
        jp.setCompany_Name(request.getParameter("company_Name"));
        jp.setJob_location(request.getParameter("job_location"));
        
        //jp.setDate_Posted(jrequest.getParameter("Date_Posted"));
        jp.setJob_salary(Integer.parseInt(request.getParameter("job_salary")));
        jp.setContact_Person(request.getParameter("contact_Person"));
        jp.setPhone_Number(request.getParameter("phone_Number"));
        jp.setExperience(Integer.parseInt(request.getParameter("experience")));
        jp.setSkillsetsString(request.getParameter("skillsets"));
        
        
        String jobId = request.getParameter("job_ID");
        if(jobId == null || jobId.isEmpty())
        {
            dao.addJobPost(jp);
        }
        else
        {
            jp.setJob_ID(Integer.parseInt(jobId));
            dao.updateJobPost(jp);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_JOB_POSTS);
        request.setAttribute("jobPosts", dao.getJobPostsForEmployer(employerId));
        view.forward(request, response);
    }
}