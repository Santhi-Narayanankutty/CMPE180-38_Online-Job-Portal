package com.sjsu.model;
import java.sql.Date;

public class JobPost {

	int Employer_ID;
	int job_ID;
	String job_Title;
	String job_description;
	String company_Name;
	String job_location;
	Date Date_Posted;
	int job_salary;
	String contact_Person;
	String phone_Number;
	int experience;
	String skillsetsString;

	
	@Override
	public String toString() {
		return "JobPost [ job_ID=" + job_ID
				+ ", job_Title=" + job_Title + ", job_description="
				+ job_description + ", company_Name=" + company_Name
				+ ", job_location=" + job_location + ", Date_Posted="
				+ Date_Posted + ", job_salary=" + job_salary
				+ ", contact_Person=" + contact_Person + ", phone_Number="
				+ phone_Number + ", experience=" + experience
				+ ", skillsetsString=" + skillsetsString + "]";
	}

	public int getEmployer_ID() {
		return Employer_ID;
	}

	public void setEmployer_ID(int employer_ID) {
		Employer_ID = employer_ID;
	}

	public int getJob_ID() {
		return job_ID;
	}

	public void setJob_ID(int jobID) {
		this.job_ID = jobID;
	}

	public String getJob_Title() {
		return job_Title;
	}

	public void setJob_Title(String job_Title) {
		this.job_Title = job_Title;
	}

	public String getJob_description() {
		return job_description;
	}

	public void setJob_description(String job_description) {
		this.job_description = job_description;
	}

	public String getCompany_Name() {
		return company_Name;
	}

	public void setCompany_Name(String company_Name) {
		this.company_Name = company_Name;
	}

	public String getJob_location() {
		return job_location;
	}

	public void setJob_location(String job_location) {
		this.job_location = job_location;
	}

	public Date getDate_Posted() {
		return Date_Posted;
	}

	public void setDate_Posted(Date date_Posted) {
		Date_Posted = date_Posted;
	}

	public int getJob_salary() {
		return job_salary;
	}

	public void setJob_salary(int job_salary) {
		this.job_salary = job_salary;
	}

	public String getContact_Person() {
		return contact_Person;
	}

	public void setContact_Person(String contact_Person) {
		this.contact_Person = contact_Person;
	}

	public String getPhone_Number() {
		return phone_Number;
	}

	public void setPhone_Number(String phoneNumber) {
		phone_Number = phoneNumber;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getSkillsetsString() {
		return skillsetsString;
	}

	public void setSkillsetsString(String skillsetsString) {
		this.skillsetsString = skillsetsString;
	}
	
	

}
