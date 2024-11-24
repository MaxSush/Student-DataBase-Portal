package com.webapp5.Staffservice;

import java.util.List;


import org.springframework.web.multipart.MultipartFile;

import com.webapp5.Staffentity.SubjectNotes;



public interface NotesService {

	void uploadNotes(MultipartFile sujectNotesFile, String fileName, String subjectCode, String subjectName);

	
	List<SubjectNotes> getAllNotesBySubjectCode(String subjectCode);

	SubjectNotes findByFileName(String fileName);


	void deleteById(long notesid);

}
