package com.sjsu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteJobSeekerList
 */
public class DeleteJobs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String Employer_Id, query;
	Connection conn;
	Statement stmt;
	ResultSet res;
	DatabaseConnection dbconn;
  
    public DeleteJobs() {
        super();  
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try{
			
			dbconn= new DatabaseConnection();
			conn = dbconn.setConnection();
			stmt=conn.createStatement();
			Employer_Id = request.getParameter("Emp_id");
			System.out.println(Employer_Id);
			String Job_Id = request.getParameter("Job_id");
			System.out.println(Job_Id);
			query = "Delete from Job_Post where Job_ID = '"+Job_Id+"' AND Employer_ID='"+Employer_Id+"'";
			int i = stmt.executeUpdate(query);
			
		}catch (Exception e){
			
		}
		finally{
			RequestDispatcher rd = request.getRequestDispatcher("EditEmployerList");
			rd.forward(request, response);
			out.close();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
