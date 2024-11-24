package com.webapp5.StaffRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp5.Staffentity.Subjects;

public interface SubjectRepository extends JpaRepository<Subjects, Long>{
	
	List<Subjects> getAllSubjectsByDepartmentAndSem(String department,String sem);
	
	boolean  existsBySubjectNameAndSubjectCode(String subjectName, String SubjectCode);

	List<Subjects>  findAllByDepartmentAndSchemeOrderBySem(String department,String scheme);

	List<Subjects> findOnlyByDepartmentAndSemAndScheme(String department, String sem,String Scheme);

	List<Subjects> findAllByDepartment(String department);

	

}
