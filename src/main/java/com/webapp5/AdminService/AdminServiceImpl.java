package com.webapp5.AdminService;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.webapp5.AdminEntity.Admin;
import com.webapp5.AdminPayload.AdminDto;
import com.webapp5.AdminPayload.AdminRegistrationDto;
import com.webapp5.AdminRepository.AdminRegistrationRepository;
import com.webapp5.AdminRepository.AdminRepository;
import com.webapp5.StaffRepository.ExamResultRepository;
import com.webapp5.StaffRepository.StaffImageRepository;
import com.webapp5.StaffRepository.StaffRegistrationRepository;
import com.webapp5.StaffRepository.StaffRepository;
import com.webapp5.Staffentity.ExamResult;
import com.webapp5.Staffentity.StaffEntity;
import com.webapp5.Staffpayload.ExamResultDto;
import com.webapp5.Staffpayload.StaffDto;
import com.webapp5.Studententity.StudentEntity;
import com.webapp5.Studentpayload.RegistrationDto;
import com.webapp5.Studentpayload.StudentDto;
import com.webapp5.Studentrepository.ImageRepository;
import com.webapp5.Studentrepository.RegistrationRepository;
import com.webapp5.Studentrepository.StudentRepository;


@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRegistrationRepository registrationRepository;
	
	@Autowired 
	private AdminRepository adminRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private StudentRepository repository;
	
	@Autowired
	private ExamResultRepository examResultRepository;
	
	@Autowired
	private RegistrationRepository registrationRepository2;
	
	@Autowired
	private ImageRepository imageRepository;
	
	@Autowired
	private StaffRepository staffRepository;
	
	@Autowired
	private StaffRegistrationRepository staffRegistrationRepository;
	
	@Autowired
	private StaffImageRepository staffImageRepository;
	
	@Override
	public Optional<AdminRegistrationDto> getAdminRegistrationByUsn(String usn) {
		Optional<AdminRegistrationDto> byUsn = registrationRepository.findByUsn(usn);
		return byUsn;
	}


	@Override
	public boolean existsBYEmail(String email) {
		boolean existsByEmail = registrationRepository.existsByEmail(email);
		return existsByEmail;
	}


	@Override
	public void createAdmin(RegistrationDto dto) {
		Admin mapToEntity = mapToEntity(dto);
		adminRepository.save(mapToEntity);
	}
	
	@Override
	public List<StudentDto> findAllStudentsByDepartment(String department) {
		List<StudentEntity> allByDepartmentOrderBySem = repository.findAllByDepartmentOrderBySem(department);
		return allByDepartmentOrderBySem.stream().map(a->mapToDto(a)).collect(Collectors.toList()) ;
	}
	
	@Override
	public List<StudentDto> findFirst5ByDepartmentOrderByCreatedDateDesc(String department) {
		List<StudentEntity> data = repository.findTop5ByDepartmentOrderByCreatedAtDesc(department);
		return data.stream().map(a->mapToDto(a)).collect(Collectors.toList());
	}
	
	@Override
	public List<AdminDto> findadmin(String usn) {
		List<Admin> admin = adminRepository.findByUsn(usn);
		return admin.stream().map(a->mapToDto(a)).collect(Collectors.toList());
	}
	
	@Override
	public AdminDto findById(long adminId) {
		Admin byAdminId = adminRepository.findByAdminId(adminId);
		return mapToDto(byAdminId);
	}
	

	@Override
	public void updateAdmin(AdminDto adminDto) {
		Admin mapToEntity = mapToEntity(adminDto);
		adminRepository.save(mapToEntity);
	}
	
	@Override
	public List<StudentDto> findStudentByCategoryAndDepartment(String category,String department) {
		List<StudentEntity> students = repository.findBycategoryAndDepartment(category,department);
		return students.stream().map(s->mapToDto(s)).collect(Collectors.toList());
	}
	
	@Override
	public List<StudentDto> findBySemAndDepartment(String sem,String department) {
		List<StudentEntity> students = repository.findAllByDepartmentAndSem(department,sem);
		return students.stream().map(s->mapToDto(s)).collect(Collectors.toList());
	}
	
	@Override
	public List<StudentDto> findStudentByUsn(String usn) {
		List<StudentEntity> student = repository.getByUsn(usn);
		return student.stream().map(s->mapToDto(s)).collect(Collectors.toList());
	}
	
	@Override
	public List<ExamResultDto> getExamResultByUsn(String studentusn) {
		List<ExamResult> result = examResultRepository.findByStudentUsn(studentusn);
		return result.stream().map(e->mapToDto(e)).collect(Collectors.toList());
	}
	
	

	@Override
	public List<ExamResultDto> getExamResultByUsnAndExamType(String studentUsn, String examType) {
		List<ExamResult> result = examResultRepository.getExamResultByStudentUsnAndExamTypeOrderBySem(studentUsn,examType);
		return result.stream().map(e->mapToDto(e)).collect(Collectors.toList());
	}
	
	@Transactional
	@Override
	public void deleteStudentByUsn(String studentusn) {
		repository.deleteByUsn(studentusn);
		examResultRepository.deleteByStudentUsn(studentusn);
		registrationRepository2.deleteByUsn(studentusn);
		imageRepository.deleteByUsn(studentusn);
	}
	
	
	@Override
	public List<StaffDto> AllStaffByDepartment(String department) {
		List<StaffEntity> allByDepartment = staffRepository.findAllByDepartment(department);
		return allByDepartment.stream().map(a->mapToDto(a)).collect(Collectors.toList());
	}
	@Override
	public void promoteStudents(StudentDto dto,String department) {
		
		List<Long> studentIds=dto.getIdList();
		  String nextSemester = dto.getNextSem();
		  
		  
		  for (Long studentId : studentIds) {
	            Optional<StudentEntity> optionalStudent = repository.findById(studentId);

	            if (optionalStudent.isPresent()) {
	                StudentEntity studentEntity = optionalStudent.get();
	                studentEntity.setId(studentId);
	                studentEntity.setSem(nextSemester);
	                repository.save(studentEntity);
	            } 
	        }
		
	}

	@Override
	public List<StudentDto> findTop100StudentsByDepartmentOrderBySem(String department) {
		List<StudentEntity> top50StudentsByDepartmentOrderBySem = repository.findTop50StudentsByDepartmentOrderBySem(department);
		return top50StudentsByDepartmentOrderBySem.stream().map(s->mapToDto(s)).collect(Collectors.toList());
	}
	
	@Override
	public Optional<Admin> findAdminByDepartment(String department) {
		Optional<Admin> byDepartment = adminRepository.findByDepartment(department);
		return byDepartment;
	}
	

	@Override
	public List<StaffEntity> findAllStaffsByDepartment(String department) {
		List<StaffEntity> allByDepartment = staffRepository.findAllByDepartment(department);
		return allByDepartment;
	}
	
	@Transactional
	@Override
	public void deleteStaffByUsn(String staffusn) {
		staffRepository.deleteByUsn(staffusn);
		staffRegistrationRepository.deleteByUsn(staffusn);
		staffImageRepository.deleteByUsn(staffusn);
		
	}
	
	Admin mapToEntity(RegistrationDto dto){
		return modelMapper.map(dto, Admin.class);
	}


	StudentDto mapToDto(StudentEntity entity){
		return modelMapper.map(entity, StudentDto.class);
	}

	AdminDto mapToDto(Admin entity){
		return modelMapper.map(entity, AdminDto.class);
	}

	Admin mapToEntity(AdminDto dto){
		return modelMapper.map(dto, Admin.class);
	}
	ExamResultDto mapToDto(ExamResult entity){
		return modelMapper.map(entity, ExamResultDto.class);
	}

	StaffDto mapToDto(StaffEntity entity){
		return modelMapper.map(entity, StaffDto.class);
	}


	




	




	

	


	



	


	


	


	


	
	


	

}
