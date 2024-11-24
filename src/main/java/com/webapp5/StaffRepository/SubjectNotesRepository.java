package com.webapp5.StaffRepository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.webapp5.Staffentity.SubjectNotes;


public interface SubjectNotesRepository extends JpaRepository<SubjectNotes, Long> {
	   
	
	List<SubjectNotes> findIdAndSubjectCodeAndSubjectNameAndFileNameBySubjectCode(String subjectCode);	
	
	
	SubjectNotes findFirstByFileName(String fileName);

}
