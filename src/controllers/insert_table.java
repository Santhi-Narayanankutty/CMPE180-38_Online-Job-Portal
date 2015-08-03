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

/**
 * Servlet implementation class insert_table
 */
@WebServlet("/jsweb")
public class insert_table extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insert_table() {
        super();
        // TODO Auto-generated constructor stub
    }
    private Connection connection;
   	private ResultSet resultset;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url1 = "jdbc:mysql://localhost/test";
		try {
			this.connection = DriverManager.getConnection(url1,"root", "root");
			System.out.println("Connection Established");
		} catch (SQLException e) {
			System.out.println("Connection unEstablished");
			e.printStackTrace();
		}
		String ID1=request.getParameter("Hidden_ID");
		int ID= Integer.parseInt(ID1);
				
		String checker[] = request.getParameterValues("check");
		for(int i=0;i<checker.length;i++){			
		System.out.println(checker[i]) ;
		String query2 = "insert into job_applied(Job_Id,JobSeeker_ID)"
				+ "      values(?,?)";
				
		try {
			PreparedStatement ps1 = connection.prepareStatement(query2);
			
			ps1.setString(1,checker[i]);
			ps1.setInt(2,ID);
			
			ps1.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		
		}
		
		String ID2 = Integer.toString(ID);
	    request.setAttribute("Hidden_ID",ID2);
		String url = "jobseeker_webpage.jsp";
		
		
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}


	

}
