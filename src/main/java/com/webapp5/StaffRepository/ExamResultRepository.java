package com.webapp5.StaffRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp5.Staffentity.ExamResult;

public interface ExamResultRepository extends JpaRepository<ExamResult, Long>{

	boolean existsByStudentUsnAndSubjectNameAndSubjectCodeAndExamType(String studentUsn, String subjectName, String subjectCode,
			String examType);

	List<ExamResult> getResultsByDepartmentAndSemAndExamTypeAndScheme(String department, String sem, String examType,
			String scheme);

	List<ExamResult> getResultsByStudentUsnAndDepartmentAndSchemeAndExamTypeOrderBySem(String studentUsn, String department, String scheme,String examType);

	List<ExamResult> findByStudentUsn(String studentusn);

	List<ExamResult> getExamResultByStudentUsnAndExamTypeOrderBySem(String studentUsn, String examType);

	void deleteByStudentUsn(String studentusn);

	List<ExamResult> findAllBySemAndDepartmentAndScheme(String sem, String department, String scheme);

}
