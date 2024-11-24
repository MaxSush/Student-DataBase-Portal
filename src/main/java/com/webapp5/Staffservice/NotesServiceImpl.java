package com.webapp5.Staffservice;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.webapp5.StaffRepository.SubjectNotesRepository;
import com.webapp5.Staffentity.SubjectNotes;
import com.webapp5.Staffpayload.SubjectNotesDto;
import com.webapp5.Studentpayload.StudentDto;

@Service
public class NotesServiceImpl implements NotesService {

	@Autowired
	private SubjectNotesRepository notesRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public void uploadNotes(MultipartFile sujectNotesFile, String fileName, String subjectCode, String subjectName) {
		
		try {
			
			SubjectNotes subjectNotes=new SubjectNotes();
			byte[] bytes = sujectNotesFile.getBytes();
			subjectNotes.setNotesData(bytes);
			subjectNotes.setSubjectCode(subjectCode);
			subjectNotes.setSubjectName(subjectName);
			subjectNotes.setFileName(sujectNotesFile.getOriginalFilename());
			subjectNotes.setType(sujectNotesFile.getContentType());
			notesRepository.save(subjectNotes);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public List<SubjectNotes> getAllNotesBySubjectCode(String subjectCode) {
		List<SubjectNotes> allBySubjectCode = notesRepository.findIdAndSubjectCodeAndSubjectNameAndFileNameBySubjectCode(subjectCode);
		
		return allBySubjectCode;
		
	}
	
	@Override
	public SubjectNotes findByFileName(String fileName) {
		SubjectNotes byFileName = notesRepository.findFirstByFileName(fileName);
		return byFileName;
	}
	

	SubjectNotesDto mapToDto(SubjectNotes notes){
		return modelMapper.map(notes, SubjectNotesDto.class);
	}


	@Override
	public void deleteById(long notesid) {
		notesRepository.deleteById(notesid);
		
	}


	
}
