package com.webapp5.Studentservice;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.webapp5.Studententity.StudentEntity;
import com.webapp5.Studentpayload.RegistrationDto;
import com.webapp5.Studentpayload.StudentDto;

import com.webapp5.Studentrepository.StudentRepository;
import com.webapp5.exception.PasswordNotFoundException;

@Service
public class studentDetailsServiceImpl implements StudentDetailsService {

	@Autowired
	private StudentRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	
	@Override
	public void createRegistration(RegistrationDto dto) {
		
		StudentEntity student = mapToEntity(dto);
		
		repository.save(student);
		
	}
	
	@Override
	public StudentDto getRegistrationById(long id) {
		StudentEntity studentEntity = repository.findById(id).orElseThrow(
				()-> new PasswordNotFoundException("Wrong Password")
				);
		StudentDto studentDto = mapToDto(studentEntity);
		return studentDto;
		
	}
	@Override
	public StudentDto updateStudent(StudentDto studentDto) {
		StudentEntity mapToEntity = mapToEntity(studentDto);
		StudentEntity save = repository.save(mapToEntity);
		return mapToDto(save);
		
	}
	
	@Override
	public Optional<StudentDto> getStudentByUsnAndSem(StudentDto studentDto) {
		 Optional<StudentDto> byUsnAndSem = repository.findByUsnAndSem(studentDto.getUsn(), studentDto.getSem());
		return byUsnAndSem;
	}
	
	@Override
	public List<StudentDto> getRegistrationByUsn(String usn) {
		List<StudentEntity> data = repository.getByUsn(usn);
		
		return data.stream().map(d->mapToDto(d)).collect(Collectors.toList());
	}
	
	@Override
	public List<StudentDto> getByUsnAndSem(String usn, String sem) {
		List<StudentEntity> data = repository.getByUsnAndSem(usn, sem);
		return data.stream().map(d->mapToDto(d)).collect(Collectors.toList()); 
	}
	
	@Override
	public StudentDto findById(long id) {
		 StudentEntity studentEntity = repository.findById(id).get();
		return mapToDto(studentEntity);
	}
	
	@Override
	public StudentDto createStudent(StudentDto studentDto) {
		StudentEntity mapToEntity = mapToEntity(studentDto);
		StudentEntity save = repository.save(mapToEntity);
		StudentDto mapToDto = mapToDto(save);
		return mapToDto;
		
	}
	
	
	StudentEntity mapToEntity(RegistrationDto registrationDto){
		return modelMapper.map(registrationDto, StudentEntity.class);
	}
	
	StudentDto mapToDto(StudentEntity entity){
		return modelMapper.map(entity, StudentDto.class);
	}
	
	StudentEntity mapToEntity(StudentDto studentDto){
		return modelMapper.map(studentDto, StudentEntity.class);
	}

	

	

	

	

	
	
	
	
	
	
	
	

}
