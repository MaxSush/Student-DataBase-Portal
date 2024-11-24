package com.webapp5.Staffservice;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.webapp5.StaffRepository.SubjectRepository;
import com.webapp5.Staffentity.Subjects;
import com.webapp5.Staffpayload.SubjectsDto;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public SubjectsDto addSubject(SubjectsDto subjectsDto) {
		Subjects mapToEntity = mapToEntity(subjectsDto);
		Subjects save = subjectRepository.save(mapToEntity);
		SubjectsDto mapToDto = mapToDto(save);
		return mapToDto;
	}
	

	@Override
	public List<SubjectsDto> getAllSubjects(SubjectsDto subjectsDto) {
		List<Subjects> subjects = subjectRepository.getAllSubjectsByDepartmentAndSem(subjectsDto.getDepartment(), subjectsDto.getSem());
		List<SubjectsDto> collect = subjects.stream().map(s->mapToDto(s)).collect(Collectors.toList());
		return collect;
	}
	
	@Override
	public boolean existsBySubjectNameAndCode(String subjectName, String SubjectCode) {
		boolean subject = subjectRepository.existsBySubjectNameAndSubjectCode(subjectName, SubjectCode);
		
		return subject;
	}
	
	@Override
	public List<SubjectsDto> findAllByDepartmentAndSchemeOrderBySem(String department,String scheme) {
		
		
		List<Subjects> subject = subjectRepository.findAllByDepartmentAndSchemeOrderBySem(department,scheme);
		List<SubjectsDto> collect = subject.stream().map(s->mapToDto(s)).collect(Collectors.toList());
		return collect;
	}
	
	@Override
	public SubjectsDto findBySubId(long subid) {
		Subjects subjects = subjectRepository.findById(subid).get();
		return mapToDto(subjects);
	}
	

	@Override
	public void updateSubject(SubjectsDto subjectsDto) {
		Subjects mapToEntity = mapToEntity(subjectsDto);
		subjectRepository.save(mapToEntity);
		
	}
	@Override
	public void deleteById(long subid) {
		subjectRepository.deleteById(subid);
		
	}
	@Override
	public List<SubjectsDto> findSubjectByDepartmentAndSemAndScheme(String department, String sem,String scheme) {
		List<Subjects> subjects = subjectRepository.findOnlyByDepartmentAndSemAndScheme(department,sem,scheme);
		return subjects.stream().map(s->mapToDto(s)).collect(Collectors.toList());
	}
	

	@Override
	public List<SubjectsDto> getAllSubjectsByDepartment(String department) {
		List<Subjects> subject = subjectRepository.findAllByDepartment(department);
		return subject.stream().map(s->mapToDto(s)).collect(Collectors.toList());
	}
	
	Subjects mapToEntity(SubjectsDto subjectsDto){
		return modelMapper.map(subjectsDto, Subjects.class);
	}
	
	SubjectsDto mapToDto(Subjects subjects){
		return modelMapper.map(subjects, SubjectsDto.class);
	}




	


	




	


	


	



}
