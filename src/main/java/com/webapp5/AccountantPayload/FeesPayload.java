package com.webapp5.AccountantPayload;

import org.springframework.web.multipart.MultipartFile;

public class FeesPayload {

	private long feesId;
	private String recieptId;
	private String studentUsn;
	private String department;
	private String studentname;
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	private String year;
	private String sem;
	private int feesAmount;
	private String date;
	private MultipartFile feesImageData;
	public long getFeesId() {
		return feesId;
	}
	public void setFeesId(long feesId) {
		this.feesId = feesId;
	}
	public String getRecieptId() {
		return recieptId;
	}
	public void setRecieptId(String recieptId) {
		this.recieptId = recieptId;
	}
	public String getStudentUsn() {
		return studentUsn;
	}
	public void setStudentUsn(String studentUsn) {
		this.studentUsn = studentUsn;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getSem() {
		return sem;
	}
	public void setSem(String sem) {
		this.sem = sem;
	}
	public int getFeesAmount() {
		return feesAmount;
	}
	public void setFeesAmount(int feesAmount) {
		this.feesAmount = feesAmount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public MultipartFile getFeesImageData() {
		return feesImageData;
	}
	public void setFeesImageData(MultipartFile feesImageData) {
		this.feesImageData = feesImageData;
	}
	
	
	
}
