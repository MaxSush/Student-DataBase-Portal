package com.webapp5.Staffpayload;

public class StaffRegistrationDto {
	
	private long staff_regid;
	private String usn;
	private String password;
	private String department;
	private String email;
	private String mobile;
	
	
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	

}
