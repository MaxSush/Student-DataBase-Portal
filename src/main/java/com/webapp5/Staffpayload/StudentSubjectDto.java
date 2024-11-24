package com.webapp5.Staffpayload;

import java.util.List;

import com.webapp5.Staffentity.Subjects;
import com.webapp5.Studententity.StudentEntity;

public class StudentSubjectDto {
	
	private List<StudentEntity> students;
	
	private List<Subjects> subjects;

	public List<StudentEntity> getStudents() {
		return students;
	}

	public void setStudents(List<StudentEntity> students) {
		this.students = students;
	}

	public List<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}
	
	
	
	

}
