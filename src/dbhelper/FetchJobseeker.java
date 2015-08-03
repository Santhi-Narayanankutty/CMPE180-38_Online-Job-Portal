/**
 * 
 */
package dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import job.Job;

/**
 * @author Goudamy
 *
 */
public class FetchJobseeker {
private Connection connection;
private ResultSet resultset;

public FetchJobseeker(String username,String psswd){
	String url = "jdbc:mysql://localhost/test";
	 try {
		this.connection = DriverManager.getConnection(url,username, psswd);
		System.out.println("Connection Established");
	} catch (SQLException e) {
		System.out.println("Connection unEstablished");
			e.printStackTrace();
	}
}

public void read_employee(int ID){
	
	String query =  " select Job_ID,job_Title,job_description,job_skills,"
			+ "experience,job_salary,job_location,company_Name,contact_Person,Date_Posted from job_post jp,job_seeker_signup js_up,"
			+ "job_skills js,"
			+ "job_seeker_skills js_s,"
			+ "job_seeker_qualification jq,"
			+ "job_seeker_profile js_p"
			+ " where  js_s.JS_ID = jq.JS_ID "
			+ "and js_p.ID = js_s.JS_ID "
			+ "and js.id = jp.job_ID "
			+ "and js.job_skills = js_s.JS_Skills "
			+ "and js_p.ID = js_up.JobSeeker_ID "
			+ "and js.experience <= js_s.JS_Experience"
			+ " and jp.Job_ID NOT IN (select job_Id"
			+ " from job_applied where JobSeeker_ID = js_p.ID  )and js_p.ID = ?"
			+ " and js_p.ID in (select ID "
			+ "from online_job_portal.job_Seeker_profile "
			+ "where Willing_to_relocate = 'yes')"
			+ "or(select ID from"
			+ " online_job_portal.job_Seeker_profile JSP,"
			+ "online_job_portal.job_post JP"
			+ " where JP.job_location = JSP.city) group by jp.job_ID";
	try {
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1,ID);
		
		resultset = ps.executeQuery();
	} catch (SQLException e) {
				e.printStackTrace();
	}
}

public String getjobseeker_html(){
	String table = "";		
	
	table += "<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100px\">";
	table += "<tr align = center>";
	table += "<td>";
	table += "Select";
	table +="</td>";
	table += "<td>";
	table += "<b>Job ID";
	table +="</td>";
	table += "<td>";
	table += "<b>Job Title";
	table +="</td>";
	table += "<td>";
	table += "<b>Job Description";
	table +="</td>";
	table += "<td>";
	table += "<b>Post Skill";
	table +="</td>";
	table += "<td>";
	table += "<b>Experience";
	table +="</td>";
	table += "<td>";
	table += "<b>Job Salary";
	table +="</td>";
	table += "<td>";
	table += "<b>Job Location";
	table +="</td>";
	table += "<td>";
	table += "<b>Company name";
	table +="</td>";
	table += "<td>";
	//table += "<b>Positions available";
	//table +="</td>";
	//table += "<td>";
	//table += "<b>Account Type";
	//table +="</td>";
	//table += "<td>";
	table += "<b>Contact Person";
	table +="</td>";
	table += "<td>";
	//table += "<b>Profile ID";
	//table +="</td>";
	//table += "<td>";
	table += "<b>Post Date";
	table +="</td>";
	
	try {
		while(resultset.next()){
			Job job = new Job();
			job.setJob_Id(resultset.getInt("Job_ID"));
			job.setJob_Title(resultset.getString("job_Title"));
			job.setJob_description(resultset.getString("job_description"));
			job.setJob_skill(resultset.getString("job_skills"));
			job.setExperience(resultset.getInt("experience"));
			job.setJob_salary(resultset.getInt("job_salary"));
			job.setJob_location(resultset.getString("job_location"));
			job.setCompany_name(resultset.getString("company_Name"));
	     	//job.setPositions_Available(resultset.getInt("Positions_Available"));
			//job.setAccount_Type(resultset.getString("Account_Type"));
			job.setContact_Person(resultset.getString("contact_Person"));
	     	//job.setProfile_ID(resultset.getInt("Profile_ID"));
			job.setPost_date(resultset.getString("Date_Posted"));
			
			System.out.println("jobid:"+resultset.getString("job_Id")+"jobtitle:"+resultset.getString("job_Title"));
					   
			table += "<tr align = center>";
			table += "<td>";			
			table += "<input type= checkbox name = check value = "+job.getJob_Id()+">";
			table +="</td>";
			table += "<td>";
			table += job.getJob_Id();
			table +="</td>";
			table += "<td>";
			table += job.getJob_Title();			
			table +="</td>";
			table += "<td>";
			table += job.getJob_description();			
			table +="</td>";
			table += "<td>";
			table += job.getJob_skill();			
			table +="</td>";
			table += "<td>";
			table += job.getExperience();			
			table +="</td>";
			table += "<td>";
			table += job.getJob_salary();
			table +="</td>";
			table += "<td>";
			table += job.getJob_location();			
			table +="</td>";
			table += "<td>";
			table += job.getCompany_name();			
			table +="</td>";
			table += "<td>";
			//table += job.getPositions_Available();
			//table +="</td>";
			//table += "<td>";
			//table += job.getAccount_Type();			
			//table +="</td>";
			//table += "<td>";
			table += job.getContact_Person();			
			table +="</td>";
			table += "<td>";
			//table += job.getProfile_ID();			
			//table +="</td>";
			//table += "<td>";
			table += job.getPost_date();			
			table +="</td>";
			
		}
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	table += "</table>";
	
	return (table);
	
	
	
}

}
