/**
 * 
 */
package job;

/**
 * @author Goudamy
 *
 */
public class Job {

private int job_Id;
private String job_Title;
private String job_description;
private float job_salary;
private String job_location;
private String company_name;
private int Positions_Available;
private String Account_Type;
private String contact_Person;
private int Profile_ID;
private String post_date;
private String job_skill;
private float experience;
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Job [job_Id=" + job_Id + ", job_Title=" + job_Title
			+ ", job_description=" + job_description + ", job_salary="
			+ job_salary + ", job_location=" + job_location + ", company_name="
			+ company_name + ", Positions_Available=" + Positions_Available
			+ ", Account_Type=" + Account_Type + ", contact_Person="
			+ contact_Person + ", Profile_ID=" + Profile_ID + ", post_date="
			+ post_date + ", job_skill=" + job_skill + ", experience="
			+ experience + "]";
}
/**
 * @return the job_skill
 */
public String getJob_skill() {
	return job_skill;
}
/**
 * @param job_skill the job_skill to set
 */
public void setJob_skill(String job_skill) {
	this.job_skill = job_skill;
}
/**
 * @return the experience
 */
public float getExperience() {
	return experience;
}
/**
 * @param experience the experience to set
 */
public void setExperience(float experience) {
	this.experience = experience;
}
/**
 * @return the job_Id
 */
public int getJob_Id() {
	return job_Id;
}
/**
 * @param job_Id the job_Id to set
 */
public void setJob_Id(int job_Id) {
	this.job_Id = job_Id;
}
/**
 * @return the job_Title
 */
public String getJob_Title() {
	return job_Title;
}
/**
 * @param job_Title the job_Title to set
 */
public void setJob_Title(String job_Title) {
	this.job_Title = job_Title;
}
/**
 * @return the job_description
 */
public String getJob_description() {
	return job_description;
}
/**
 * @param job_description the job_description to set
 */
public void setJob_description(String job_description) {
	this.job_description = job_description;
}
/**
 * @return the job_salary
 */
public float getJob_salary() {
	return job_salary;
}
/**
 * @param job_salary the job_salary to set
 */
public void setJob_salary(float job_salary) {
	this.job_salary = job_salary;
}
/**
 * @return the job_location
 */
public String getJob_location() {
	return job_location;
}
/**
 * @param job_location the job_location to set
 */
public void setJob_location(String job_location) {
	this.job_location = job_location;
}
/**
 * @return the company_name
 */
public String getCompany_name() {
	return company_name;
}
/**
 * @param company_name the company_name to set
 */
public void setCompany_name(String company_name) {
	this.company_name = company_name;
}
/**
 * @return the positions_Available
 */
public int getPositions_Available() {
	return Positions_Available;
}
/**
 * @param positions_Available the positions_Available to set
 */
public void setPositions_Available(int positions_Available) {
	Positions_Available = positions_Available;
}
/**
 * @return the account_Type
 */
public String getAccount_Type() {
	return Account_Type;
}
/**
 * @param account_Type the account_Type to set
 */
public void setAccount_Type(String account_Type) {
	Account_Type = account_Type;
}
/**
 * @return the contact_Person
 */
public String getContact_Person() {
	return contact_Person;
}
/**
 * @param contact_Person the contact_Person to set
 */
public void setContact_Person(String contact_Person) {
	this.contact_Person = contact_Person;
}
/**
 * @return the profile_ID
 */
public int getProfile_ID() {
	return Profile_ID;
}
/**
 * @param profile_ID the profile_ID to set
 */
public void setProfile_ID(int profile_ID) {
	Profile_ID = profile_ID;
}
/**
 * @return the post_date
 */
public String getPost_date() {
	return post_date;
}
/**
 * @param post_date the post_date to set
 */
public void setPost_date(String post_date) {
	this.post_date = post_date;
}
/**
 * 
 */
public Job() {
	super();
}
/**
 * @param job_Id
 * @param job_Title
 * @param job_description
 * @param job_salary
 * @param job_location
 * @param company_name
 * @param positions_Available
 * @param account_Type
 * @param contact_Person
 * @param profile_ID
 * @param post_date
 * @param job_skill
 * @param experience
 */
public Job(int job_Id, String job_Title, String job_description,
		float job_salary, String job_location, String company_name,
		int positions_Available, String account_Type, String contact_Person,
		int profile_ID, String post_date, String job_skill, float experience) {
	super();
	this.job_Id = job_Id;
	this.job_Title = job_Title;
	this.job_description = job_description;
	this.job_salary = job_salary;
	this.job_location = job_location;
	this.company_name = company_name;
	Positions_Available = positions_Available;
	Account_Type = account_Type;
	this.contact_Person = contact_Person;
	Profile_ID = profile_ID;
	this.post_date = post_date;
	this.job_skill = job_skill;
	this.experience = experience;
}





}
