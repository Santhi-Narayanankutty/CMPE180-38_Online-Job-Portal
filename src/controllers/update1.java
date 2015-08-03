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

import job.Job;
import job.Qualification;
import job.Skill;

/**
 * Servlet implementation class update1
 */
@WebServlet("/update1")
public class update1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update1() {
        super();
        // TODO Auto-generated constructor stub
    }
    private Connection connection;
 	private ResultSet resultset;
 	String table = "";
	String table1 = "";	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ID = Integer.parseInt(request.getParameter("ID"));
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String mname = request.getParameter("mname");
		String dob =  request.getParameter("dob");
		String city =  request.getParameter("city");
		String state =  request.getParameter("state");
		
		String zipcode =  request.getParameter("zipcode");
		String phone_cell =  request.getParameter("phone_cell");

		int phone_work = Integer.parseInt (request.getParameter("phone_work"));
		System.out.println("vals are"+phone_work);
		int phone_home = Integer.parseInt(request.getParameter("phone_home"));
		System.out.println("vals are"+phone_home);
		int Salary = Integer.parseInt( request.getParameter("Salary"));
		System.out.println("vals are");
		String country = request.getParameter("country");
		String My_resume = request.getParameter("My_resume");
		String Relocate =  request.getParameter("Relocate");
		String Desired_Position = request.getParameter("Desired_Position");
		System.out.println("vals are"+ID+Relocate);
		String url1 = "jdbc:mysql://localhost/test";
		try {
			this.connection = DriverManager.getConnection(url1,"root", "root");
			System.out.println("Connection Established");
		} catch (SQLException e) {
			System.out.println("Connection unEstablished");
			e.printStackTrace();
		}
		
		String query2 = "update job_seeker_profile set fName =?,lName =?,mInit =?,Date_Of_Birth =?,"
				+ "city =?,state=?,zipcode =?,Country =?,Phone_Cell =?,Phone_Home =?,Phone_work=?,"
				+ "My_resume =?,Salary =?,Desired_Position =?,Willing_to_Relocate =? where ID = ?";
		try {
			PreparedStatement ps1 = connection.prepareStatement(query2);
			
			ps1.setString(1, fname);
			ps1.setString(2, lname);
			ps1.setString(3, mname);
			ps1.setString(4, dob);
			ps1.setString(5, city);
			ps1.setString(6, state);
			ps1.setString(7, zipcode);
			ps1.setString(8, country);
			ps1.setString(9, phone_cell);
			ps1.setInt(10, phone_home);
			ps1.setInt(11, phone_work);
			ps1.setString(12, My_resume);
			ps1.setInt(13, Salary);
			ps1.setString(14, Desired_Position);
			ps1.setString(15, Relocate);
			ps1.setInt(16, ID);
			ps1.executeUpdate();
	}catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
			System.out.println("Updated Successfully"+ID+Relocate);
		String query = "Select * from job_seeker_skills where JS_ID = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1,ID);
			resultset = ps.executeQuery();
		} catch (SQLException e) {
					e.printStackTrace();
		}
		try {
										
			table += "<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100px\">";
			table += "<tr align = center>";
			table += "<td>";
			table += "Job_ID";
			table +="</td>";
			table += "<td>";
			table += "<b>Job Skills";
			table +="</td>";
			table += "<td>";
			table += "<b>Job Experience";
			table +="</td>";
			table +="</tr>";
			int j = 0;
			while(resultset.next()){
					try {
						Skill skill = new Skill();
						skill.setJob_Id(resultset.getInt("JS_ID"));
						skill.setJob_skill(resultset.getString("JS_skills"));
						skill.setJob_exp(resultset.getString("JS_experience"));
						table += "<tr>";
						table +="<td>";
					//	table +="<input type = \"text\" name = ";
						//table += "IDA" + j+ " value = \"";
						table += skill.getJob_Id();
						//table += " \"> ";
						table +="</td>";
						table +="<td>";
						table +="<input type = \"text\" name = ";
						table += "skill" + j+ " value = \"";
				        table += skill.getJob_skill();
				        table += " \"> ";
						table +="</td>";
						table +="<td>";
						table +="<input type = \"text\" name = ";
						table += "exp" + j+ " value = \"";
						table += skill.getJob_exp();
						table += " \"> ";
						table +="</td>";
						table+="</tr>";
						j = j+1;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			} 
			table +="<input type = \"hidden\" name = j value = \"";
			table += "j  \">";
			table += "</table>";
			System.out.println(table);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query3 = "Select * from job_seeker_qualification where JS_ID = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query3);
			ps.setInt(1,ID);
			resultset = ps.executeQuery();
		} catch (SQLException e) {
					e.printStackTrace();
		}
		try {
				
			
			table1 += "<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100px\">";
			table1 += "<tr align = center>";
			table1 += "<td>";
			table1 += "Job_ID";
			table1 +="</td>";
			table1 += "<td>";
			table1 += "<b>Qualification";
			table1 +="</td>";
			
			table1 +="</tr>";
			int i=0;
			while(resultset.next()){
					try {
						Qualification qual = new Qualification();
						qual.setJOB_ID(resultset.getInt("JS_ID"));
						qual.setJS_educational_Qualification(resultset.getString("JS_educational_Qualification"));
						table1 += "<tr>";
						table1 += "<td>" ;
					//	table1 +="<input type = \"text\" name = ";
					//	table1 += "Qual" + i+ " value = \"";
						table1 += qual.getJOB_ID();
					//	table1 += " \"> ";
						table1 +="</td>";
						table1 +="<td>";
						table1 +="<input type = \"text\" name = ";
						table1 += "Qual" + i+ " value = \""; 
						table1 += qual.getJS_educational_Qualification();
				        table1 += "\"> ";
				        table1 +="</td>";						
						table1 +="</tr>";
						i = i+1;
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			} 
			
			table1 += "</table>";
			System.out.println(table1);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("table",table);
		request.setAttribute("table1",table1);
		String ID2 = Integer.toString(ID);
	    request.setAttribute("Hidden_ID",ID2);
		String url = "Edit1_skills_qual.jsp";
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}
}
