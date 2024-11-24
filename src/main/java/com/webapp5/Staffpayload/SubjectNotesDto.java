package com.webapp5.Staffpayload;

import org.springframework.web.multipart.MultipartFile;

public class SubjectNotesDto {
	private long id;
	private String fileName;
	private String subjectName;
	private String subjectCode;
	private String type;
	private MultipartFile sujectNotesFile;
	private byte[] notesData;
	
	
	public byte[] getNotesData() {
		return notesData;
	}
	public void setNotesData(byte[] notesData) {
		this.notesData = notesData;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public MultipartFile getSujectNotesFile() {
		return sujectNotesFile;
	}
	public void setSujectNotesFile(MultipartFile sujectNotesFile) {
		this.sujectNotesFile = sujectNotesFile;
	}
	
	
	
}
