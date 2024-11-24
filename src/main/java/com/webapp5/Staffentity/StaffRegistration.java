package com.webapp5.Staffentity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StaffRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long staff_regid;
	private String usn;
	private String email;
	private String firstName;
	private String lastName;
	private String mobile;
	private String password;
	
	
	
	public long getStaff_regid() {
		return staff_regid;
	}
	public void setStaff_regid(long staff_regid) {
		this.staff_regid = staff_regid;
	}
	public String getUsn() {
		return usn;
	}
	public void setUsn(String usn) {
		this.usn = usn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
