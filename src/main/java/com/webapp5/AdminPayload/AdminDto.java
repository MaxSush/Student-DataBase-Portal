package com.webapp5.AdminPayload;

import org.springframework.web.multipart.MultipartFile;

public class AdminDto {

	private long adminId;
	private String usn;
	private String firstName;
	private String lastName;
	private String email;
	private long mobile;
	private String department;
	private String gender;
	private String dob;
	private String joininDate;
	private String qualification;
	private String experience;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	private String password;
	private long adminImgId;
	private MultipartFile adminImageData;
	
	
	
	
	
	public long getAdminImgId() {
		return adminImgId;
	}
	public void setAdminImgId(long adminImgId) {
		this.adminImgId = adminImgId;
	}
	public MultipartFile getAdminImageData() {
		return adminImageData;
	}
	public void setAdminImageData(MultipartFile adminImageData) {
		this.adminImageData = adminImageData;
	}
	public long getAdminId() {
		return adminId;
	}
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}
	public String getUsn() {
		return usn;
	}
	public void setUsn(String usn) {
		this.usn = usn;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getJoininDate() {
		return joininDate;
	}
	public void setJoininDate(String joininDate) {
		this.joininDate = joininDate;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
