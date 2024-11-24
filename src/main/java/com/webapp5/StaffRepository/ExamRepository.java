package com.webapp5.StaffRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp5.Staffentity.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {

	List<Exam> findExamByDepartmentAndSemAndScheme(String department, String sem,String scheme);

	List<Exam> getAllByDepartmentAndSemAndExamTypeAndScheme(String department, String sem, String examType,String scheme);

	boolean existsBySubjectNameAndSubjectCodeAndExamType(String subjectName, String subjectCode,String examType);

}
