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
public class UpdateEmployerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String Employer_Id, eName, email, password, Security_Ques, Security_Ans, Num_of_openings, Account_Type, query;
	
	Connection conn;
	Statement stmt;
	int res;
	DatabaseConnection dbconn;
  
    public UpdateEmployerList() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try{
			
			dbconn = new DatabaseConnection();
			
			Employer_Id = request.getParameter("Emp_id");
			
			eName = request.getParameter("eName");
			email = request.getParameter("e_email");		
			password = request.getParameter("e_password");
			Security_Ques = request.getParameter("Security_Question");
			Security_Ans = request.getParameter("Security_Answer");
			Num_of_openings = request.getParameter("Number_of_openings");
			Account_Type = request.getParameter("Account_Type");
			 System.out.println(Employer_Id);
			conn = dbconn.setConnection();
			stmt = conn.createStatement();
			query="update Employer_SignUp set eName='"+eName+"', e_email='"+email+"', e_password='"+password+"', Security_Question ='"+Security_Ques+"', Security_Answer='"+Security_Ans+"', Number_of_openings='"+Num_of_openings+"' Account_type='"+Account_Type+"' where Employer_ID='"+Employer_Id+"'";
		      
		    int i = stmt.executeUpdate(query);
		   
		      
		}catch (Exception e){
		
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
