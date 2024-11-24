package com.webapp5.Staffservice;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp5.StaffRepository.ExamResultRepository;
import com.webapp5.Staffentity.ExamResult;
import com.webapp5.Staffpayload.ExamResultDto;

@Service
public class ExamResultServiceImpl implements ExamResultService {

	@Autowired
	private ExamResultRepository examResultRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public boolean existByStudentUsnAndSubjectNameAndSubjectCodeAndExamType(String studentUsn, String subjectName, String subjectCode,
			String examType) {
		boolean status = examResultRepository.existsByStudentUsnAndSubjectNameAndSubjectCodeAndExamType(studentUsn,subjectName,subjectCode,examType);
		return status;
	}
	@Override
	public void addResult(ExamResultDto examResultDto) {
		ExamResult mapToEntity = mapToEntity(examResultDto);
		examResultRepository.save(mapToEntity);
	}
	
	@Override
	public List<ExamResultDto> getResultsByDepartmentAndSemAndExamTypeAndScheme(String department, String sem,
			String examType, String scheme) {
		List<ExamResult> results = examResultRepository.getResultsByDepartmentAndSemAndExamTypeAndScheme(department,sem,examType,scheme);
		
		
		return results.stream().map(r->mapToDto(r)).collect(Collectors.toList());
	}
	
	@Override
	public List<ExamResultDto> getResultByStudentUsnAndDepartmentAndSchemeAndExamType(String studentUsn, String department,
			String scheme,String examType) {
		List<ExamResult> result = examResultRepository.getResultsByStudentUsnAndDepartmentAndSchemeAndExamTypeOrderBySem(studentUsn,department,scheme,examType);
		 return result.stream().map(r->mapToDto(r)).collect(Collectors.toList());
	}

	ExamResult mapToEntity(ExamResultDto dto){
		return modelMapper.map(dto, ExamResult.class);
	}
	
	ExamResultDto mapToDto(ExamResult dto){
		return modelMapper.map(dto, ExamResultDto.class);
	}
	
}
