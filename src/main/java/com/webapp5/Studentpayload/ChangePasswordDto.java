package com.webapp5.Studentpayload;

public class ChangePasswordDto {

	private long id;
	private long regid;
	private String newPassword;
	private String oldPassword;
	private String confirmPassword;
	private long adminRegId;
	private String usn;
	private long adminId;
	
	
	public long getAdminId() {
		return adminId;
	}
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}
	public long getAdminRegId() {
		return adminRegId;
	}
	public void setAdminRegId(long adminRegId) {
		this.adminRegId = adminRegId;
	}
	public String getUsn() {
		return usn;
	}
	public void setUsn(String usn) {
		this.usn = usn;
	}
	private long staffregid;
	
	
	
	
	public long getStaffregid() {
		return staffregid;
	}
	public void setStaffregid(long staffregid) {
		this.staffregid = staffregid;
	}
	public long getRegid() {
		return regid;
	}
	public void setRegid(long regid) {
		this.regid = regid;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
}
