package dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class rating {
	private Connection connection;
	private ResultSet resultset;



	public rating(String username,String psswd){
		String url = "jdbc:mysql://localhost/test";
		 try {
			this.connection = DriverManager.getConnection(url,username, psswd);
			System.out.println("Connection Established");
		} catch (SQLException e) {
			System.out.println("Connection unEstablished");
				e.printStackTrace();
		}
	}
		 public void add_rating(String Profile_ID) {
			 int add = Integer.parseInt(Profile_ID);
			 String query =  "select job_title,job_description,company_Name from online_job_portal.job_post JP,"
			 		+ "online_job_portal.job_applied JA where JA.job_Id = JP.Job_ID "
			 		+ "and JA.Jobseeker_ID = ?";
					
				try {
					PreparedStatement ps = connection.prepareStatement(query);
					ps.setInt(1,add);
					resultset = ps.executeQuery();
				} catch (SQLException e) {
							e.printStackTrace();
				}	
		 }
		 public String create_table(){
			 String table = "";	
			 String final1,final2,final3;
				
				table += "<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100px\">";
				table += "<tr align = center>";
				table += "<td>";
				table += "Job Title";
				table += "</td>";
				table += "<td>";
				table += "Job Description";
				table += "</td>";
				table += "<td>";
				table += "Company Name";
				table += "</td>";
				try {
					while(resultset.next()){
						
						final1 = resultset.getString("job_title");	
						 final2 = resultset.getString("job_description");	
						 final3 = resultset.getString("company_Name");	
						 table += "<tr>"; 
						table += "<td>";
						table += final1;
						table += "</td>";
						table += "<td>";
						table += final2;
						table += "</td>";
						table += "<td>";
						table += final3;
						table += "</td>";
						table += "</tr>";
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return table;
		 }
	}




