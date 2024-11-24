package com.webapp5.AdminController;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.webapp5.AdminEntity.AdminImage;
import com.webapp5.AdminEntity.AdminRegistration;
import com.webapp5.AdminPayload.AdminDto;
import com.webapp5.AdminService.AdminRegistartionService;
import com.webapp5.AdminService.AdminService;
import com.webapp5.AdminService.ExportService;
import com.webapp5.Staffentity.StaffEntity;
import com.webapp5.Staffpayload.ExamResultDto;
import com.webapp5.Staffpayload.StaffDto;
import com.webapp5.Staffpayload.StaffImageDto;
import com.webapp5.Staffservice.StaffImageService;
import com.webapp5.Staffservice.StaffService;
import com.webapp5.Studentpayload.ImageDto;
import com.webapp5.Studentpayload.StudentDto;
import com.webapp5.Studentservice.ImageService;
import com.webapp5.accountantEntity.TotalFees;
import com.webapp5.accountantService.TotalFeesService;

@Controller("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private AdminRegistartionService adminRegistartionService;

	@Autowired
	private ImageService imageService;
	
	@Autowired
	private ExportService exportService;
	
	@Autowired
	private StaffImageService staffImageService;
	@Autowired
	private TotalFeesService  totalFeesService;
	
	@Autowired
	private StaffService staffService;

	@RequestMapping("/admin-dashboard")
	public String adminDashboard(@RequestParam String usn, @RequestParam String firstname,
			@RequestParam String lastname, @RequestParam Long adminRegId, @RequestParam String department,
			Model model) {
		int numberofStudents = 0;
		int numberOfBoys = 0;
		int numberOfGirls = 0;

		int semester_1_Students = 0;
		int semester_2_Students = 0;
		int semester_3_Students = 0;
		int semester_4_Students = 0;
		int semester_5_Students = 0;
		int semester_6_Students = 0;
		int semester_7_Students = 0;
		int semester_8_Students = 0;

		ArrayList<Integer> students = new ArrayList<>();

		List<StudentDto> allStudentsByDepartment = adminService.findAllStudentsByDepartment(department);
		for (StudentDto studentDto : allStudentsByDepartment) {
			numberofStudents += 1;
			if (studentDto.getGender() != null) {
				if (studentDto.getGender().equalsIgnoreCase("MALE")) {
					numberOfBoys += 1;
				} else {
					numberOfGirls += 1;
				}
			}
			if(studentDto.getSem()!=null) {
				if (studentDto.getSem().equalsIgnoreCase("1")) {
					semester_1_Students += 1;
				} else if (studentDto.getSem().equalsIgnoreCase("2")) {
					semester_2_Students += 1;
				} else if (studentDto.getSem().equalsIgnoreCase("3")) {
					semester_3_Students += 1;
				} else if (studentDto.getSem().equalsIgnoreCase("4")) {
					semester_4_Students += 1;
				} else if (studentDto.getSem().equalsIgnoreCase("5")) {
					semester_5_Students += 1;
				} else if (studentDto.getSem().equalsIgnoreCase("6")) {
					semester_6_Students += 1;
				} else if (studentDto.getSem().equalsIgnoreCase("7")) {
					semester_7_Students += 1;
				} else {
					semester_8_Students += 1;
				}

			}
			
		}

		students.add(0, semester_1_Students);
		students.add(1, semester_2_Students);
		students.add(2, semester_3_Students);
		students.add(3, semester_4_Students);
		students.add(4, semester_5_Students);
		students.add(5, semester_6_Students);
		students.add(6, semester_7_Students);
		students.add(7, semester_8_Students);

		List<StudentDto> recentStudent = adminService.findFirst5ByDepartmentOrderByCreatedDateDesc(department);
		List<StaffDto> allStaffByDepartment = adminService.AllStaffByDepartment(department);
		AdminImage imageByAdminUsn = imageService.getImageByAdminUsn(usn);
		String base64Image = Base64.getEncoder().encodeToString(imageByAdminUsn.getAdminImageData());
		model.addAttribute("image", base64Image);
		model.addAttribute("recentStudent", recentStudent);
		model.addAttribute("data", students);
		model.addAttribute("staff", allStaffByDepartment);
		model.addAttribute("usn", usn);
		model.addAttribute("firstname", firstname);
		model.addAttribute("lastname", lastname);
		model.addAttribute("adminRegId", adminRegId);
		model.addAttribute("numberOfStudents", numberofStudents);
		model.addAttribute("numberOfBoys", numberOfBoys);
		model.addAttribute("numberOfGirls", numberOfGirls);
		model.addAttribute("department", department);

		return "admin/admin-dashboard";
	}

	@RequestMapping("/view-admin-info")
	public String adminInfo(@RequestParam String usn, @RequestParam String firstname, @RequestParam String lastname,
			@RequestParam Long adminRegId, @RequestParam String department, Model model) {

		List<AdminDto> findadmin = adminService.findadmin(usn);
		String image = null;
		model.addAttribute("usn", usn);
		model.addAttribute("firstname", firstname);
		model.addAttribute("lastname", lastname);
		model.addAttribute("adminRegId", adminRegId);
		model.addAttribute("department", department);
		model.addAttribute("admin", findadmin);
		model.addAttribute("image", image);
		AdminImage imageByAdminUsn = imageService.getImageByAdminUsn(usn);
		String base64Image = Base64.getEncoder().encodeToString(imageByAdminUsn.getAdminImageData());
		model.addAttribute("image", base64Image);
		return "admin/admin";
	}

	@RequestMapping("/edit-admin")
	public String editAdmin(@RequestParam String usn, @RequestParam long adminId, @RequestParam long adminRegId,
			@RequestParam String firstname, @RequestParam String lastname, Model model) {

		AdminDto byId = adminService.findById(adminId);
		
		AdminImage imageByAdminUsn = imageService.getImageByAdminUsn(usn);
		String base64Image = Base64.getEncoder().encodeToString(imageByAdminUsn.getAdminImageData());
		model.addAttribute("admin", byId);
		model.addAttribute("usn", usn);
		model.addAttribute("firstname", firstname);
		model.addAttribute("lastname", lastname);
		model.addAttribute("adminRegId", adminRegId);
		model.addAttribute("department", byId.getDepartment());
		model.addAttribute("image", base64Image);
		model.addAttribute("adminImgId", imageByAdminUsn.getAdminImgId());
		
		return "admin/edit-admin";
	}

	@RequestMapping("/updateAdmin")
	public String updateAdmin(AdminDto adminDto, @RequestParam long adminRegId, Model model) {

		adminService.updateAdmin(adminDto);
		MultipartFile adminImageData = adminDto.getAdminImageData();
		imageService.updateAdminImage(adminDto.getAdminImgId(), adminImageData, adminDto.getUsn());
		
		List<AdminDto> findadmin = adminService.findadmin(adminDto.getUsn());
		
		AdminImage imageByAdminUsn = imageService.getImageByAdminUsn(adminDto.getUsn());
		String base64Image = Base64.getEncoder().encodeToString(imageByAdminUsn.getAdminImageData());
		
		model.addAttribute("usn", adminDto.getUsn());
		model.addAttribute("firstname", adminDto.getFirstName());
		model.addAttribute("lastname", adminDto.getLastName());
		model.addAttribute("adminRegId", adminRegId);
		model.addAttribute("department", adminDto.getDepartment());
		model.addAttribute("admin", findadmin);
		model.addAttribute("image", base64Image);
		return "admin/admin";
	}

	@RequestMapping("/admin-details")
	public String adminDetails(@RequestParam String usn, @RequestParam long adminId, @RequestParam String firstname,
			@RequestParam String lastname, Model model) {
		List<AdminDto> findadmin = adminService.findadmin(usn);
		Optional<AdminRegistration> registrationByUsn = adminRegistartionService.getRegistrationByUsn(usn);
		AdminRegistration adminRegistration = registrationByUsn.get();
		AdminImage imageByAdminUsn = imageService.getImageByAdminUsn(usn);
		String base64Image = Base64.getEncoder().encodeToString(imageByAdminUsn.getAdminImageData());
		model.addAttribute("admin", findadmin);
		model.addAttribute("usn", usn);
		model.addAttribute("firstname", firstname);
		model.addAttribute("lastname", lastname);
		model.addAttribute("adminRegId", adminRegistration.getAdminRegId());
		model.addAttribute("department", adminRegistration.getDepartment());
		model.addAttribute("image", base64Image);
		return "admin/admin-details";
	}

	@RequestMapping("/admin-profile")
	public String adminProfile(@RequestParam String usn, @RequestParam String firstname, @RequestParam String lastname,
			@RequestParam Long adminRegId, @RequestParam String department, Model model) {
		List<AdminDto> findadmin = adminService.findadmin(usn);
		AdminImage imageByAdminUsn = imageService.getImageByAdminUsn(usn);
		String base64Image = Base64.getEncoder().encodeToString(imageByAdminUsn.getAdminImageData());
		model.addAttribute("usn", usn);
		model.addAttribute("firstname", firstname);
		model.addAttribute("lastname", lastname);
		model.addAttribute("adminRegId", adminRegId);
		model.addAttribute("department", department);
		model.addAttribute("admin", findadmin);
		model.addAttribute("image", base64Image);
		return "admin/admin-profile";
	}

	@RequestMapping("/view-students")
	public String Students(@RequestParam String usn, @RequestParam String firstname, @RequestParam String lastname,
			@RequestParam Long adminRegId, @RequestParam String department, Model model) {
		List<StudentDto> allStudentsByDepartment = adminService.findTop100StudentsByDepartmentOrderBySem(department);
		model.addAttribute("allstudents", allStudentsByDepartment);
		model.addAttribute("usn", usn);
		model.addAttribute("firstname", firstname);
		model.addAttribute("lastname", lastname);
		model.addAttribute("adminRegId", adminRegId);
		model.addAttribute("department", department);
		AdminImage imageByAdminUsn = imageService.getImageByAdminUsn(usn);
		String base64Image = Base64.getEncoder().encodeToString(imageByAdminUsn.getAdminImageData());
		model.addAttribute("image", base64Image);
		return "admin/students";
	}

	@RequestMapping("/serachStudentByCategory")
	public String serchByCategory(StudentDto dto, @RequestParam String usn, @RequestParam String firstname,
			@RequestParam String lastname, @RequestParam Long adminRegId, @RequestParam String department,
			Model model) {
		List<StudentDto> studentByCategory = adminService.findStudentByCategoryAndDepartment(dto.getCategory(),
				department);

		model.addAttribute("allstudents", studentByCategory);
		model.addAttribute("usn", usn);
		model.addAttribute("firstname", firstname);
		model.addAttribute("lastname", lastname);
		model.addAttribute("adminRegId", adminRegId);
		model.addAttribute("department", department);
		model.addAttribute("filterBy", dto.getCategory());
		model.addAttribute("filter", "category");
		AdminImage imageByAdminUsn = imageService.getImageByAdminUsn(usn);
		String base64Image = Base64.getEncoder().encodeToString(imageByAdminUsn.getAdminImageData());
		model.addAttribute("image", base64Image);
		
		return "admin/students";
	}

	@RequestMapping("/serachStudentBySem")
	public String studensBySem(StudentDto dto, @RequestParam String usn, @RequestParam String firstname,
			@RequestParam String lastname, @RequestParam Long adminRegId, @RequestParam String department,
			Model model) {
		List<StudentDto> bySemAndDepartment = adminService.findBySemAndDepartment(dto.getSem(), department);
		model.addAttribute("allstudents", bySemAndDepartment);
		model.addAttribute("usn", usn);
		model.addAttribute("firstname", firstname);
		model.addAttribute("lastname", lastname);
		model.addAttribute("adminRegId", adminRegId);
		model.addAttribute("department", department);
		AdminImage imageByAdminUsn = imageService.getImageByAdminUsn(usn);
		String base64Image = Base64.getEncoder().encodeToString(imageByAdminUsn.getAdminImageData());
		model.addAttribute("image", base64Image);
		return "admin/students";
	}

	@RequestMapping("/serachStudentByUSN")
	public String StudentByUsn(StudentDto dto, @RequestParam String adminusn, @RequestParam String firstname,
			@RequestParam String lastname, @RequestParam Long adminRegId, @RequestParam String department,
			Model model) {

		List<StudentDto> studentByUsn = adminService.findStudentByUsn(dto.getUsn());
		model.addAttribute("allstudents", studentByUsn);
		model.addAttribute("usn", adminusn);
		model.addAttribute("firstname", firstname);
		model.addAttribute("lastname", lastname);
		model.addAttribute("adminRegId", adminRegId);
		model.addAttribute("department", department);
		AdminImage imageByAdminUsn = imageService.getImageByAdminUsn(adminusn);
		String base64Image = Base64.getEncoder().encodeToString(imageByAdminUsn.getAdminImageData());
		model.addAttribute("image", base64Image);
		return "admin/students";
	}

	@RequestMapping("/view-student-details")
	public String studentDetail(@RequestParam String studentusn, @RequestParam String adminusn,
			@RequestParam String firstname, @RequestParam String lastname, @RequestParam Long adminRegId,
			@RequestParam String department, Model model) {
		List<StudentDto> studentByUsn = adminService.findStudentByUsn(studentusn);

		
		model.addAttribute("student", studentByUsn);
		model.addAttribute("usn", adminusn);
		model.addAttribute("firstname", firstname);
		model.addAttribute("lastname", lastname);
		model.addAttribute("adminRegId", adminRegId);
		model.addAttribute("department", department);
		model.addAttribute("studentusn", studentusn);
		AdminImage imageByAdminUsn = imageService.getImageByAdminUsn(adminusn);
		String base64Image = Base64.getEncoder().encodeToString(imageByAdminUsn.getAdminImageData());
		model.addAttribute("image", base64Image);
		return "admin/student-details";
	}

	@RequestMapping("/getResults-for-students")
	public String getResults(ExamResultDto examResultDto, @RequestParam String adminusn, @RequestParam String firstname,
			@RequestParam String lastname, @RequestParam Long adminRegId, @RequestParam String department,
			Model model) {

		List<ExamResultDto> examResultByUsnAndExamType = adminService
				.getExamResultByUsnAndExamType(examResultDto.getStudentUsn(), examResultDto.getExamType());
		Set<String> processedSemesters = new HashSet<>();
		model.addAttribute("processedSemesters", processedSemesters);
		model.addAttribute("results", examResultByUsnAndExamType);
		List<StudentDto> studentByUsn = adminService.findStudentByUsn(examResultDto.getStudentUsn());
		ImageDto imageByUsn = imageService.getImageByUsn(examResultDto.getStudentUsn());
		String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getImageData());

		model.addAttribute("image", base64Image);
		model.addAttribute("student", studentByUsn);
		model.addAttribute("usn", adminusn);
		model.addAttribute("firstname", firstname);
		model.addAttribute("lastname", lastname);
		model.addAttribute("adminRegId", adminRegId);
		model.addAttribute("department", department);
		model.addAttribute("studentusn", examResultDto.getStudentUsn());
		
		AdminImage imageByAdminUsn = imageService.getImageByAdminUsn(adminusn);
		String img = Base64.getEncoder().encodeToString(imageByAdminUsn.getAdminImageData());
		model.addAttribute("image", img);

		return "admin/student-details";
	}

	@RequestMapping("/delete-Student")
	public String deleteStudent(@RequestParam String studentusn, @RequestParam String adminusn,
			@RequestParam String firstname, @RequestParam String lastname, @RequestParam Long adminRegId,
			@RequestParam String department, Model model) {

		adminService.deleteStudentByUsn(studentusn);
		List<StudentDto> allStudentsByDepartment = adminService.findAllStudentsByDepartment(department);
		model.addAttribute("allstudents", allStudentsByDepartment);
		model.addAttribute("usn", adminusn);
		model.addAttribute("firstname", firstname);
		model.addAttribute("lastname", lastname);
		model.addAttribute("adminRegId", adminRegId);
		model.addAttribute("department", department);
		AdminImage imageByAdminUsn = imageService.getImageByAdminUsn(adminusn);
		String base64Image = Base64.getEncoder().encodeToString(imageByAdminUsn.getAdminImageData());
		model.addAttribute("image", base64Image);
		return "admin/students";
	}
	
	@RequestMapping("/promote-students")
	public String promoteStudents(@RequestParam String usn, @RequestParam String firstname,
			@RequestParam String lastname, @RequestParam Long adminRegId, @RequestParam String department,
			Model model) {
		model.addAttribute("usn", usn);
		model.addAttribute("firstname", firstname);
		model.addAttribute("lastname", lastname);
		model.addAttribute("adminRegId", adminRegId);
		model.addAttribute("department", department);
		AdminImage imageByAdminUsn = imageService.getImageByAdminUsn(usn);
		String base64Image = Base64.getEncoder().encodeToString(imageByAdminUsn.getAdminImageData());
		model.addAttribute("image", base64Image);
		return "admin/promote-students";
	}
	
	@RequestMapping("/StudentBySem")
	public String studentsBySem(StudentDto dto,@RequestParam String usn, @RequestParam String firstname,
			@RequestParam String lastname, @RequestParam Long adminRegId, @RequestParam String department,
			Model model) {
		List<StudentDto> bySemAndDepartment = adminService.findBySemAndDepartment(dto.getSem(), department);
		model.addAttribute("allstudents", bySemAndDepartment);
		model.addAttribute("usn", usn);
		model.addAttribute("firstname", firstname);
		model.addAttribute("lastname", lastname);
		model.addAttribute("adminRegId", adminRegId);
		model.addAttribute("department", department);
		model.addAttribute("studentSem", dto.getSem());
		AdminImage imageByAdminUsn = imageService.getImageByAdminUsn(usn);
		String base64Image = Base64.getEncoder().encodeToString(imageByAdminUsn.getAdminImageData());
		model.addAttribute("image", base64Image);
	
		return "admin/promote-students";
	}
	
	@RequestMapping("/promote-sem")
	public String studentsPromot(StudentDto dto,@RequestParam String usn, @RequestParam String firstname,
			@RequestParam String lastname, @RequestParam Long adminRegId, @RequestParam String department,
			Model model) {
		
		adminService.promoteStudents(dto,department);
		
		List<StudentDto> bySemAndDepartment = adminService.findBySemAndDepartment(dto.getNextSem(), department);
		model.addAttribute("allstudents", bySemAndDepartment);
		model.addAttribute("usn", usn);
		model.addAttribute("firstname", firstname);
		model.addAttribute("lastname", lastname);
		model.addAttribute("adminRegId", adminRegId);
		model.addAttribute("department", department);
		AdminImage imageByAdminUsn = imageService.getImageByAdminUsn(usn);
		String base64Image = Base64.getEncoder().encodeToString(imageByAdminUsn.getAdminImageData());
		model.addAttribute("image", base64Image);
		return "admin/promote-students";
	}
	
	@RequestMapping("/export-data")
	public ResponseEntity<InputStreamResource> exportData(@RequestParam String filterBy,@RequestParam String filter,@RequestParam String usn, @RequestParam String firstname,
			@RequestParam String lastname, @RequestParam Long adminRegId, @RequestParam String department,
			Model model) {
		
		 InputStreamResource file = new InputStreamResource(exportService.load(filterBy,filter));
		 if(filter.equalsIgnoreCase("category")) {
			 String filename = filterBy+" students.xlsx";
			 return ResponseEntity.ok()
		                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
		                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
		                .body(file);
		 }
		 String filename = "All students"+"( "+filter+" )"+".xlsx";
		 return ResponseEntity.ok()
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
	                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
	                .body(file);
		
		

		
	}
	
	@RequestMapping("/fees-collection-admin")
	public String feesCollection(@RequestParam String usn, @RequestParam String firstname, @RequestParam String lastname,
			@RequestParam Long adminRegId, @RequestParam String department, Model model) {
		
		List<TotalFees> allEntries = totalFeesService.getAllEntries();
		
		
		
		model.addAttribute("allEntries", allEntries);
		model.addAttribute("usn", usn);
		model.addAttribute("firstname", firstname);
		model.addAttribute("lastname", lastname);
		model.addAttribute("adminRegId", adminRegId);
		model.addAttribute("department", department);
		AdminImage imageByAdminUsn = imageService.getImageByAdminUsn(usn);
		String base64Image = Base64.getEncoder().encodeToString(imageByAdminUsn.getAdminImageData());
		model.addAttribute("image", base64Image);
		
		return "admin/fees-collections";
	}
	
	@RequestMapping("/admin-staff-list")
	public String staffList(@RequestParam String usn, @RequestParam String firstname, @RequestParam String lastname,
			@RequestParam Long adminRegId, @RequestParam String department, Model model) {
		
		List<StaffEntity> allStaffsByDepartment = adminService.findAllStaffsByDepartment(department);

		model.addAttribute("allstaffs", allStaffsByDepartment);
		model.addAttribute("usn", usn);
		model.addAttribute("firstname", firstname);
		model.addAttribute("lastname", lastname);
		model.addAttribute("adminRegId", adminRegId);
		model.addAttribute("department", department);
		AdminImage imageByAdminUsn = imageService.getImageByAdminUsn(usn);
		String base64Image = Base64.getEncoder().encodeToString(imageByAdminUsn.getAdminImageData());
		model.addAttribute("image", base64Image);
		
		return "admin/staffs";
	}
	
	@RequestMapping("/view-staff-details")
	public String staffDetails(@RequestParam String staffusn,@RequestParam String usn, @RequestParam String firstname, @RequestParam String lastname,
			@RequestParam Long adminRegId, @RequestParam String department, Model model) {
		List<StaffDto> staffByUsn = staffService.getStaffByUsn(staffusn);
		model.addAttribute("staff", staffByUsn);
		model.addAttribute("usn", usn);
		model.addAttribute("firstname", firstname);
		model.addAttribute("lastname", lastname);
		model.addAttribute("adminRegId", adminRegId);
		model.addAttribute("department", department);
		
		AdminImage imageByAdminUsn = imageService.getImageByAdminUsn(usn);
		String adminimg = Base64.getEncoder().encodeToString(imageByAdminUsn.getAdminImageData());
		model.addAttribute("Adminimage", adminimg);
		
		StaffImageDto imageByUsn = staffImageService.getImageByUsn(staffusn);
		String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getStaffImageData());
		model.addAttribute("image", base64Image);
		
		return "admin/staff-details";
	}
	
	@RequestMapping("/delete-Staff")
	public String deleteStaff(@RequestParam String staffusn,@RequestParam String adminusn,
			@RequestParam String firstname, @RequestParam String lastname, @RequestParam Long adminRegId,
			@RequestParam String department, Model model) {
		adminService.deleteStaffByUsn(staffusn);
		
		List<StaffEntity> allStaffsByDepartment = adminService.findAllStaffsByDepartment(department);

		model.addAttribute("allstaffs", allStaffsByDepartment);
		model.addAttribute("usn", adminusn);
		model.addAttribute("firstname", firstname);
		model.addAttribute("lastname", lastname);
		model.addAttribute("adminRegId", adminRegId);
		model.addAttribute("department", department);
		AdminImage imageByAdminUsn = imageService.getImageByAdminUsn(adminusn);
		String base64Image = Base64.getEncoder().encodeToString(imageByAdminUsn.getAdminImageData());
		model.addAttribute("image", base64Image);
		return "admin/staffs";
		
	}
}
