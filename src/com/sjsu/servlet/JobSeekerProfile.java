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
public class JobSeekerProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String JobSeeker_Id, query;
	Connection conn;
	Statement stmt;
	ResultSet res;
	DatabaseConnection dbconn;
  
    public JobSeekerProfile() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try{
			
			JobSeeker_Id=request.getParameter("JS_id");
			dbconn= new DatabaseConnection();
			conn=dbconn.setConnection();
			stmt=conn.createStatement();
			query="select ID, fname, minit, lname, Date_of_birth, city, state, country, zipcode, Phone_cell, phone_Home, phone_work, my_resume, salary, Desired_position, willing_to_relocate from job_Seeker_Profile where ID='"+JobSeeker_Id+"'";
			res=dbconn.getResult(query, conn);
			System.out.println(JobSeeker_Id);

		}catch (Exception e){
			
		}
		finally{
			request.setAttribute("JobSeekerData", res);
			RequestDispatcher rd = request.getRequestDispatcher("/JSProfile.jsp");
			rd.forward(request, response);
			out.close();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
