package com.webapp5.Studentcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webapp5.AdminPayload.AdminRegistrationDto;
import com.webapp5.AdminService.AdminRegistartionService;
import com.webapp5.Staffpayload.StaffRegistrationDto;
import com.webapp5.Staffservice.StaffRegistrationService;
import com.webapp5.Studentpayload.LoginDto;
import com.webapp5.Studentpayload.RegistrationDto;
import com.webapp5.Studentservice.EmailService;
import com.webapp5.Studentservice.RegistrationService;

@Controller
public class ForgotPasswordController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private StaffRegistrationService staffRegistrationService;
	
	@Autowired
	private AdminRegistartionService adminRegistartionService;
	
	@RequestMapping("/forgot-password")
	public String forgotPassword() {
		return "forgot-password";
	}

	@RequestMapping("/forgot-password-recovery")
	public String forgotPasswordRecovery(RegistrationDto dto,Model model) {
		
		if(registrationService.existsByEmail(dto.getEmail())) {
			RegistrationDto registrationByEmail = registrationService.getRegistrationByEmail(dto.getEmail());
			emailService.sendEmail(dto.getEmail(), "Password Recovery", "Your password has been recovered for username "+registrationByEmail.getUsn()+" , Please use this password "+registrationByEmail.getPassword()+" for login.");
			
			model.addAttribute("passwordRecovery", true);
			return "login";
		}else if(staffRegistrationService.existsByEmail(dto.getEmail())) {
			StaffRegistrationDto registrationByEmail = staffRegistrationService.getRegistrationByEmail(dto.getEmail());
			
			emailService.sendEmail(dto.getEmail(), "Password Recovery", "Your password has been recovered for username "+registrationByEmail.getUsn()+" , Please use this password "+registrationByEmail.getPassword()+" for login.");
			model.addAttribute("passwordRecovery", true);
			return "login";
		}else if(adminRegistartionService.existsByEmail(dto.getEmail())) {
			AdminRegistrationDto adminRegistrationByEmail = adminRegistartionService.getAdminRegistrationByEmail(dto.getEmail());
			emailService.sendEmail(dto.getEmail(), "Password Recovery", "Your password has been recovered for username "+adminRegistrationByEmail.getUsn()+" , Please use this password "+adminRegistrationByEmail.getPassword()+" for login.");
			model.addAttribute("passwordRecovery", true);
			return "login";
		}
		else {
			model.addAttribute("passwordRecovery", "Invalid Email Id");
			return "forgot-password";
		}
		
		
		
	}
}
