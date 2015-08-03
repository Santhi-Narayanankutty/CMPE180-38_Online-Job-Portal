package dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Add_skill {
	private Connection connection;
	int add;

	public Add_skill(String username,String psswd){
		String url = "jdbc:mysql://localhost/test";
		 try {
			this.connection = DriverManager.getConnection(url,username, psswd);
			System.out.println("Connection Established");
		} catch (SQLException e) {
			System.out.println("Connection unEstablished");
				e.printStackTrace();
		}
	}

	public void add_skillset(String profile_ID,String skill1,String exp1,String skill2,String exp2,String skill3,String exp3){
	  int add = Integer.parseInt(profile_ID);
		String query2 = "insert into job_seeker_skills (JS_ID,JS_skills,JS_experience)"
				+ "      values(?,?,?)";
				
		try {
			PreparedStatement ps1 = connection.prepareStatement(query2);
			ps1.setInt(1,add);
			ps1.setString(2,skill1);
			ps1.setString(3,exp1);
			
			ps1.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	if (skill2 != null && !skill2.equals("")){	
		String query3 = "insert into job_seeker_skills (JS_ID,JS_skills,JS_experience)"
				+ "      values(?,?,?)";
				
		try {
			PreparedStatement ps3 = connection.prepareStatement(query3);
			ps3.setInt(1,add);
			ps3.setString(2,skill2);
			ps3.setString(3,exp2);
			
			ps3.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	if (skill3 != null && !skill3.equals("")){	
		String query4 = "insert into job_seeker_skills (JS_ID,JS_skills,JS_experience)"
				+ "      values(?,?,?)";
				
		try {
			PreparedStatement ps4 = connection.prepareStatement(query4);
			ps4.setInt(1,add);
			ps4.setString(2,skill3);
			ps4.setString(3,exp3);
			
			ps4.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	}

}
