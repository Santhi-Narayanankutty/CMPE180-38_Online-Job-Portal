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
public class DeleteJSSkills extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String JS_Skills, query;
	Connection conn;
	Statement stmt;
	ResultSet res;
	DatabaseConnection dbconn;
  
    public DeleteJSSkills() {
        super();  
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try{
			
			dbconn= new DatabaseConnection();
			conn = dbconn.setConnection();
			stmt=conn.createStatement();
			JS_Skills = request.getParameter("Skill");
			String JobSeekerID =  request.getParameter("JS_ID");
			System.out.println(JS_Skills);
			System.out.println(JobSeekerID);
			query = "Delete from Job_Seeker_Skills where JS_ID = '"+JobSeekerID+"' AND JS_Skills = '"+JS_Skills+"'";
			int i = stmt.executeUpdate(query);
			
		}catch (Exception e){
			
		}
		finally{
			RequestDispatcher rd = request.getRequestDispatcher("/JSSkillsServlet");
			rd.forward(request, response);
			out.close();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
