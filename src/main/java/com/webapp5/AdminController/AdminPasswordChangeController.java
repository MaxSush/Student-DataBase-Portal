package com.webapp5.AdminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webapp5.AdminPayload.AdminDto;
import com.webapp5.AdminPayload.AdminRegistrationDto;
import com.webapp5.AdminService.AdminRegistartionService;
import com.webapp5.AdminService.AdminService;
import com.webapp5.Studentpayload.ChangePasswordDto;
import com.webapp5.Studentservice.EmailService;

@Controller
public class AdminPasswordChangeController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AdminRegistartionService adminRegistartionService;

	@Autowired
	private EmailService emailService;
	@RequestMapping("/admin-change-password")
	public String changePassword(ChangePasswordDto changePasswordDto,Model model) {
		
		AdminDto byId = adminService.findById(changePasswordDto.getAdminId());
		AdminRegistrationDto byId2 = adminRegistartionService.findById(changePasswordDto.getAdminRegId());
		
		if(changePasswordDto.getOldPassword().equals(byId.getPassword())) {
			if(changePasswordDto.getOldPassword().equals(byId2.getPassword())) {
				byId.setAdminId(changePasswordDto.getAdminId());
				byId.setPassword(changePasswordDto.getNewPassword());
				
				adminService.updateAdmin(byId);
				
				byId2.setAdminRegId(changePasswordDto.getAdminRegId());
				byId2.setPassword(changePasswordDto.getNewPassword());
				
				adminRegistartionService.updateRegistration(byId2);
				
				emailService.sendEmail(byId2.getEmail(), "Password Changed", "User your password is successefully changed.Kindly use this new password "+changePasswordDto.getNewPassword()+" for login. Thank You !");
				
				model.addAttribute("passwordChanged", true);
				return "login";
				
			}
		}
		
		return "login";
	}
}
