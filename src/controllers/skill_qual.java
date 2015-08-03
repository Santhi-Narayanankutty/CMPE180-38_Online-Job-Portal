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
 * Servlet implementation class skill_qual
 */
@WebServlet("/skill_qual")


public class skill_qual extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public skill_qual() {
        super();
        // TODO Auto-generated constructor stub
    }
    private Connection connection;
  	private ResultSet resultset;
  	int count;
  	int count1;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		try {
			String url1 = "jdbc:mysql://localhost/test";
			this.connection = DriverManager.getConnection(url1,"root", "root");
			System.out.println("Connection Established");
		} catch (SQLException e) {
			System.out.println("Connection unEstablished");
			e.printStackTrace();
		}
		int ID = Integer.parseInt(request.getParameter("Hidden_ID"));
		String query = "Select count(*) from job_seeker_skills where JS_ID = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1,ID);
			resultset = ps.executeQuery();
		} catch (SQLException e) {
					e.printStackTrace();
		}
		try {
			while (resultset.next()) {
				 count1= resultset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ski;
		String del_ski= "delete from job_seeker_skills where JS_ID = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(del_ski);
			ps.setInt(1,ID);
			ps.executeUpdate();
		} catch (SQLException e) {
					e.printStackTrace();
		}
		for(int j=0;j < count1; j++)
		{
		
		
		String skill = "skill" + j;
		skill = request.getParameter(skill);
		String exp = "exp" +j;
		exp = request.getParameter(exp);
		System.out.println(skill+exp);
		String skill_modif = "insert into job_seeker_skills(JS_ID,JS_Skills,JS_Experience)"
				+ "values(?,?,?)";
		try {
			PreparedStatement ps2 = connection.prepareStatement(skill_modif);
			ps2.setInt(1,ID);
			ps2.setString(2,skill);	
			ps2.setString(3,exp);	
			ps2.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		}
		String query3 = "Select count(*) from job_seeker_qualification where JS_ID = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query3);
			ps.setInt(1,ID);
			resultset = ps.executeQuery();
		} catch (SQLException e) {
					e.printStackTrace();
		}
		
		try {
			while (resultset.next()) {
				 count= resultset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String qual;
		String quali= "delete from job_seeker_qualification where JS_ID = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(quali);
			ps.setInt(1,ID);
			ps.executeUpdate();
	 } catch (SQLException e) {
					e.printStackTrace();
		}
		for(int i=0;i < count; i++)
		{
		qual = "Qual" + i;
		String qual1 = request.getParameter(qual);
		System.out.println(qual1);
		String qual_modif = "insert into job_seeker_qualification(JS_ID,JS_educational_Qualification)"
				+ "values(?,?)";
		try {
			PreparedStatement ps1 = connection.prepareStatement(qual_modif);
			ps1.setInt(1,ID);
			ps1.setString(2,qual1);		
			ps1.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String url = "Edit_more.jsp";
		System.out.println("goudamy");
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    try {
			dispatcher.forward(request,response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
	}



}
