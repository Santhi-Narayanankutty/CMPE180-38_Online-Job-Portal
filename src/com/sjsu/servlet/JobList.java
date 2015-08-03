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

import com.sjsu.servlet.DatabaseConnection;

/**
 * Servlet implementation class EditRecord
 */
public class JobList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection conn;
	Statement stmt;
	ResultSet res;
	String Employer_Id, query;
	DatabaseConnection dbconn;
	List<String> lst = new ArrayList<String>();
 
    public JobList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try{
			Employer_Id = request.getParameter("Employer_Id");
			dbconn = new DatabaseConnection();
			conn = dbconn.setConnection();
			stmt = conn.createStatement();
			query = "select Job_ID, job_Title, job_description, Company_Name, job_location, Date_Posted, job_Salary, contact_person, Phone_Number from Job_Post where Job_Id=10008";
			res = dbconn.getResult(query, conn);
	
		}catch (Exception e){
			
		}
		
		finally {
			request.setAttribute("FetchData", res);
			RequestDispatcher rd = request.getRequestDispatcher("/editEmployer.jsp");
			rd.forward(request, response);
			lst.clear();
			out.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
