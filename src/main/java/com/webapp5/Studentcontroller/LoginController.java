package com.webapp5.Studentcontroller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webapp5.AdminEntity.Admin;
import com.webapp5.AdminEntity.AdminRegistration;
import com.webapp5.AdminPayload.AdminDto;
import com.webapp5.AdminService.AdminRegistartionService;
import com.webapp5.Staffentity.StaffRegistration;
import com.webapp5.Staffpayload.StaffDto;
import com.webapp5.Staffservice.StaffRegistrationService;

import com.webapp5.Studententity.RegistrationEntity;

import com.webapp5.Studentpayload.LoginDto;
import com.webapp5.Studentpayload.StudentDto;
import com.webapp5.Studentservice.DataVerificationService;

import com.webapp5.Studentservice.LoginService;
import com.webapp5.Studentservice.RegistrationService;
import com.webapp5.accountantEntity.Accountant;
import com.webapp5.accountantEntity.AccountantRegistration;
import com.webapp5.accountantService.AccountantServiceImpl;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private RegistrationService registrationService;

	@Autowired
	private StaffRegistrationService staffRegistrationService;

	@Autowired
	private AdminRegistartionService adminRegistartionService;
	
	
	@Autowired
	private AccountantServiceImpl accountantServiceImpl;

	@GetMapping("/")
	public String login() {
		return "login";
	}

	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}

	@RequestMapping("/login-controller")
	public String studentLogin(LoginDto dto, Model model, HttpServletRequest request) {

		if (dto.getUser().equals("Staff")) {

			StaffDto staffRegistration = loginService.getStaffRegistration(dto);

			Optional<StaffRegistration> registrationByUsn = staffRegistrationService.getRegistrationByUsn(dto.getUsn());

			StaffRegistration staffRegistration2 = registrationByUsn.get();

			if (dto.getUsn().equals(staffRegistration.getUsn())) {

				HttpSession session = request.getSession(true);
				session.setAttribute("usn", dto.getUsn());
				session.setAttribute("user", dto.getUser());

				model.addAttribute("usn", dto.getUsn());
				model.addAttribute("name", staffRegistration.getFirstName());
				model.addAttribute("lastname", staffRegistration.getLastName());
				model.addAttribute("staffregid", staffRegistration2.getStaff_regid());

				return "redirect:/staff-dashboard?usn=" + dto.getUsn() + "&name=" + staffRegistration.getFirstName()
						+ "&lastname=" + staffRegistration.getLastName() + "&staffregid="
						+ staffRegistration2.getStaff_regid();
			}
			model.addAttribute("usermessage", "Invalid username/Password");
			return "login";

		}

		else if (dto.getUser().equals("Student")) {

			List<StudentDto> registrationByUsnAndPassword = loginService.getRegistrationByUsnAndPassword(dto.getUsn(),
					dto.getPassword());

			RegistrationEntity registrationByUsn = registrationService.getRegistrationByUsn(dto.getUsn().toUpperCase());

			DataVerificationService dvs = new DataVerificationService();
			boolean verifyUsername = dvs.verifyUsername(dto.getUsn());

			if (registrationByUsnAndPassword.isEmpty()) {
				model.addAttribute("usermessage", "Invalid username/Password");
				return "login";
			}
			if (registrationByUsnAndPassword.size() == 1) {
				StudentDto studentDto = registrationByUsnAndPassword.get(0);
				if (dto.getUsn().equals(studentDto.getUsn())) {
					if (verifyUsername) {
						HttpSession session = request.getSession(true);
						session.setAttribute("usn", dto.getUsn());
						session.setAttribute("user", dto.getUser());

						model.addAttribute("usn", dto.getUsn());
						model.addAttribute("name", studentDto.getFirstName());
						model.addAttribute("sem", studentDto.getSem());
						model.addAttribute("regid", registrationByUsn.getReg_id());

						return "redirect:/student-dashboard?usn=" + dto.getUsn() + "&name=" + studentDto.getFirstName()
								+ "&sem=" + studentDto.getSem() + "&regid=" + registrationByUsn.getReg_id() + "&id="
								+ studentDto.getId();

					}
				}
			}

		} else if (dto.getUser().equals("HOD")) {

			AdminDto admin = loginService.getAdmin(dto);
			Optional<AdminRegistration> registrationByUsn = adminRegistartionService.getRegistrationByUsn(dto.getUsn());
			AdminRegistration adminRegistration = registrationByUsn.get();

			if (dto.getUsn().equalsIgnoreCase(admin.getUsn())) {
				model.addAttribute("usn", dto.getUsn());
				model.addAttribute("firstname", admin.getFirstName());
				model.addAttribute("lastname", admin.getLastName());
				model.addAttribute("adminRegId", adminRegistration.getAdminRegId());
				model.addAttribute("department", admin.getDepartment());
				return "redirect:/admin-dashboard?usn=" + dto.getUsn() + "&firstname=" + admin.getFirstName()
						+ "&lastname=" + admin.getLastName() + "&adminRegId=" + adminRegistration.getAdminRegId()
						+ "&department=" + admin.getDepartment();
			}
			model.addAttribute("usermessage", "Invalid username/Password");
			return "login";

		} else if (dto.getUser().equals("Accountant")) {

			Accountant acccountant = loginService.getAcccountant(dto);
			Optional<AccountantRegistration> accountantRegistrationByUsn = accountantServiceImpl.getAccountantRegistrationByUsn(dto.getUsn());
			 AccountantRegistration accountantRegistration = accountantRegistrationByUsn.get();

			if (dto.getUsn().equalsIgnoreCase(acccountant.getUsn())) {
				model.addAttribute("usn", dto.getUsn());
				model.addAttribute("firstname", acccountant.getFirstName());
				model.addAttribute("lastname", acccountant.getLastName());
				model.addAttribute("adminRegId", accountantRegistration.getAcRegId());
				model.addAttribute("department", acccountant.getDepartment());
				return "redirect:/accountant-dashboard?usn=" + dto.getUsn() + "&firstName=" + acccountant.getFirstName()
						+ "&lastName=" + acccountant.getLastName() + "&acRegId=" + accountantRegistration.getAcRegId()
						+ "&department=" + acccountant.getDepartment();
			}
			model.addAttribute("usermessage", "Invalid username/Password");
			return "login";

		}

		else {
			return "login";
		}

		return "login";

	}
}
