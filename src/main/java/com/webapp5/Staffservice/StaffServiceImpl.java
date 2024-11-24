package com.webapp5.Staffservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp5.StaffRepository.ExamResultRepository;
import com.webapp5.StaffRepository.StaffRepository;
import com.webapp5.StaffRepository.SubjectRepository;
import com.webapp5.Staffentity.ExamResult;
import com.webapp5.Staffentity.StaffEntity;
import com.webapp5.Staffentity.Subjects;
import com.webapp5.Staffpayload.ExamResultDto;
import com.webapp5.Staffpayload.StaffDto;
import com.webapp5.Staffpayload.StudentSubjectDto;
import com.webapp5.Studententity.StudentEntity;
import com.webapp5.Studentpayload.LoginDto;
import com.webapp5.Studentpayload.RegistrationDto;
import com.webapp5.Studentrepository.StudentRepository;
import com.webapp5.Studentservice.StudentDetailsService;

@Service
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	private StaffRepository staffRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private SubjectRepository repository;

	@Autowired
	private ExamResultRepository examResultRepository;
	@Override
	public void createRegistration(RegistrationDto dto) {
		
		StaffEntity mapToEntity = mapToEntity(dto);
		
		staffRepository.save(mapToEntity);
		
	}
	@Override
	public List<StaffDto> getStaffByUsn(String usn) {
		List<StaffEntity> staffData = staffRepository.getStaffByUsn(usn);
		List<StaffDto> collect = staffData.stream().map(s->mapToDto(s)).collect(Collectors.toList());
		return collect;
	}
	
	@Override
	public StaffDto findStaffById(long id) {
		StaffEntity staffEntity = staffRepository.findById(id).get();
		
		return mapToDto(staffEntity);
	}
	
	@Override
	public void createStaff(StaffDto dto) {
		StaffEntity mapToEntity = mapToEntity(dto);
		staffRepository.save(mapToEntity);
		
	}
	
	@Override
	public void updateStaff(StaffDto staffById) {
		StaffEntity mapToEntity = mapToEntity(staffById);
		
		staffRepository.save(mapToEntity);
		
	}
	
	@Override
	public StaffDto findByUsn(String usn) {
		StaffEntity byusn = staffRepository.findByusn(usn);
		return mapToDto(byusn);
	}
	
	@Override
	public StudentSubjectDto findAllStudents(String department, String sem,String scheme) {
		List<StudentEntity> allByDepartmentAndSem = studentRepository.findAllByDepartmentAndSem(department, sem);
		
		 List<Subjects> subject = repository.findOnlyByDepartmentAndSemAndScheme(department,sem,scheme);
		 StudentSubjectDto dto=new StudentSubjectDto();
		 dto.setStudents(allByDepartmentAndSem);
		 dto.setSubjects(subject);
		 return dto;
	}
	
	@Override
	public List<ExamResultDto> getResult(String sem, String department,String scheme) {
		List<ExamResult> data = examResultRepository.findAllBySemAndDepartmentAndScheme(sem,department,scheme);
		List<ExamResultDto> collect = data.stream().map(d->mapToDto(d)).collect(Collectors.toList());
		return collect;
	}
	
	@Override
	public void updateResult(ExamResultDto dto) {
		ExamResult examResult=new ExamResult();
		examResult.setId(dto.getId());
		examResult.setStudentUsn(dto.getStudentUsn());
		examResult.setSem(dto.getSem());
		examResult.setSubjectName(dto.getSubjectName());
		examResult.setFirstIA(dto.getFirstIA());
		examResult.setSecondIA(dto.getSecondIA());
		examResult.setThirdIA(dto.getThirdIA());
		examResult.setMaxMarks(dto.getMaxMarks());
		examResult.setScheme(dto.getScheme());
		examResult.setDepartment(dto.getDepartment());
		
		examResultRepository.save(examResult);
	}
	
	StaffEntity mapToEntity(RegistrationDto dto){
		return modelMapper.map(dto, StaffEntity.class);
	}
	
	
	

	StaffDto mapToDto(StaffEntity entity){
		return modelMapper.map(entity, StaffDto.class);
	}
	
	StaffEntity mapToEntity(StaffDto dto){
		return modelMapper.map(dto, StaffEntity.class);
	}
	
	ExamResultDto mapToDto(ExamResult entity){
		return modelMapper.map(entity, ExamResultDto.class);
	}
	@Override
	public Map<String, ExamResult> getResultsByStudentUsn(String studentUsn) {
		List<ExamResult> byStudentUsn = examResultRepository.findByStudentUsn(studentUsn);
		Map<String, ExamResult> collect = byStudentUsn.stream()
        .collect(Collectors.toMap(ExamResult::getStudentUsn, result -> result));
		return collect;
	}
	
	
	
	
	
	

	

}
