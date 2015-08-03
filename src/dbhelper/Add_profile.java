/**
 * 
 */
package dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Goudamy
 * 
 */
public class Add_profile {
	private Connection connection;
	private ResultSet resultset;

	public Add_profile(String username, String psswd) {
		String url = "jdbc:mysql://localhost/test";
		try {
			this.connection = DriverManager.getConnection(url, username, psswd);
			System.out.println("Connection Established");
		} catch (SQLException e) {
			System.out.println("Connection unEstablished");
			e.printStackTrace();
		}
	}

	public void add_entries(String Profile_ID, String fname, String lname,
			String mname, String dob, String pcell, String phome,
			String poffice, String resume, String salary_exp, String relocate,
			String state, String Country, String city, String zip,
			String position) {
		int home, office, salary;
		boolean a;
		if (dob == "") {
			dob = "0000/00/00";
		}
		
		if (phome == "" ) {	
			home = 0;	
		} else {
			if (phome == "null")
			{
					home = 0;
			}
			else
			 {
			home = Integer.parseInt(phome);
				}
			}
		if (poffice == "") 
		{		
			office = 0;
		} 
		else {
			if(poffice == null){
				office = 0;
		}
		else{
			office = Integer.parseInt(poffice);
	
		}
			}
		if (salary_exp == "") {
			
			salary = 0;
			
		} else {
			if (salary_exp == null){
			salary = 0;	
			}
		{
			salary = Integer.parseInt(salary_exp);
			
		}}
		String query2 = "insert into job_seeker_profile"
				+ "(ID,fName,lName,mInit,Date_Of_Birth,city,state,"
				+ "zipcode,Country,Phone_Cell,Phone_Home,Phone_work,"
				+ "My_resume,Salary,Desired_Position,Willing_to_Relocate)"
				+ "      values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps1 = connection.prepareStatement(query2);
			ps1.setString(1, Profile_ID);
			ps1.setString(2, fname);
			ps1.setString(3, lname);
			ps1.setString(4, mname);
			ps1.setString(5, dob);
			ps1.setString(6, city);
			ps1.setString(7, state);
			ps1.setString(8, zip);
			ps1.setString(9, Country);
			ps1.setString(10, pcell);
			ps1.setInt(11, home);
			ps1.setInt(12, office);
			ps1.setString(13, resume);
			ps1.setInt(14, salary);
			ps1.setString(15, position);
			ps1.setString(16, relocate);

			ps1.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
