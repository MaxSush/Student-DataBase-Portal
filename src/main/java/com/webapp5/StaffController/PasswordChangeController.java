package com.webapp5.StaffController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webapp5.Staffpayload.StaffDto;
import com.webapp5.Staffpayload.StaffRegistrationDto;
import com.webapp5.Staffservice.StaffRegistrationService;
import com.webapp5.Staffservice.StaffService;
import com.webapp5.Studentpayload.ChangePasswordDto;
import com.webapp5.Studentservice.EmailService;

@Controller
public class PasswordChangeController {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private StaffRegistrationService staffRegistrationService;
	
	@Autowired
	private StaffService staffService;
	
	
	@RequestMapping("/staff-change-password")
	public String passwordChange(ChangePasswordDto changePasswordDto,Model model) {
		
		StaffDto staffById = staffService.findStaffById(changePasswordDto.getId());
		
		StaffRegistrationDto registrationById3 = staffRegistrationService.getRegistrationById(changePasswordDto.getStaffregid());
		
		if(changePasswordDto.getOldPassword().equals(staffById.getPassword())) {
			if(changePasswordDto.getOldPassword().equals(registrationById3.getPassword())) {
				staffById.setId(changePasswordDto.getId());
				staffById.setPassword(changePasswordDto.getNewPassword());
				staffService.updateStaff(staffById);
				
				registrationById3.setStaff_regid(changePasswordDto.getStaffregid());
				registrationById3.setPassword(changePasswordDto.getNewPassword());
				staffRegistrationService.updateStaffReg(registrationById3);
				
				emailService.sendEmail(registrationById3.getEmail(), "Password Changed", "User your password is successefully changed.Kindly use this new password "+changePasswordDto.getNewPassword()+" for login. Thank You !");
				model.addAttribute("passwordChanged", true);
				return "login";
			}
		}
		return "login";
	}

}
