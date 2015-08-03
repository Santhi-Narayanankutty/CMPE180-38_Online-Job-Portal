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
public class EditEmployerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection conn;
	Statement stmt;
	ResultSet res;
	String Employer_Id, query;
	DatabaseConnection dbconn;
	List<String> lst = new ArrayList<String>();
 
    public EditEmployerList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try{
			
			String Employer_Id=request.getParameter("Emp_id");
			dbconn = new DatabaseConnection();
			conn = dbconn.setConnection();
			stmt = conn.createStatement();
			query = "select Employer_Id, Job_ID, job_Title, job_description, Company_Name, job_location, Date_Posted, job_Salary, contact_person, Phone_Number from Job_Post where Employer_Id='"+Employer_Id+"'";
			res = dbconn.getResult(query, conn);
			
			while(res.next()){
				lst.add(res.getString("Employer_Id"));
				lst.add(res.getString("Job_Id"));
				lst.add(res.getString("job_Title"));
				lst.add(res.getString("job_description"));
				lst.add(res.getString("Company_Name"));
				lst.add(res.getString("job_location"));
				lst.add(res.getString("Date_Posted"));
				lst.add(res.getString("job_Salary"));
				lst.add(res.getString("contact_person"));
				lst.add(res.getString("Phone_Number"));
			}
			res.close();
	
		}catch (Exception e){
			
		}
		
		finally {
			request.setAttribute("FetchData", lst);
			RequestDispatcher rd = request.getRequestDispatcher("/editEmployer.jsp");
			rd.forward(request, response);
			lst.clear();
			out.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
