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
public class DeleteJobSeekerProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String Job_Seeker_Id, query;
	Connection conn;
	Statement stmt;
	ResultSet res;
	DatabaseConnection dbconn;
  
    public DeleteJobSeekerProfile() {
        super();  
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try{
			
			dbconn= new DatabaseConnection();
			conn = dbconn.setConnection();
			stmt=conn.createStatement();
			Job_Seeker_Id = request.getParameter("JS_ID");
			System.out.println(Job_Seeker_Id);
			out.println(Job_Seeker_Id);
			query = "Delete from Job_Seeker_Profile where ID='"+Job_Seeker_Id+"'";
			int i = stmt.executeUpdate(query);
			
			
		}catch (Exception e){
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
		finally{
			RequestDispatcher rd = request.getRequestDispatcher("JobSeekerProfile");
			rd.forward(request, response);
			out.close();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
