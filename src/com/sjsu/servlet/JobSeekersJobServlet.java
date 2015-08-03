package com.sjsu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditJobSeekerList
 */
public class JobSeekersJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String Job_Id, query;
	Connection conn;
	Statement stmt;
	ResultSet res;
	DatabaseConnection dbconn;
  
    public JobSeekersJobServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try{
			
			Job_Id=request.getParameter("Job_id");
			dbconn= new DatabaseConnection();
			conn=dbconn.setConnection();
			stmt=conn.createStatement();
			query="select Id, job_skills, experience from Job_Skills WHERE Id='"+Job_Id+"'";
			res=dbconn.getResult(query, conn);
			System.out.println(Job_Id);

		}catch (Exception e){
			
		}
		finally{
			request.setAttribute("JobProfile", res);
			RequestDispatcher rd = request.getRequestDispatcher("/JobProfile.jsp");
			rd.forward(request, response);
			out.close();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
