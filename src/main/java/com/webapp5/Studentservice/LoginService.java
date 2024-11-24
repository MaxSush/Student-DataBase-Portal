package com.webapp5.Studentservice;



import java.util.List;

import com.webapp5.AdminPayload.AdminDto;
import com.webapp5.Staffpayload.StaffDto;

import com.webapp5.Studentpayload.LoginDto;

import com.webapp5.Studentpayload.StudentDto;
import com.webapp5.accountantEntity.Accountant;

public interface LoginService {

	StudentDto getRegistration(LoginDto dto);

	StaffDto getStaffRegistration(LoginDto dto);

	AdminDto getAdmin(LoginDto dto);

	List<StudentDto> getRegistrationByUsnAndPassword(String usn, String password);

	Accountant getAcccountant(LoginDto dto);

	
	

}
