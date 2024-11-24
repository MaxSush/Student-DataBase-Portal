package com.webapp5.Studentservice;



import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp5.AdminEntity.Admin;
import com.webapp5.AdminPayload.AdminDto;
import com.webapp5.AdminRepository.AdminRepository;
import com.webapp5.StaffRepository.StaffRepository;
import com.webapp5.Staffentity.StaffEntity;
import com.webapp5.Staffpayload.StaffDto;
import com.webapp5.Studententity.StudentEntity;
import com.webapp5.Studentpayload.LoginDto;

import com.webapp5.Studentpayload.StudentDto;
import com.webapp5.Studentrepository.StudentRepository;
import com.webapp5.accountantEntity.Accountant;
import com.webapp5.accountantRepository.AccountantRepository;
import com.webapp5.exception.ResourceNotFound;

@Service
public class LoginServiceimpl implements LoginService {

	@Autowired
	private StudentRepository repository;
	
	@Autowired
	private ModelMapper  modelMapper;
	
	@Autowired
	private StaffRepository staffRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private AccountantRepository accountantRepository;

	@Override
	public StudentDto getRegistration(LoginDto dto) {
		
		 StudentEntity studentEntity2 = repository.findByUsnAndPassword(dto.getUsn().toUpperCase(),dto.getPassword()).orElseThrow(
				 ()-> new ResourceNotFound("You are not registered yet.."));
		StudentDto studentDto = mapToDto(studentEntity2);
		return studentDto;
	}

	@Override
	public StaffDto getStaffRegistration(LoginDto dto) {
		StaffEntity staffEntity = staffRepository.findStaffByUsnAndPassword(dto.getUsn(), dto.getPassword()).orElseThrow(
				 ()-> new ResourceNotFound("You are not registered yet.."));
		StaffDto mapToDto = mapToDto(staffEntity);
		return mapToDto;
	}
	
	@Override
	public AdminDto getAdmin(LoginDto dto) {
		Admin admin = adminRepository.findAdminByUsnAndPassword(dto.getUsn(),dto.getPassword()).orElseThrow(
				()-> new ResourceNotFound("You are not registered yet.."));
		
		AdminDto mapToDto = mapToDto(admin);
		return mapToDto;
	}
	@Override
	public List<StudentDto> getRegistrationByUsnAndPassword(String usn, String password) {
		List<StudentEntity> byUsnAndPassword = repository.getByUsnAndPassword(usn,password);
		return byUsnAndPassword.stream().map(b->mapToDto(b)).collect(Collectors.toList());
	}
	
	@Override
	public Accountant getAcccountant(LoginDto dto) {
		Accountant accountant = accountantRepository.findByUsnAndPassword(dto.getUsn(),dto.getPassword()).orElseThrow(
				 ()-> new ResourceNotFound("You are not registered yet.."));
		return accountant ;
	}

	
	StudentDto mapToDto(StudentEntity entity){
		return modelMapper.map(entity, StudentDto.class);
	}

	StaffDto mapToDto(StaffEntity entity){
		return modelMapper.map(entity, StaffDto.class);
	}

	AdminDto mapToDto(Admin admin){
		return modelMapper.map(admin, AdminDto.class);
	}

	
	


	
	
}
