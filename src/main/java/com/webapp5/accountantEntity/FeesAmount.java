package com.webapp5.accountantEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class FeesAmount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long feesId;
	private String recieptId;
	private String studentUsn;
	private String department;
	private String year;
	private String sem;
	private int feesAmount;
	private String date;
	
	@Lob
	private byte[] feesReciptimg;

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

	public byte[] getFeesReciptimg() {
		return feesReciptimg;
	}

	public void setFeesReciptimg(byte[] feesReciptimg) {
		this.feesReciptimg = feesReciptimg;
	}
	
}
