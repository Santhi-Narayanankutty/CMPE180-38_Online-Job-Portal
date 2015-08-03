/**
 * 
 */
package dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Goudamy
 *
 */
public class qual {
	private Connection connection;
	int add;

	public qual(String username,String psswd){
		String url = "jdbc:mysql://localhost/test";
		 try {
			this.connection = DriverManager.getConnection(url,username, psswd);
			System.out.println("Connection Established");
		} catch (SQLException e) {
			System.out.println("Connection unEstablished");
				e.printStackTrace();
		}
	}

	public void qualif(String profile_ID,String q1,String q2,String q3){
	  int add = Integer.parseInt(profile_ID);
		String query2 = "insert into job_seeker_qualification (JS_ID,JS_educational_Qualification)"
				+ "      values(?,?)";
				
		try {
			PreparedStatement ps1 = connection.prepareStatement(query2);
			ps1.setInt(1,add);
			ps1.setString(2,q1);
	
			
			ps1.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	if (q2 != null ){	
		String query3 = "insert into job_seeker_qualification (JS_ID,JS_educational_Qualification)"
				+ "      values(?,?)";
				
		try {
			PreparedStatement ps3 = connection.prepareStatement(query3);
			ps3.setInt(1,add);
			ps3.setString(2,q2);
	
			
			ps3.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	if (q3 != null ){	
		String query4 = "insert into job_seeker_qualification (JS_ID,JS_educational_Qualification)"
				+ "      values(?,?)";
				
		try {
			PreparedStatement ps4 = connection.prepareStatement(query4);
			ps4.setInt(1,add);
			ps4.setString(2,q3);

			
			ps4.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	}

}
