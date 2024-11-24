package com.webapp5.Staffservice;

import java.util.List;

import com.webapp5.Staffpayload.ExamResultDto;

public interface ExamResultService {

	boolean existByStudentUsnAndSubjectNameAndSubjectCodeAndExamType(String studentUsn, String subjectName, String subjectCode,
			String examType);

	void addResult(ExamResultDto examResultDto);

	List<ExamResultDto> getResultsByDepartmentAndSemAndExamTypeAndScheme(String department, String sem, String examType,
			String scheme);

	List<ExamResultDto> getResultByStudentUsnAndDepartmentAndSchemeAndExamType(String studentUsn, String department, String scheme,String examType);

}
