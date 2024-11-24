package com.webapp5.Staffservice;

import java.util.List;

import com.webapp5.Staffpayload.SubjectsDto;

public interface SubjectService {

	SubjectsDto addSubject(SubjectsDto subjectsDto);

	List<SubjectsDto> getAllSubjects(SubjectsDto subjectsDto);

	boolean existsBySubjectNameAndCode(String subjectName, String SubjectCode);

	List<SubjectsDto> findAllByDepartmentAndSchemeOrderBySem(String department,String scheme);

	SubjectsDto findBySubId(long subid);

	void updateSubject(SubjectsDto subjectsDto);

	void deleteById(long subid);
	
	List<SubjectsDto> getAllSubjectsByDepartment(String department);

	List<SubjectsDto> findSubjectByDepartmentAndSemAndScheme(String department, String sem,String scheme);

}
