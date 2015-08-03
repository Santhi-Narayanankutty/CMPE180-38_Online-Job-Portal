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
 * Servlet implementation class Edit1
 */
@WebServlet("/Edit1")
public class Edit1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
	String ID1 = request.getParameter("Hidden_ID");
	int ID = Integer.parseInt(ID1);
		String query = "Select * from job_seeker_profile where ID = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1,ID);
			resultset = ps.executeQuery();
		} catch (SQLException e) {
					e.printStackTrace();
		}

try {
	while(resultset.next()){
			try {
				request.setAttribute("ID", resultset.getInt("ID"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				request.setAttribute("fname",resultset.getString("fname"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				request.setAttribute("lname",resultset.getString("lname"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				request.setAttribute("mname",resultset.getString("mInit"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				request.setAttribute("dob",resultset.getString("Date_Of_Birth"));
			} catch (SQLException e) {
				String dob = "";
				
			}
			try {
				request.setAttribute("city",resultset.getString("city"));
			} catch (SQLException e) {
				String city = "";
				
			}
			try {
				request.setAttribute("state",resultset.getString("state"));
			} catch (SQLException e) {
			String state = "";
		
			}
			try {
				request.setAttribute("zipcode",resultset.getString("zipcode"));
			} catch (SQLException e) {
				String zipcode = "";
			
			}
			try {
				request.setAttribute("country",resultset.getString("Country"));
			} catch (SQLException e) {
				String country = "";
				
			}
			try {
				request.setAttribute("phone_cell",resultset.getString("Phone_Cell"));
			} catch (SQLException e) {
			String phone_cell = "";
			
			}
			try {
				request.setAttribute("phone_home",resultset.getInt("Phone_Home"));
			} catch (SQLException e) {
			String phone_home = "";
				
			}
			try {
				request.setAttribute("phone_work",resultset.getInt("Phone_work"));
			} catch (SQLException e) {
				String phone_work = "";
				
			}	
			try {
				request.setAttribute("My_resume",resultset.getString("My_resume"));
			} catch (SQLException e) {
				String My_resume = "";
			
			}
			try {
				request.setAttribute("salary",resultset.getInt("salary"));
			} catch (SQLException e) {
			String salary = "";
				
			}
			try {
				request.setAttribute("Desired_Position",resultset.getString("Desired_Position"));
			} catch (SQLException e) {
				String Desired_Position = "";
				
			}
			try {
				request.setAttribute("Relocate",resultset.getString("Willing_to_Relocate"));
			} catch (SQLException e) {
			String Relocate = "";
				
			}
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		String url = "Edit1_profile.jsp";
		String ID2 = Integer.toString(ID);
	    request.setAttribute("Hidden_ID",ID2);
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}

	
		
	
    
}
