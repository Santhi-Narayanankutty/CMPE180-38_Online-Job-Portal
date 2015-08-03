package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbhelper.FetchJobseeker;

/**
 * Servlet implementation class Jobseeker
 */
@WebServlet("/Login")
public class jobseeker extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection connection;
 	private ResultSet resultset;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jobseeker() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String ID = request.getParameter("Hidden_ID");
   int ID1 = 0;
    
    String url1 = "jdbc:mysql://localhost/test";
	try {
		this.connection = DriverManager.getConnection(url1,"root", "root");
		System.out.println("Connection Established");
	} catch (SQLException e) {
		System.out.println("Connection unEstablished");
		e.printStackTrace();
	}
	String q= "select JobSeeker_ID from job_seeker_signup where email = ?";
	try {
		PreparedStatement ps = connection.prepareStatement(q);
		ps.setString(1,ID);
		resultset = ps.executeQuery();
	} catch (SQLException e) {
				e.printStackTrace();
	}
	try {
		while (resultset.next()) {
		 ID1= resultset.getInt("JobSeeker_ID");
		
		}
		System.out.println(ID1);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	FetchJobseeker fetchjobseeker = new FetchJobseeker("root","Ramanathan@1988");
	fetchjobseeker.read_employee(ID1); 
	String table = fetchjobseeker.getjobseeker_html();
	System.out.println(table);
    request.setAttribute("table",table);   
    String ID2 = Integer.toString(ID1);
    request.setAttribute("Hidden_ID",ID2);
    request.getParameterValues("check");
    String url = "jobseeker_webpage.jsp";
    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    dispatcher.forward(request, response);
    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//}

}
