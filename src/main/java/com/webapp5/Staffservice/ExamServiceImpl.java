package com.webapp5.Staffservice;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp5.StaffRepository.ExamRepository;
import com.webapp5.Staffentity.Exam;
import com.webapp5.Staffpayload.ExamDto;

@Service
public class ExamServiceImpl implements ExamService {
	
	@Autowired
	private ExamRepository examRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public void declareExam(ExamDto dto) {
		Exam mapToEntity = mapToEntity(dto);
		examRepository.save(mapToEntity);
		
	}
	
	@Override
	public List<ExamDto> getExam(String department, String sem,String scheme) {
		List<Exam> examByDepartmentAndSem = examRepository.findExamByDepartmentAndSemAndScheme( department,  sem,scheme);
		List<ExamDto> collect = examByDepartmentAndSem.stream().map(e->mapToDto(e)).collect(Collectors.toList());
		return collect;
	}
	
	@Override
	public List<ExamDto> getAllExamsBYDepartmentAndSemAndExamType(String department, String sem, String examType,String scheme) {
		List<Exam> exams = examRepository.getAllByDepartmentAndSemAndExamTypeAndScheme(department,sem,examType,scheme);
		return exams.stream().map(e->mapToDto(e)).collect(Collectors.toList());
	}
	@Override
	public boolean existsBySubjectNameAndCodeAndExamType(String subjectName, String subjectCode,String examType) {
		boolean existsBySubjectNameAndSubjectCode = examRepository.existsBySubjectNameAndSubjectCodeAndExamType(subjectName,subjectCode,examType);
		return existsBySubjectNameAndSubjectCode;
	}
	
	Exam mapToEntity(ExamDto dto) {
		return modelMapper.map(dto, Exam.class);
	}
	
	ExamDto mapToDto(Exam exam) {
		return modelMapper.map(exam, ExamDto.class);
	}

	

	

	

	

}
