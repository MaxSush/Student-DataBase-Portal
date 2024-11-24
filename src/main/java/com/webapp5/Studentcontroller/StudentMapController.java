package com.webapp5.Studentcontroller;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.webapp5.AdminEntity.Admin;
import com.webapp5.AdminEntity.AdminImage;

import com.webapp5.AdminService.AdminService;
import com.webapp5.Staffentity.StaffEntity;
import com.webapp5.Staffentity.SubjectNotes;
import com.webapp5.Staffpayload.ExamDto;
import com.webapp5.Staffpayload.ExamResultDto;
import com.webapp5.Staffpayload.StaffImageDto;
import com.webapp5.Staffpayload.SubjectsDto;
import com.webapp5.Staffservice.ExamResultService;
import com.webapp5.Staffservice.ExamService;
import com.webapp5.Staffservice.NotesService;
import com.webapp5.Staffservice.StaffImageService;
import com.webapp5.Staffservice.SubjectService;


import com.webapp5.Studentpayload.ImageDto;

import com.webapp5.Studentpayload.StudentDto;

import com.webapp5.Studentservice.ImageService;

import com.webapp5.Studentservice.StudentDetailsService;


@Controller
public class StudentMapController {

	@Autowired
	private StudentDetailsService detailsService;
	

	@Autowired
	private ExamService examService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private ExamResultService examResultService;
	
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private NotesService notesService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private StaffImageService imageService2;
	@RequestMapping("/view-student-info")
	public String viewStudentInfo(@RequestParam String usn,@RequestParam String name,@RequestParam String sem,@RequestParam long regid,@RequestParam long id,Model model,HttpServletRequest request) {
		  
		HttpSession session = request.getSession(false);
		if(session!=null) {
			if(session.getAttribute("usn")!=null) {
				
				List<StudentDto> registrationByUsn = detailsService.getRegistrationByUsn(usn);
				 
				model.addAttribute("student", registrationByUsn);
				model.addAttribute("name", registrationByUsn);
				model.addAttribute("usn", usn);
				model.addAttribute("name", name);
				model.addAttribute("sem", sem);
				model.addAttribute("regid", regid);
				model.addAttribute("id", id);
				ImageDto imageByUsn = imageService.getImageByUsn(usn);
				String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getImageData());
				model.addAttribute("image", base64Image);				
				
				return "student/student";
			}else {
				
				model.addAttribute("sessionMsg", true);
				return "login";
			}
			
		}else {
			model.addAttribute("sessionMsg", true);
			return "login";
		}
		
		
	}
	
	@RequestMapping("/edit-student-info")
	public String editStudentInfo(@RequestParam long id , @RequestParam String usn,@RequestParam long regid,Model model,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if(session!=null) {
			if(session.getAttribute("usn")!=null) {
				StudentDto registrationById = detailsService.getRegistrationById(id);
				 ImageDto imageByUsn = imageService.getImageByUsn(usn);
				 
				String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getImageData());
				
				
				
				model.addAttribute("usn", usn);
				model.addAttribute("student", registrationById);
				model.addAttribute("regid", regid);
				model.addAttribute("id", id);
				model.addAttribute("imgId", imageByUsn.getImgId());
				model.addAttribute("image", base64Image);
				
				
				return "student/edit-student";
			}else {
				model.addAttribute("sessionMsg", true);
				return "login";
			}
			
		}
		model.addAttribute("sessionMsg", true);
		return "login";
	}
	
	@RequestMapping("/updateStudent")
	public String udateStudent(StudentDto studentDto,Model model,@RequestParam long regid,@RequestParam long id,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session!=null) {
			if(session.getAttribute("usn")!=null) {
				StudentDto updateStudent = detailsService.updateStudent(studentDto);
				
				MultipartFile imageData = studentDto.getImageData();
				
				
				
				
				imageService.uplodImage(imageData,studentDto.getUsn(),studentDto.getImgId());
				
				List<StudentDto> registrationByUsn = detailsService.getRegistrationByUsn(studentDto.getUsn());
				
				model.addAttribute("student", registrationByUsn);
				model.addAttribute("name", studentDto.getFirstName());
				model.addAttribute("usn", studentDto.getUsn());
				model.addAttribute("regid", regid);
				model.addAttribute("sem", updateStudent.getSem());
				model.addAttribute("id", id);
				ImageDto imageByUsn = imageService.getImageByUsn(studentDto.getUsn());
				String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getImageData());
				model.addAttribute("image", base64Image);
				
				return "student/student";
			}else {
				model.addAttribute("sessionMsg", true);
				return "login";
			}
			
		}
		model.addAttribute("sessionMsg", true);
		return "login";
	}
	
	
	
	@RequestMapping("/add_student")
	public String addStudentDetails(StudentDto studentDto,Model model,@RequestParam long regid,HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		if(session!=null) {
			if(session.getAttribute("usn")!=null) {
				Optional<StudentDto> studentByUsnAndSem = detailsService.getStudentByUsnAndSem(studentDto);
				
				if(studentByUsnAndSem !=null) {
					
					StudentDto student = detailsService.createStudent(studentDto);
					
					
					List<StudentDto> registrationByUsn = detailsService.getRegistrationByUsn(studentDto.getUsn());
					

					model.addAttribute("student", registrationByUsn);
//					model.addAttribute("name", registrationByUsn);
					model.addAttribute("name", studentDto.getFirstName());
					model.addAttribute("regid", regid);
					model.addAttribute("id", student.getId());
					model.addAttribute("sem", student.getSem());
					ImageDto imageByUsn = imageService.getImageByUsn(studentDto.getUsn());
					String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getImageData());
					model.addAttribute("image", base64Image);
					
					
					return "student/student";
				}else {
					
					return "student/student";
				}
			}else {
				model.addAttribute("sessionMsg", true);
				return "login";
			}
			
		}else {
			model.addAttribute("sessionMsg", true);
			return "login";
		}
		
		
		
	}
	@RequestMapping("/student-dashboard")
    public String studentDashboard(@RequestParam String usn,@RequestParam String name,@RequestParam String sem,@RequestParam long regid,@RequestParam long id,Model model,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session!=null) {
			if(session.getAttribute("usn")!=null) {
				
				model.addAttribute("usn", usn);
				model.addAttribute("name", name);
				model.addAttribute("sem", sem);
				model.addAttribute("regid", regid);
				model.addAttribute("id", id);
				ImageDto imageByUsn = imageService.getImageByUsn(usn);
				String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getImageData());
				model.addAttribute("image", base64Image);
				return "student/student-dashboard";
			}else {
				model.addAttribute("sessionMsg", true);
				return "login";
			}
			
		}
		model.addAttribute("sessionMsg", true);
		return "login";
	}
	
	@RequestMapping("/student-details")
	public String studentDetails(@RequestParam String usn,@RequestParam String sem,@RequestParam String name,@RequestParam long regid,@RequestParam long id,Model model,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if(session!=null) {
			if(session.getAttribute("usn")!=null) {
				List<StudentDto> registrationByUsn = detailsService.getByUsnAndSem(usn,sem);
				
				
				model.addAttribute("student", registrationByUsn);
				model.addAttribute("usn", usn);
				model.addAttribute("name", name);
				model.addAttribute("sem", sem);
				model.addAttribute("regid", regid);
				model.addAttribute("id", id);
				ImageDto imageByUsn = imageService.getImageByUsn(usn);
				String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getImageData());
				model.addAttribute("image", base64Image);
				return "student/student-details";
			}else {
				model.addAttribute("sessionMsg", true);
				return "login";
			}
			
		}
		model.addAttribute("sessionMsg", true);
		return "login";
	}
	
	@RequestMapping("/Student-Profile")
	public String studentProfile(@RequestParam String usn,@RequestParam String name,@RequestParam String sem,@RequestParam long regid,@RequestParam long id,Model model,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if(session!=null) {
			if(session.getAttribute("usn")!=null) {
				List<StudentDto> registrationByUsn = detailsService.getByUsnAndSem(usn,sem);
				model.addAttribute("student", registrationByUsn);
				
				model.addAttribute("name", name);
				model.addAttribute("usn", usn);
				model.addAttribute("sem", sem);
				model.addAttribute("id", id);
				model.addAttribute("regid", regid);
				ImageDto imageByUsn = imageService.getImageByUsn(usn);
				String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getImageData());
				model.addAttribute("image", base64Image);
				return "student/profile";
			}else {
				model.addAttribute("sessionMsg", true);
				return "login";
			}
			
		}
		model.addAttribute("sessionMsg", true);
		return "login";
	}
	
	@RequestMapping("/view-student-subjects")
	public String allSubjects(@RequestParam String usn,@RequestParam String name,@RequestParam String sem,@RequestParam long regid,@RequestParam long id,Model model,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session!=null) {
			if(session.getAttribute("usn")!=null) {
				
				
				model.addAttribute("usn",usn );
				model.addAttribute("name", name);
				model.addAttribute("sem", sem);
				model.addAttribute("regid", regid);
				model.addAttribute("id", id);
				ImageDto imageByUsn = imageService.getImageByUsn(usn);
				String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getImageData());
				model.addAttribute("image", base64Image);
				return "student/subjects";
			}else {
				model.addAttribute("sessionMsg", true);
				return "login";
			}
		}
		model.addAttribute("sessionMsg", true);
		return "login";
		
	}
	
	@RequestMapping("/getAllSubjects")
	public String getAllSubjectsForStudent(SubjectsDto dto,@RequestParam String usn,@RequestParam String name,@RequestParam String sem,@RequestParam long regid,@RequestParam long id,Model model) {
		StudentDto bySem = detailsService.findById(id);
		
		List<SubjectsDto> allSubjects = subjectService.findAllByDepartmentAndSchemeOrderBySem(bySem.getDepartment(),dto.getScheme());
		
		
		model.addAttribute("subjects", allSubjects);
		
		Set<String> processedSemesters = new HashSet<>();
       
        model.addAttribute("processedSemesters", processedSemesters);
        model.addAttribute("usn",usn );
		model.addAttribute("name", name);
		model.addAttribute("sem", sem);
		model.addAttribute("regid", regid);
		model.addAttribute("id", id);
		
		ImageDto imageByUsn = imageService.getImageByUsn(usn);
		String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getImageData());
		model.addAttribute("image", base64Image);
		
		return "student/subjects";
	}
	
	@RequestMapping("/view-exams-for-student")
	public String viewExam(@RequestParam String usn,@RequestParam String name,@RequestParam String sem,@RequestParam long regid,@RequestParam long id,Model model) {
		model.addAttribute("usn",usn );
		model.addAttribute("name", name);
		model.addAttribute("sem", sem);
		model.addAttribute("regid", regid);
		model.addAttribute("id", id);
		
		ImageDto imageByUsn = imageService.getImageByUsn(usn);
		String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getImageData());
		model.addAttribute("image", base64Image);
		return "student/exam";
	}
	
	@RequestMapping("/exam-list")
	public String examList(ExamDto dto,@RequestParam String usn,@RequestParam String name,@RequestParam String sem1,@RequestParam long regid,@RequestParam long id,Model model,HttpServletRequest request ) {
		
		List<ExamDto> exams = examService.getAllExamsBYDepartmentAndSemAndExamType(dto.getDepartment(),dto.getSem(),dto.getExamType(),dto.getScheme());
		Set<String> processedSemesters = new HashSet<>();
	   
        model.addAttribute("processedSemesters", processedSemesters);
		
		model.addAttribute("exams",exams );
		model.addAttribute("usn",usn );
		model.addAttribute("name", name);
		model.addAttribute("sem", sem1);
		model.addAttribute("regid", regid);
		model.addAttribute("id", id);
		
		ImageDto imageByUsn = imageService.getImageByUsn(usn);
		String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getImageData());
		model.addAttribute("image", base64Image);
		
		return "student/exam";
		
	}
	
	@RequestMapping("/view-result-for-student")
	public String viewResult(@RequestParam String usn,@RequestParam String name,@RequestParam String sem1,@RequestParam long regid,@RequestParam long id,Model model) {
		 StudentDto registrationById = detailsService.getRegistrationById(id);
		 model.addAttribute("department", registrationById.getDepartment());
		model.addAttribute("usn",usn );
		model.addAttribute("name", name);
		model.addAttribute("sem", sem1);
		model.addAttribute("regid", regid);
		model.addAttribute("id", id);
		ImageDto imageByUsn = imageService.getImageByUsn(usn);
		String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getImageData());
		model.addAttribute("image", base64Image);
		return "student/view-results";
	}
	
	@RequestMapping("/viewResults-for-student")
	public String viewResults(ExamResultDto dto ,@RequestParam String usn,@RequestParam String name,@RequestParam String sem1,@RequestParam long regid,@RequestParam long id,Model model) {
       List<ExamResultDto> result = examResultService.getResultByStudentUsnAndDepartmentAndSchemeAndExamType(usn,dto.getDepartment(),dto.getScheme(),dto.getExamType());
       StudentDto registrationById = detailsService.getRegistrationById(id);
		Set<String> processedSemesters = new HashSet<>();
		
		
		
		
        model.addAttribute("processedSemesters", processedSemesters);
		
		model.addAttribute("usn",usn );
		model.addAttribute("name", name);
		model.addAttribute("sem", sem1);
		model.addAttribute("regid", regid);
		model.addAttribute("department", registrationById.getDepartment());
		
		model.addAttribute("scheme", dto.getScheme());
		model.addAttribute("id", id);
		model.addAttribute("results", result);
		
		ImageDto imageByUsn = imageService.getImageByUsn(usn);
		String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getImageData());
		model.addAttribute("image", base64Image);
		
		return "student/view-results";
	}
	
	@RequestMapping("/student-get-notes")
	public String getNotes(@RequestParam String usn,@RequestParam String name,@RequestParam String sem,@RequestParam long regid,@RequestParam long id,@RequestParam String subjectCode,@RequestParam String subjectName,Model model) {
		List<SubjectNotes> allNotesBySubjectCode = notesService.getAllNotesBySubjectCode(subjectCode);
		model.addAttribute("usn", usn);
		model.addAttribute("notes", allNotesBySubjectCode);
		
		model.addAttribute("name", name);
		model.addAttribute("usn",usn );
		model.addAttribute("name", name);
		model.addAttribute("sem", sem);
		model.addAttribute("regid", regid);
		model.addAttribute("id", id);
		model.addAttribute("subjectName", subjectName);
		model.addAttribute("subjectCode", subjectCode);
		ImageDto imageByUsn = imageService.getImageByUsn(usn);
		String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getImageData());
		model.addAttribute("image", base64Image);
		return "student/get-notes";
	}
	
	@RequestMapping("/department")
	public String department(@RequestParam String usn,@RequestParam String sem,@RequestParam String name,@RequestParam long regid,@RequestParam long id,Model model,HttpServletRequest request) {
		model.addAttribute("name", name);
		model.addAttribute("usn",usn );
		model.addAttribute("name", name);
		model.addAttribute("sem", sem);
		model.addAttribute("regid", regid);
		model.addAttribute("id", id);
		ImageDto imageByUsn = imageService.getImageByUsn(usn);
		String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getImageData());
		model.addAttribute("image", base64Image);
		
		 StudentDto registrationById = detailsService.getRegistrationById(id);
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

		List<StudentDto> allStudentsByDepartment = adminService.findAllStudentsByDepartment(registrationById.getDepartment());
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

		
		model.addAttribute("data", students);
		model.addAttribute("numberOfStudents", numberofStudents);
		model.addAttribute("numberOfBoys", numberOfBoys);
		model.addAttribute("numberOfGirls", numberOfGirls);
		model.addAttribute("department", registrationById.getDepartment());
		
		
		 Optional<Admin> adminByDepartment = adminService.findAdminByDepartment(registrationById.getDepartment());
		
		 if(adminByDepartment.isPresent()) {
			 Admin admin = adminByDepartment.get();
			 AdminImage imageByAdminUsn = imageService.getImageByAdminUsn(admin.getUsn());
			String adminImage = Base64.getEncoder().encodeToString(imageByAdminUsn.getAdminImageData());
			model.addAttribute("adminImage", adminImage);
			model.addAttribute("admin", admin);
		 }
		 
		
		 
		 List<StaffEntity> allStaffsByDepartment = adminService.findAllStaffsByDepartment(registrationById.getDepartment());
		
		 model.addAttribute("staffs", allStaffsByDepartment);
		
		
		 
		
		return "student/department";
	}
	
}
