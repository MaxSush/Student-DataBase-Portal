package com.webapp5.AdminService;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp5.Studententity.StudentEntity;
import com.webapp5.Studentpayload.StudentDto;
import com.webapp5.Studentrepository.StudentRepository;

@Service
public class ExportService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	 public ByteArrayInputStream load(String filterBy,String filter) {
		 
		 if(filterBy.equalsIgnoreCase("department")) {
			 List<StudentEntity> all = studentRepository.findAllByDepartment(filter);
			 List<StudentDto> collect = all.stream().map(a->mapToDto(a)).collect(Collectors.toList());
			 return ExcelService.studentToExcel(collect);
		 }else if(filter.equalsIgnoreCase("category")) {
			 List<StudentEntity> all = studentRepository.findByCategory(filterBy);
			 List<StudentDto> collect = all.stream().map(a->mapToDto(a)).collect(Collectors.toList());

		        return ExcelService.studentToExcel(collect);
		 }
		return null;
		 
		
	    }
	
	 StudentDto mapToDto(StudentEntity entity){
		return modelMapper.map(entity,StudentDto.class);
	}
}
