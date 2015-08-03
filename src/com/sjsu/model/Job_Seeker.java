package com.sjsu.model;

import java.io.Serializable;
import java.sql.Date;


/**
 * The persistent class for the Job_Seeker_SignUp database table.
 * 
 */
public class Job_Seeker implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	 int id;
	 String fName;
	 String lName;
	 String mInit;
	 Date dob;
	 String city;
	 String state;
	 String zipcode;
	 String country;
	 String phone_Cell;
	 String phone_Home;
	 String phone_Work;
	 String my_Resume;
	 int salary;
	 String desired_Position;
	 String willing_to_Relocate;
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getmInit() {
		return mInit;
	}
	public void setmInit(String mInit) {
		this.mInit = mInit;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone_Cell() {
		return phone_Cell;
	}
	public void setPhone_Cell(String phone_Cell) {
		this.phone_Cell = phone_Cell;
	}
	public String getPhone_Home() {
		return phone_Home;
	}
	public void setPhone_Home(String phone_Home) {
		this.phone_Home = phone_Home;
	}
	public String getPhone_Work() {
		return phone_Work;
	}
	public void setPhone_Work(String phone_Work) {
		this.phone_Work = phone_Work;
	}
	public String getMy_Resume() {
		return my_Resume;
	}
	public void setMy_Resume(String my_Resume) {
		this.my_Resume = my_Resume;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDesired_Position() {
		return desired_Position;
	}
	public void setDesired_Position(String desired_Position) {
		this.desired_Position = desired_Position;
	}
	public String getWilling_to_Relocate() {
		return willing_to_Relocate;
	}
	public void setWilling_to_Relocate(String willing_to_Relocate) {
		this.willing_to_Relocate = willing_to_Relocate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Job_Seeker [fName=" + fName + ", lName=" + lName + ", mInit="
				+ mInit + ", dob=" + dob + ", city=" + city + ", state="
				+ state + ", zipcode=" + zipcode + ", country=" + country
				+ ", phone_Cell=" + phone_Cell + ", phone_Home=" + phone_Home
				+ ", phone_Work=" + phone_Work + ", my_Resume=" + my_Resume
				+ ", salary=" + salary + ", desired_Position="
				+ desired_Position + ", willing_to_Relocate="
				+ willing_to_Relocate + "]";
	}


  

	

}