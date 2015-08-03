package com.sjsu.util;

import java.util.LinkedList;
import java.util.List;

import com.sjsu.model.Job_Seeker;
import com.sjsu.model.Jobs;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;



public class DBAgent implements IDBAgent {

	  private Connection connect = null;
	  private Statement statement = null;
	  private ResultSet resultSet = null;

	
	  /**
	   * select * from Job_Post jp, job_skills js, job_seeker_skills jss
where date_posted = current_date
and jp.job_id = js.id
and js.job_skills = jss.js_skills
and js.experience <= jss.js_experience
	   */
	  
	  
	public DBAgent() {
		
	}

	@Override
	public LinkedList<Jobs> getJobs() {

		LinkedList<Jobs> ll = new LinkedList<Jobs>();
	
		
		
		try{
		      Class.forName("com.mysql.jdbc.Driver");
		      connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?"+ "user=root&password=root");
		      statement = connect.createStatement();
		      resultSet = statement.executeQuery("select * from Job_Post where date_posted = current_date");
		      while(resultSet.next())
		      {
		    	  Jobs j = new Jobs();
		    	  j.setCompany_Name(resultSet.getString("company_Name"));
		    	  j.setContact_Person(resultSet.getString("contact_person"));
		    	  j.setEmployer_ID(resultSet.getInt("Employer_ID") );
		    	  j.setJob_description( resultSet.getString("job_description"));
		    	  j.setJob_ID( resultSet.getInt( "Job_ID"));
		    	  j.setJob_location( resultSet.getString("Job_location"));
		    	  j.setJob_salary( resultSet.getString("Job_salary"));
		    	  j.setJob_Title( resultSet.getString("Job_Title"));
		    	  j.setPhone_Number( resultSet.getString("phone_number"));
		    	  ll.add(j);
		    	  
		      }

		      
		      
		    } catch (Exception e) {
		      e.printStackTrace(System.out);
		    } finally {
		      close();
		    }

		return ll;
		
	}

/*	
	select * from Job_Post jp, job_skills js, job_seeker_skills jss, job_seeker_signup jsi
	where jp.job_id = 10001
	and jp.job_id = js.id
	and js.job_skills = jss.js_skills
	and js.experience <= jss.js_experience
	and js_id = jobseeker_ID

	*/
	public LinkedList<Job_Seeker> getCandidates(int jobid) {

		LinkedList<Job_Seeker> ll = new LinkedList<Job_Seeker>();
	
		
		
		try{
		      Class.forName("com.mysql.jdbc.Driver");
		      connect = DbUtil.getConnection();
		      statement = connect.createStatement();
		      resultSet = statement.executeQuery("select * from Job_Post jp, job_skills js, job_seeker_skills jss, job_seeker_signup jsi where jp.job_id = "+jobid + " and jp.job_id = js.id and js.job_skills = jss.js_skills and js.experience <= jss.js_experience and js_id = jobseeker_ID ");
		      while(resultSet.next())
		      {
		    	  Job_Seeker js = new Job_Seeker();
		    	 // js.setJobSeeker_ID(resultSet.getInt("jobseeker_ID"));
		    	 // js.setEmail(resultSet.getString("email"));
		    	 // js.setAccount_Type(resultSet.getString("account_type"));
		    	  ll.add(js);		    	  
		      }
		    } catch (Exception e) {
		      e.printStackTrace(System.out);
		    } finally {
		      close();
		    }

		return ll;
	}

	// you need to close all three to make sure
	  private void close() {
	    
	    try {
	    	resultSet.close();
	    	statement.close();
		    connect.close();
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
			
			
		}
		
		
		

	}


