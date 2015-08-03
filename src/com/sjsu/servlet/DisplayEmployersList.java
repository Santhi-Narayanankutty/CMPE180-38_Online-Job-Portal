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
 * Servlet implementation class DisplayEmployersList
 */
public class DisplayEmployersList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String query;
	Connection conn;
	Statement stmt;
	ResultSet res;
	DatabaseConnection dbconn;
	List<String> lst = new ArrayList<String>();
       
    
    public DisplayEmployersList() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try{
			dbconn= new DatabaseConnection();
			conn = dbconn.setConnection();
			stmt = conn.createStatement();
			query = "select Employer_Id, eName, e_email, e_password, Security_Question, Security_Answer, Number_of_openings, Account_Type from Employer_SignUp";
			res = dbconn.getResult(query, conn);
			
			while(res.next()){
				
				lst.add(res.getString("Employer_Id"));
				lst.add(res.getString("eName"));
				lst.add(res.getString("e_email"));
				lst.add(res.getString("e_password"));
				lst.add(res.getString("Security_Question"));
				lst.add(res.getString("Security_Answer"));
				lst.add(res.getString("Number_of_openings"));
				lst.add(res.getString("Account_Type"));
			}
			res.close();
			
		}catch (Exception e){
			
		}
		finally{
			request.setAttribute("EmployerData", lst);
			RequestDispatcher rd = request.getRequestDispatcher("/EmployerList.jsp");
			rd.forward(request, response);
			lst.clear();
			out.close();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
