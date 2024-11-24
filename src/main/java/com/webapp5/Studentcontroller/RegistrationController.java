package com.webapp5.Studentcontroller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webapp5.AdminPayload.AdminRegistrationDto;
import com.webapp5.AdminService.AdminImageService;
import com.webapp5.AdminService.AdminRegistartionService;
import com.webapp5.AdminService.AdminService;
import com.webapp5.Staffentity.StaffRegistration;
import com.webapp5.Staffservice.StaffImageService;
import com.webapp5.Staffservice.StaffRegistrationService;
import com.webapp5.Staffservice.StaffService;
import com.webapp5.Studententity.ImageEntity;
import com.webapp5.Studententity.RegistrationEntity;
import com.webapp5.Studententity.StudentEntity;
import com.webapp5.Studentpayload.RegistrationDto;
import com.webapp5.Studentpayload.StudentDto;
import com.webapp5.Studentservice.DataVerificationService;
import com.webapp5.Studentservice.EmailService;
import com.webapp5.Studentservice.ImageService;
import com.webapp5.Studentservice.LoginService;
import com.webapp5.Studentservice.OTPService;
import com.webapp5.Studentservice.RegistrationService;
import com.webapp5.Studentservice.StudentDetailsService;
import com.webapp5.accountantEntity.AccountantRegistration;
import com.webapp5.accountantService.AccountantRegistrationService;
import com.webapp5.accountantService.AccountantServiceImpl;

@Controller
public class RegistrationController {

	@Autowired
	private StudentDetailsService detailsService;

	OTPService otp = new OTPService();

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private AccountantServiceImpl accountantServiceImpl;

	@Autowired
	private AccountantRegistrationService accountantRegistrationService;
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private StaffRegistrationService staffRegistrationService;
	
	@Autowired
	private StaffService staffService;
	
	@Autowired 
	private ImageService imageService;
	
	@Autowired 
	private StaffImageService staffImageService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AdminImageService adminImageService;
	
	@Autowired
	private AdminRegistartionService adminRegistartionService;

	@RequestMapping("/registration-student")
	public String studentRegistration() {
		return "registration";
	}

	@RequestMapping("/student-registration-controller")
	public String studentRegistrationController(RegistrationDto dto, Model model) throws IOException {
		
		if(dto.getUser().equalsIgnoreCase("Student")) {
			
			
			DataVerificationService dvs = new DataVerificationService();
			boolean verifyUsername = dvs.verifyUsername(dto.getUsn());
			boolean verifyEmail = dvs.verifyEmail(dto.getEmail());
			boolean verifyMobile = dvs.verifyMobile(dto.getMobile());

			    Optional<RegistrationEntity> byUsn = registrationService.getByUsn(dto.getUsn());

			if (byUsn!=null) {
				
				if (verifyUsername) {
					if (verifyEmail) {
						
						if(registrationService.existsByEmail(dto.getEmail())) {
							model.addAttribute("msg2", " Email Id is already registered");
							return "registration";
						}
						if (verifyMobile) {
							

							
							ClassPathResource resource = new ClassPathResource("static/assets/img/profiles/avatar-01.jpg");
				            byte[] defaultImageBytes = FileCopyUtils.copyToByteArray(resource.getInputStream());
				            imageService.storeDefaultImag(dto.getUsn(),defaultImageBytes);
				            
				            
				            String otpSrevice = otp.OtpSrevice();
							dto.setPassword(otpSrevice);
							detailsService.createRegistration(dto);
							registrationService.createRegistration(dto);
							emailService.sendEmail(dto.getEmail(), "OTP Verification",
									"You have successfully registered with MMEC. Please use this password " + otpSrevice
											+ " for login.  Thank You!!");
							model.addAttribute("popup", true);
							return "login";

						} else {
							model.addAttribute("msg1", "Invalid Mobile Number");
							return "registration";
						}
					} else {
						model.addAttribute("msg2", "Invalid Email Id");
						return "registration";
					}
				} else {
					model.addAttribute("msg3", "Invalid Username");
					return "registration";
				}
				
				
			} else {
				model.addAttribute("msg4", "Already Registered");
				return "registration";

			}
		}
		else if(dto.getUser().equalsIgnoreCase("Staff")) {

			DataVerificationService dvs = new DataVerificationService();
			boolean verifyEmail = dvs.verifyEmail(dto.getEmail());
			boolean verifyMobile = dvs.verifyMobile(dto.getMobile());
			Optional<StaffRegistration> registrationByUsn = staffRegistrationService.getRegistrationByUsn(dto.getUsn());
			
			 if(registrationByUsn!=null) {
				 
				 if(verifyEmail) {
					 if(staffRegistrationService.existsByEmail(dto.getEmail())) {
							model.addAttribute("msg2", " Email Id is already registered");
							return "registration";
						}
					 if(verifyMobile) {
						 

							ClassPathResource resource = new ClassPathResource("static/assets/img/profiles/avatar-01.jpg");
				            byte[] defaultImageBytes = FileCopyUtils.copyToByteArray(resource.getInputStream());
				            staffImageService.storeDefaultImag(dto.getUsn(),defaultImageBytes);
				            
						 String otpSrevice = otp.OtpSrevice();
						dto.setPassword(otpSrevice);
						
						staffService.createRegistration(dto);
						
						staffRegistrationService.createRegistration(dto);

						emailService.sendEmail(dto.getEmail(), "OTP Verification",
								"You have successfully registered with MMEC. Please use this password " + otpSrevice
										+ " for login.  Thank You!!");
						model.addAttribute("popup", true);
						
						return "login";
						 
					 }else {
							model.addAttribute("msg1", "Invalid Mobile Number");
							return "registration";
						}
				 }else {
						model.addAttribute("msg2", "Invalid Email Id");
						return "registration";
					}
			 }else {
					model.addAttribute("msg4", "Already Registered");
					return "registration";
			
		}
		
		}else if(dto.getUser().equalsIgnoreCase("HOD")) {
			DataVerificationService dvs = new DataVerificationService();
			boolean verifyEmail = dvs.verifyEmail(dto.getEmail());
			boolean verifyMobile = dvs.verifyMobile(dto.getMobile());
			Optional<AdminRegistrationDto> adminRegistrationByUsn = adminService.getAdminRegistrationByUsn(dto.getUsn());
			if(adminRegistrationByUsn!=null) {
				if(verifyEmail) {
					if(adminService.existsBYEmail(dto.getEmail())) {
						model.addAttribute("msg2", " Email Id is already registered");
						return "registration";
					}
					
					if(verifyMobile) {
						
						ClassPathResource resource = new ClassPathResource("static/assets/img/profiles/avatar-01.jpg");
			            byte[] defaultImageBytes = FileCopyUtils.copyToByteArray(resource.getInputStream());
			            adminImageService.storeDefaultImag(dto.getUsn(),defaultImageBytes);
			            
			            
			            String otpSrevice = otp.OtpSrevice();
						dto.setPassword(otpSrevice);
						
						adminService.createAdmin(dto);
						adminRegistartionService.createAdminRegistration(dto);
						
						emailService.sendEmail(dto.getEmail(), "OTP Verification",
								"You have successfully registered with MMEC. Please use this password " + otpSrevice
										+ " for login.  Thank You!!");
						model.addAttribute("popup", true);
						
						return "login";
					}else {
						model.addAttribute("msg1", "Invalid Mobile Number");
						return "registration";
				}
			}else {
				model.addAttribute("msg2", "Invalid Email Id");
				return "registration";
			
			
			}
		
	}else {
		model.addAttribute("msg4", "Already Registered");
		return "registration";
		
	}
		}
		
		else if(dto.getUser().equalsIgnoreCase("Accountant")) {
			DataVerificationService dvs = new DataVerificationService();
			boolean verifyEmail = dvs.verifyEmail(dto.getEmail());
			boolean verifyMobile = dvs.verifyMobile(dto.getMobile());
			Optional<AccountantRegistration> byUsn = accountantRegistrationService.getByUsn(dto.getUsn());
			
			if(byUsn!=null) {
				if(verifyEmail) {
					if(accountantRegistrationService.existsBYEmail(dto.getEmail())) {
						model.addAttribute("msg2", " Email Id is already registered");
						return "registration";
					}
					if(verifyMobile) {
						 String otpSrevice = otp.OtpSrevice();
							dto.setPassword(otpSrevice);
							
							accountantRegistrationService.createAccountant(dto);
							accountantServiceImpl.create(dto);
							
							emailService.sendEmail(dto.getEmail(), "OTP Verification",
									"You have successfully registered with MMEC. Please use this password " + otpSrevice
											+ " for login.  Thank You!!");
							model.addAttribute("popup", true);
							
							return "login";
					}
				}
			}
			
		}
		else {
			return "login";
		}
		return "login";
		
}
}
