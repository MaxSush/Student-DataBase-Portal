package com.webapp5.Studentservice;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.webapp5.Studententity.StudentEntity;
import com.webapp5.Studentpayload.RegistrationDto;
import com.webapp5.Studentpayload.StudentDto;

public interface StudentDetailsService {

	void createRegistration(RegistrationDto dto);

	List<StudentDto> getRegistrationByUsn(String usn);

	StudentDto getRegistrationById(long id);

	StudentDto updateStudent(StudentDto studentDto);

	Optional<StudentDto> getStudentByUsnAndSem(StudentDto studentDto);

	List<StudentDto> getByUsnAndSem(String usn,String sem);

	StudentDto findById(long id);
	
	StudentDto createStudent(StudentDto studentDto);

	

	

	
	

	
	
	

}
