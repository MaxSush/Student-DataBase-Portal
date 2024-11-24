package com.webapp5.Studententity;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Student_Details")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	private String usn;
	@Column(name="first_name",length = 30)
	private String firstName;
	@Column(name="last_name",length = 30)
	private String lastName;
	@Column(name="sem",length = 5)
	private String sem;
	@Column(name="dob",length = 10)
	private String dob;
	@Column(name="mobile",length = 10)
	private long mobile;
	@Column(name="gender",length = 10)
	private String gender;
	@Column(name="address",length = 120)
	private String address;
	@Column(name="blood_group",length = 5)
	private String blood_group;
	@Column(name="category",length = 10)
	private String category;
	@Column(name="department",length = 50)
	private String department;
	@Column(name="email",length = 120)
	private String email;
	@Column(name="religion",length = 120)
	private String religion;
	@Column(name="fatherName",length = 120)
	private String fatherName;
	@Column(name="motherName",length = 120)
	private String motherName;
	@Column(name="addharNumber",length = 12)
	private String addharNumber;
	@Column(name="domicile",length = 30)
	private String domicile;
	@Column(name="educationMedium",length = 30)
	private String educationMedium;
	@Column(name="schooler",length = 30)
	private String schooler;
	@Column(name="admissionYear",length = 10)
	private String admissionYear;
	@Column(name="income",length = 30)
	private String income;
	@Column(name="nationality",length = 30)
	private String nationality;
	@Column(name="town",length = 30)
	private String town;
	@Column(name="taluka",length = 30)
	private String taluka;
	@Column(name="state",length = 30)
	private String state;
	
	@Column(name="password",length = 30)
	private String password;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;
	
	
	 public StudentEntity() {
	        this.createdAt = new Date(); // Initialize createdAt with current date and time
	    }
	
	
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsn() {
		return usn.trim();
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
	public String getSem() {
		return sem;
	}
	public void setSem(String sem) {
		this.sem = sem;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBlood_group() {
		return blood_group;
	}
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getAddharNumber() {
		return addharNumber;
	}
	public void setAddharNumber(String addharNumber) {
		this.addharNumber = addharNumber;
	}
	public String getDomicile() {
		return domicile;
	}
	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}
	public String getEducationMedium() {
		return educationMedium;
	}
	public void setEducationMedium(String educationMedium) {
		this.educationMedium = educationMedium;
	}
	public String getSchooler() {
		return schooler;
	}
	public void setSchooler(String schooler) {
		this.schooler = schooler;
	}
	public String getAdmissionYear() {
		return admissionYear;
	}
	public void setAdmissionYear(String admissionYear) {
		this.admissionYear = admissionYear;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getTaluka() {
		return taluka;
	}
	public void setTaluka(String taluka) {
		this.taluka = taluka;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
