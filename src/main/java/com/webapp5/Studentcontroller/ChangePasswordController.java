package com.webapp5.Studentcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.webapp5.Studentpayload.ChangePasswordDto;
import com.webapp5.Studentpayload.RegistrationDto;
import com.webapp5.Studentpayload.StudentDto;
import com.webapp5.Studentservice.EmailService;
import com.webapp5.Studentservice.RegistrationService;
import com.webapp5.Studentservice.StudentDetailsService;

@Controller
public class ChangePasswordController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private StudentDetailsService detailsService;
	
	@Autowired
	private EmailService emailService;
	
	
	

	@RequestMapping("/student-change-password")
	public String passwordChange(ChangePasswordDto changePasswordDto,Model model) {
		
		
		StudentDto registrationById = detailsService.getRegistrationById(changePasswordDto.getId());
		RegistrationDto registrationById2 = registrationService.getRegistrationById(changePasswordDto.getRegid());
		
		
		if(changePasswordDto.getOldPassword().equals(registrationById.getPassword())) {
			if(changePasswordDto.getOldPassword().equals(registrationById2.getPassword())) {
				registrationById.setId(changePasswordDto.getId());
				registrationById.setPassword(changePasswordDto.getNewPassword());
				detailsService.updateStudent(registrationById);
				
				registrationById2.setReg_id(changePasswordDto.getRegid());
				registrationById2.setPassword(changePasswordDto.getNewPassword());
				registrationService.updateRegistration(registrationById2);
				
				
				emailService.sendEmail(registrationById2.getEmail(), "Password Changed", "User your password is successefully changed.Kindly use this new password "+changePasswordDto.getNewPassword()+" for login. Thank You !");
			
				model.addAttribute("passwordChanged", true);
				return "login";
			
			}
			
		}
		
		return "login";
		
	}
	
	
}
