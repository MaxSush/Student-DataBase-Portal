package com.webapp5.Staffservice;

import java.util.List;

import com.webapp5.Staffpayload.ExamDto;

public interface ExamService {

	void declareExam(ExamDto dto);

	List<ExamDto> getExam(String department, String sem,String Scheme);

	List<ExamDto> getAllExamsBYDepartmentAndSemAndExamType(String department, String sem, String examType,String scheme);

	boolean existsBySubjectNameAndCodeAndExamType(String subjectName, String subjectCode,String exapType);
	

}
