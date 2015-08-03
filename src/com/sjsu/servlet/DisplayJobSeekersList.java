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
 * Servlet implementation class DisplayJobSeekersList
 */
public class DisplayJobSeekersList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String query;
	Connection conn;
	Statement stmt;
	ResultSet res;
	DatabaseConnection dbconn;
	List<String> lst = new ArrayList<String>();
       
    
    public DisplayJobSeekersList() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try{
			dbconn= new DatabaseConnection();
			conn = dbconn.setConnection();
			stmt = conn.createStatement();
			query = "select JobSeeker_Id, email, pass_word, Security_Question, Security_Answer, Account_Type from Job_Seeker_SignUp";
			res = dbconn.getResult(query, conn);
			
			while(res.next()){
				
				lst.add(res.getString("JobSeeker_Id"));
				lst.add(res.getString("email"));
				lst.add(res.getString("pass_word"));
				lst.add(res.getString("Security_Question"));
				lst.add(res.getString("Security_Answer"));
				lst.add(res.getString("Account_Type"));
			}
			res.close();
			
		}catch (Exception e){
			
		}
		finally{
			request.setAttribute("JobSeekerData", lst);
			RequestDispatcher rd = request.getRequestDispatcher("/JobSeekersList.jsp");
			rd.forward(request, response);
			lst.clear();
			out.close();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
