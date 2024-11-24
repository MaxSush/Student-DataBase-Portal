package com.webapp5.Studentpayload;

public class LoginDto {

	private String usn;
	private String password;
	private String user;
	
	
	public String getUsn() {
		return usn.trim();
	}
	public void setUsn(String usn) {
		this.usn = usn;
	}
	public String getPassword() {
		return password.trim();
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	
}
