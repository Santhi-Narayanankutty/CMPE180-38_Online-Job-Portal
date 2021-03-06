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
 * Servlet implementation class EditJobSeekerList
 */
public class EditJSProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String JobSeeker_Id, query;
	Connection conn;
	Statement stmt;
	ResultSet res;
	DatabaseConnection dbconn;
  
    public EditJSProfileServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try{
			
			JobSeeker_Id=request.getParameter("JS_ID");
			dbconn= new DatabaseConnection();
			conn=dbconn.setConnection();
			stmt=conn.createStatement();
			query="select *from Job_Seeker_Profile where ID='"+JobSeeker_Id+"'";
			res=dbconn.getResult(query, conn);
			System.out.println(JobSeeker_Id);

		}catch (Exception e){
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
		finally{
			request.setAttribute("JobSeekerData", res);
			RequestDispatcher rd = request.getRequestDispatcher("/UpdateJSProfile.jsp");
			rd.forward(request, response);
			out.close();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
