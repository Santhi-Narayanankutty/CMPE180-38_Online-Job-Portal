package com.sjsu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateJobSeekerList
 */
public class UpdateJobSeekerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String Job_Seeker_Id, email, password, Security_Ques, Security_Ans, Account_Type, query;
	
	Connection conn;
	Statement stmt;
	int res;
	DatabaseConnection dbconn;
  
    public UpdateJobSeekerList() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try{
			
			dbconn = new DatabaseConnection();
			
			Job_Seeker_Id = request.getParameter("JS_id");
			email = request.getParameter("email");		
			password = request.getParameter("pass_word");
			Security_Ques = request.getParameter("Security_Question");
			Security_Ans = request.getParameter("Security_Answer");
			Account_Type = request.getParameter("Account_Type");
			
			conn = dbconn.setConnection();
			stmt = conn.createStatement();
			query="update job_Seeker_SignUp set email='"+email+"', pass_word='"+password+"', Security_Question ='"+Security_Ques+"', Security_Answer='"+Security_Ans+"', Account_type='"+Account_Type+"' where JobSeeker_Id='"+Job_Seeker_Id+"'";
		      
		    int i = stmt.executeUpdate(query);
		    System.out.println(Job_Seeker_Id);
		      
		}catch (Exception e){
		
		}
		finally{
			RequestDispatcher rd = request.getRequestDispatcher("DisplayJobSeekersList");
			rd.forward(request, response);
			out.close();
		}
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
