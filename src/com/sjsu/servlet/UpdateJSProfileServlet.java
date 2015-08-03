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
public class UpdateJSProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String Job_Seeker_Id, fName, lName, mInit, DOB, city, state, zipcode, Country, Phone_cell, Phone_work, Phone_Home, Resume, Salary, Desired_Position, Willing_to_relocate, query;
	
	Connection conn;
	Statement stmt;
	int res;
	DatabaseConnection dbconn;
  
    public UpdateJSProfileServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try{
			
			dbconn = new DatabaseConnection();
			
			Job_Seeker_Id = request.getParameter("JS_id");
			fName = request.getParameter("fName");		
			lName = request.getParameter("lName");
			mInit = request.getParameter("mInit");
			DOB = request.getParameter("Date_Of_Birth");
			city = request.getParameter("city");
			state = request.getParameter("state");
			Country = request.getParameter("Country");		
			zipcode = request.getParameter("zipcode");
			Phone_cell = request.getParameter("Phone_cell");
			Phone_work = request.getParameter("Phone_Work");
			Phone_Home= request.getParameter("Phone_Home");
			Resume = request.getParameter("My_Resume");
			Salary = request.getParameter("Salary");		
			Desired_Position = request.getParameter("Desired_Position");
			Willing_to_relocate = request.getParameter("Willing_to_Relocate");
			
			conn = dbconn.setConnection();
			stmt = conn.createStatement();
			query="update Job_Seeker_Profile set fName='"+fName+"', lName='"+lName+"', mInit ='"+mInit+"', Date_Of_Birth='"+DOB+"', city='"+city+"', state='"+state+"', zipcode='"+zipcode+"', Country ='"+Country+"', Phone_Cell='"+Phone_cell+"', Phone_Home='"+Phone_Home+"', Phone_Work ='"+Phone_work+"', My_Resume='"+Resume+"', Salary='"+Salary+"', Desired_Position='"+Desired_Position+"', Willing_to_Relocate='"+Willing_to_relocate+"' where ID='"+Job_Seeker_Id+"'";
		      
		    int i = stmt.executeUpdate(query);
		    System.out.println(Job_Seeker_Id);
		      
		}catch (Exception e){
		
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
