package com.sjsu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sjsu.model.JobPost;
import com.sjsu.model.Job_Seeker;
import com.sjsu.util.DbUtil;
import com.sjsu.util.SendMail;

public class JobPostDao {

	private Connection connection;

	public JobPostDao() {
		connection = DbUtil.getConnection();
	}

	public void addJobPost(JobPost jobPost) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Job_Post(Employer_ID,job_Title,job_description,"
							+ "company_Name,job_location,Date_Posted,job_salary,contact_Person,Phone_Number) values (?, ?, ?, ?,?,?,?,?,? )");

			// Parameters start with 1
			preparedStatement.setInt(1, jobPost.getEmployer_ID());
			preparedStatement.setString(2, jobPost.getJob_Title());
			preparedStatement.setString(3, jobPost.getJob_description());
			preparedStatement.setString(4, jobPost.getCompany_Name());
			preparedStatement.setString(5, jobPost.getJob_location());

			preparedStatement.setDate(6,
					new java.sql.Date(System.currentTimeMillis()));
			preparedStatement.setInt(7, jobPost.getJob_salary());
			preparedStatement.setString(8, jobPost.getContact_Person());
			preparedStatement.setString(9, jobPost.getPhone_Number());
			preparedStatement.executeUpdate();

			PreparedStatement ps2 = connection
					.prepareStatement("select last_insert_id() as last_id from Job_Post");
			ResultSet rsx = ps2.executeQuery();
			int lastId = 0;
			if (rsx.next()) {
				lastId = Integer.parseInt(rsx.getString("last_id"));
			}

			List<String> skillSetsList = new ArrayList<String>();
			if (jobPost.getSkillsetsString() != null
					&& jobPost.getSkillsetsString().length() > 0) {
				skillSetsList = Arrays.asList(jobPost.getSkillsetsString()
						.split("\\s*,\\s*"));
			}

			for (String skill : skillSetsList) {
				PreparedStatement ps3 = connection
						.prepareStatement("insert into Job_Skills(Id, job_skills, experience) "
								+ " values (?, ?, ?)");
				ps3.setInt(1, lastId);
				ps3.setString(2, skill);
				ps3.setInt(3, jobPost.getExperience());
				ps3.executeUpdate();
				SendMail.sendMail(getJobSeekerEmailIDs(), jobPost.toString() + " has been added.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteJobPost(int job_id) {
		JobPost jb = getJobPostById(job_id);
		deleteSkillSetsByJobPostId(job_id);
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from Job_Post where Job_id=?");
			// Parameters start with 1
			preparedStatement.setInt(1, job_id);
			preparedStatement.executeUpdate();
			
		//	
			
			SendMail.sendMail(getJobSeekerEmailIDs(), jb.toString()  + " has been DELETED.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	


	public void updateJobPost(JobPost jobPost) {
		try {
			// PreparedStatement preparedStatement = connection
			// .prepareStatement("update users set firstname=?, lastname=?, dob=?, email=?"
			// +
			// "where userid=?");

			PreparedStatement preparedStatement = connection
					.prepareStatement("update Job_Post set Employer_ID=? ,job_Title=? , job_description=?, "
							+ "company_Name=? ,job_location= ?,Date_Posted= ?,job_salary= ?,contact_Person=? ,Phone_Number= ? where Job_id= ?");

			// Parameters start with 1
			preparedStatement.setInt(1, jobPost.getEmployer_ID());
			preparedStatement.setString(2, jobPost.getJob_Title());
			preparedStatement.setString(3, jobPost.getJob_description());
			preparedStatement.setString(4, jobPost.getCompany_Name());
			preparedStatement.setString(5, jobPost.getJob_location());

			preparedStatement.setDate(6,
					new java.sql.Date(System.currentTimeMillis()));
			preparedStatement.setInt(7, jobPost.getJob_salary());
			preparedStatement.setString(8, jobPost.getContact_Person());
			preparedStatement.setString(9, jobPost.getPhone_Number());

			preparedStatement.setInt(10, jobPost.getJob_ID());

			preparedStatement.executeUpdate();
			
			deleteSkillSetsByJobPostId(jobPost.getJob_ID());
			List<String> skillSetsList = new ArrayList<String>();
			if (jobPost.getSkillsetsString() != null
					&& jobPost.getSkillsetsString().length() > 0) {
				skillSetsList = Arrays.asList(jobPost.getSkillsetsString()
						.split("\\s*,\\s*"));
			}

			for (String skill : skillSetsList) {
				PreparedStatement ps3 = connection
						.prepareStatement("insert into Job_Skills(Id, job_skills, experience) "
								+ " values (?, ?, ?)");
				ps3.setInt(1, jobPost.getJob_ID());
				ps3.setString(2, skill);
				ps3.setInt(3, jobPost.getExperience());
				ps3.executeUpdate();
			}
			
			SendMail.sendMail(getJobSeekerEmailIDs(), jobPost.toString() + " has been edited/updated.");
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public List<Job_Seeker> getJobSeekersListByJobId(int JobId) {
		List<Job_Seeker> jsList = new ArrayList<Job_Seeker>();
		try {
			PreparedStatement ps = connection
					.prepareStatement("select * from job_seeker_profile where id in (select jobseeker_id from job_applied where job_id = ?)");
			ps.setInt(1, JobId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Job_Seeker js = new Job_Seeker();
				js.setId(rs.getInt("ID"));
				js.setfName(rs.getString("fName"));
				js.setlName(rs.getString("lName"));
				js.setmInit(rs.getString("mInit"));
				js.setDob(rs.getDate("Date_Of_Birth"));
				js.setCity(rs.getString("city"));
				js.setState(rs.getString("state"));
				js.setZipcode(rs.getString("zipcode"));
				js.setCountry((rs.getString("Country")));
				js.setPhone_Cell(rs.getString("Phone_Cell"));
				js.setPhone_Home(rs.getString("Phone_Home"));
				js.setPhone_Work(rs.getString("Phone_Work"));
				js.setMy_Resume(rs.getString("My_Resume"));
				js.setSalary(rs.getInt("Salary"));
				js.setDesired_Position(rs.getString("Desired_Position"));
				js.setWilling_to_Relocate(rs.getString("Willing_to_Relocate"));
				jsList.add(js);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsList;
	}
	
	
	public List<JobPost> getJobPostsForEmployer(int employerId) {
		List<JobPost> jobPostList = new ArrayList<JobPost>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from Job_Post where Employer_Id = ?");
			preparedStatement.setInt(1, employerId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				JobPost jp = new JobPost();
				jp.setJob_ID(rs.getInt("Job_ID"));
				jp.setEmployer_ID(rs.getInt("Employer_ID"));
				jp.setJob_Title(rs.getString("job_Title"));
				jp.setJob_description(rs.getString("job_description"));
				jp.setCompany_Name(rs.getString("company_Name"));
				jp.setJob_location(rs.getString("job_location"));

				jp.setDate_Posted(rs.getDate("Date_Posted"));
				jp.setJob_salary(rs.getInt("job_salary"));
				jp.setContact_Person(rs.getString("contact_Person"));
				jp.setPhone_Number(rs.getString("Phone_Number"));
				updateSkillSetsForJobPost(jp);
				jobPostList.add(jp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return jobPostList;
	}

	public JobPost updateSkillSetsForJobPost(JobPost jobPost) {

		PreparedStatement ps2;
		try {
			ps2 = connection
					.prepareStatement("select * from Job_Skills where id=?");
			ps2.setInt(1, jobPost.getJob_ID());
			ResultSet rs2 = ps2.executeQuery();
			String skillSetsString = new String();
			int experience = 0;
			while (rs2.next()) {
				experience = rs2.getInt("experience");
				skillSetsString = skillSetsString + rs2.getString("job_skills");
				if (!rs2.isLast()) {
					skillSetsString = skillSetsString + ",";
				}

				jobPost.setExperience(experience);
				jobPost.setSkillsetsString(skillSetsString);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return jobPost;
	}

	public JobPost getJobPostById(int jobId) {
		JobPost jp = new JobPost();
		try {
			

			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from Job_Post where Job_Id=?");
			preparedStatement.setInt(1, jobId);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				jp.setEmployer_ID(rs.getInt("Employer_ID"));
				jp.setJob_ID(rs.getInt("Job_ID"));
				jp.setJob_Title(rs.getString("job_Title"));
				jp.setJob_description(rs.getString("job_description"));
				jp.setCompany_Name(rs.getString("company_Name"));
				jp.setJob_location(rs.getString("job_location"));

				jp.setDate_Posted(rs.getDate("Date_Posted"));
				jp.setJob_salary(rs.getInt("job_salary"));
				jp.setContact_Person(rs.getString("contact_Person"));
				jp.setPhone_Number(rs.getString("Phone_Number"));
				updateSkillSetsForJobPost(jp);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return jp;
	}
	
	private void deleteSkillSetsByJobPostId(int jobPostId) {
		
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from job_skills where id=?");
			// Parameters start with 1
			preparedStatement.setInt(1, jobPostId);
			preparedStatement.executeUpdate();
			
			//SendMail.sendMail(getJobSeekerEmailIDs(), jb.toString()  + " has been DELETED.");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public ArrayList<String> getJobSeekerEmailIDs() {

		ArrayList<String> toList = new ArrayList<String>();
		try {
			PreparedStatement ps2 = connection
					.prepareStatement("select email from job_seeker_signup;");

			ResultSet rs2 = ps2.executeQuery();
			while (rs2.next()) {
				String emailID = rs2.getString("email");
				toList.add(emailID);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return toList;

	}
}