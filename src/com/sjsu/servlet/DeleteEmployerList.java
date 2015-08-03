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
public class DeleteEmployerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String Employer_Id, query;
	Connection conn;
	Statement stmt;
	ResultSet res;
	DatabaseConnection dbconn;
  
    public DeleteEmployerList() {
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
			out.println(Employer_Id);
			query = "Delete from Employer_SignUp where Employer_Id='"+Employer_Id+"'";
			int i = stmt.executeUpdate(query);
			
		}catch (Exception e){
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
		finally{
			RequestDispatcher rd = request.getRequestDispatcher("DisplayEmployersList");
			rd.forward(request, response);
			out.close();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
