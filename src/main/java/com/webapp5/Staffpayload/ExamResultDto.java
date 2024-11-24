package com.webapp5.Staffpayload;

public class ExamResultDto {

	private long id;
	private String sem;
	private String studentUsn;
	private String subjectName;
	private String subjectCode;
	private String examType;
	private String maxMarks;
	private String obtainedMarks;
	private String department;
	private String scheme;
	private String FirstIA;
	private String SecondIA;
	private String ThirdIA;
	public String getFirstIA() {
		return FirstIA;
	}
	public void setFirstIA(String firstIA) {
		FirstIA = firstIA;
	}
	public String getSecondIA() {
		return SecondIA;
	}
	public void setSecondIA(String secondIA) {
		SecondIA = secondIA;
	}
	public String getThirdIA() {
		return ThirdIA;
	}
	public void setThirdIA(String thirdIA) {
		ThirdIA = thirdIA;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSem() {
		return sem;
	}
	public void setSem(String sem) {
		this.sem = sem;
	}
	
	public String getStudentUsn() {
		return studentUsn;
	}
	public void setStudentUsn(String studentUsn) {
		this.studentUsn = studentUsn;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getExamType() {
		return examType;
	}
	public void setExamType(String examType) {
		this.examType = examType;
	}
	public String getMaxMarks() {
		return maxMarks;
	}
	public void setMaxMarks(String maxMarks) {
		this.maxMarks = maxMarks;
	}
	public String getObtainedMarks() {
		return obtainedMarks;
	}
	public void setObtainedMarks(String obtainedMarks) {
		this.obtainedMarks = obtainedMarks;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getScheme() {
		return scheme;
	}
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}
	
	
	
}
