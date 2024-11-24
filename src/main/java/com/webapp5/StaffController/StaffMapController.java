package com.webapp5.StaffController;

import org.springframework.http.HttpHeaders;

import java.io.IOException;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.webapp5.Staffentity.ExamResult;
import com.webapp5.Staffentity.SubjectNotes;
import com.webapp5.Staffpayload.ExamDto;
import com.webapp5.Staffpayload.ExamResultDto;
import com.webapp5.Staffpayload.ExamResultDtoALL;
import com.webapp5.Staffpayload.StaffDto;
import com.webapp5.Staffpayload.StaffImageDto;
import com.webapp5.Staffpayload.StudentSubjectDto;
import com.webapp5.Staffpayload.SubjectNotesDto;
import com.webapp5.Staffpayload.SubjectsDto;
import com.webapp5.Staffservice.ExamResultService;
import com.webapp5.Staffservice.ExamService;
import com.webapp5.Staffservice.NotesService;
import com.webapp5.Staffservice.StaffImageService;
import com.webapp5.Staffservice.StaffService;
import com.webapp5.Staffservice.SubjectService;
import com.webapp5.Studententity.StudentEntity;
import com.webapp5.Studentpayload.StudentDto;

@Controller
public class StaffMapController {

	@Autowired
	private StaffService staffService;

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private ExamService examService;

	@Autowired
	private ExamResultService examResultService;

	@Autowired
	private StaffImageService imageService;

	@Autowired
	private NotesService notesService;

	@RequestMapping("/staff/staff-dashboard")
	public String staffDashboard() {
		return "staff/teacher-dashboard";
	}

	@RequestMapping("/view-staff")
	public String staff(@RequestParam String usn, @RequestParam String name, @RequestParam String lastname,
			@RequestParam long staffregid, Model model, HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			if (session.getAttribute("usn") != null) {
				List<StaffDto> staffByUsn = staffService.getStaffByUsn(usn);
				model.addAttribute("staff", staffByUsn);
				model.addAttribute("usn", usn);
				model.addAttribute("name", name);
				model.addAttribute("lastname", lastname);
				model.addAttribute("staffregid", staffregid);
				StaffImageDto imageByUsn = imageService.getImageByUsn(usn);
				String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getStaffImageData());
				model.addAttribute("image", base64Image);
				return "staff/teachers";
			} else {

				model.addAttribute("sessionMsg", true);
				return "login";
			}

		} else {
			model.addAttribute("sessionMsg", true);
			return "login";
		}

	}

	@RequestMapping("/edit-teacher")
	public String editStaff(@RequestParam String usn, @RequestParam long id, @RequestParam long staffregid,
			@RequestParam String name, @RequestParam String lastname, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			if (session.getAttribute("usn") != null) {

				StaffDto staffById = staffService.findStaffById(id);
				StaffImageDto imageByUsn = imageService.getImageByUsn(usn);
				String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getStaffImageData());
				model.addAttribute("staff", staffById);
				model.addAttribute("usn", usn);
				model.addAttribute("name", name);
				model.addAttribute("lastname", lastname);
				model.addAttribute("staffregid", staffregid);

				model.addAttribute("image", base64Image);
				model.addAttribute("staffImgId", imageByUsn.getStaffImgId());
				return "staff/edit-teacher";
			} else {

				model.addAttribute("sessionMsg", true);
				return "login";
			}

		} else {
			model.addAttribute("sessionMsg", true);
			return "login";
		}

	}

	@RequestMapping("/updateStaff")
	public String updateStaff(StaffDto dto, @RequestParam long staffregid, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);

		if (session != null) {
			if (session.getAttribute("usn") != null) {
				staffService.createStaff(dto);

				MultipartFile staffImageData = dto.getStaffImageData();
				imageService.updateStaffImage(dto.getStaffImgId(), staffImageData, dto.getUsn());

				List<StaffDto> staffByUsn = staffService.getStaffByUsn(dto.getUsn());
				model.addAttribute("staff", staffByUsn);
				model.addAttribute("usn", dto.getUsn());
				model.addAttribute("name", dto.getFirstName());
				model.addAttribute("staffregid", staffregid);

				StaffImageDto imageByUsn = imageService.getImageByUsn(dto.getUsn());
				String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getStaffImageData());
				model.addAttribute("image", base64Image);

				return "staff/teachers";
			} else {

				model.addAttribute("sessionMsg", true);
				return "login";
			}

		} else {
			model.addAttribute("sessionMsg", true);
			return "login";
		}

	}

	@RequestMapping("/staff-details")
	public String staffDetails(@RequestParam String usn, @RequestParam long staffregid, @RequestParam String name,
			@RequestParam String lastname, Model model, HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		if (session != null) {
			if (session.getAttribute("usn") != null) {
				List<StaffDto> staffByUsn = staffService.getStaffByUsn(usn);
				model.addAttribute("staff", staffByUsn);
				model.addAttribute("usn", usn);
				model.addAttribute("name", name);
				model.addAttribute("lastname", lastname);
				model.addAttribute("staffregid", staffregid);
				StaffImageDto imageByUsn = imageService.getImageByUsn(usn);
				String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getStaffImageData());
				model.addAttribute("image", base64Image);

				return "staff/teacher-details";
			} else {

				model.addAttribute("sessionMsg", true);
				return "login";
			}

		} else {
			model.addAttribute("sessionMsg", true);
			return "login";
		}
	}

	@RequestMapping("/profile")
	public String staffProfile(@RequestParam String name, @RequestParam String lastname, @RequestParam String usn,
			@RequestParam long staffregid, Model model, HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		if (session != null) {
			if (session.getAttribute("usn") != null) {
				List<StaffDto> staffByUsn = staffService.getStaffByUsn(usn);
				model.addAttribute("staff", staffByUsn);
				model.addAttribute("usn", usn);
				model.addAttribute("name", name);
				model.addAttribute("lastname", lastname);
				model.addAttribute("staffregid", staffregid);
				StaffImageDto imageByUsn = imageService.getImageByUsn(usn);
				String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getStaffImageData());
				model.addAttribute("image", base64Image);

				return "staff/profile";
			} else {

				model.addAttribute("sessionMsg", true);
				return "login";
			}

		} else {
			model.addAttribute("sessionMsg", true);
			return "login";
		}
	}

	@RequestMapping("/staff-dashboard")
	public String staffDashboard(@RequestParam String usn, @RequestParam String name, @RequestParam String lastname,
			@RequestParam long staffregid, Model model, HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		if (session != null) {
			if (session.getAttribute("usn") != null) {
				model.addAttribute("usn", usn);
				model.addAttribute("name", name);
				model.addAttribute("lastname", lastname);
				model.addAttribute("staffregid", staffregid);
				StaffImageDto imageByUsn = imageService.getImageByUsn(usn);
				String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getStaffImageData());
				model.addAttribute("image", base64Image);

				return "staff/teacher-dashboard";
			} else {

				model.addAttribute("sessionMsg", true);
				return "login";
			}

		} else {
			model.addAttribute("sessionMsg", true);
			return "login";
		}
	}

	@RequestMapping("/add-subject")
	public String addSubject(@RequestParam String usn, @RequestParam String name, @RequestParam String lastname,
			@RequestParam long staffregid, Model model, HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		if (session != null) {
			if (session.getAttribute("usn") != null) {
				model.addAttribute("usn", usn);
				model.addAttribute("name", name);
				model.addAttribute("lastname", lastname);
				model.addAttribute("staffregid", staffregid);
				StaffImageDto imageByUsn = imageService.getImageByUsn(usn);
				String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getStaffImageData());
				model.addAttribute("image", base64Image);
				return "staff/add-subject";
			} else {

				model.addAttribute("sessionMsg", true);
				return "login";
			}

		} else {
			model.addAttribute("sessionMsg", true);
			return "login";
		}
	}

	@RequestMapping("/addSubject")
	public String Subjectd(SubjectsDto subjectsDto, @RequestParam String usn, @RequestParam String name,
			@RequestParam String lastname, @RequestParam long staffregid, Model model, HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		if (session != null) {
			if (session.getAttribute("usn") != null) {
				if (subjectService.existsBySubjectNameAndCode(subjectsDto.getSubjectName(),
						subjectsDto.getSubjectCode())) {
					model.addAttribute("usn", usn);
					model.addAttribute("name", name);
					model.addAttribute("lastname", lastname);
					model.addAttribute("staffregid", staffregid);
					model.addAttribute("msg", "Subject is already added!");
					List<SubjectsDto> allSubjects = subjectService.getAllSubjects(subjectsDto);
					model.addAttribute("subjects", allSubjects);
					StaffImageDto imageByUsn = imageService.getImageByUsn(usn);
					String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getStaffImageData());
					model.addAttribute("image", base64Image);
					return "staff/add-subject";
				}
				subjectService.addSubject(subjectsDto);

				List<SubjectsDto> allSubjects = subjectService.getAllSubjects(subjectsDto);
				model.addAttribute("subjects", allSubjects);
				model.addAttribute("usn", usn);
				model.addAttribute("name", name);
				model.addAttribute("lastname", lastname);
				model.addAttribute("staffregid", staffregid);
				StaffImageDto imageByUsn = imageService.getImageByUsn(usn);
				String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getStaffImageData());
				model.addAttribute("image", base64Image);
				return "staff/add-subject";

			} else {

				model.addAttribute("sessionMsg", true);
				return "login";
			}

		} else {
			model.addAttribute("sessionMsg", true);
			return "login";
		}
	}

	@RequestMapping("/view-subjects")
	public String allSubjects(@RequestParam String usn, @RequestParam String name, @RequestParam String lastname,
			@RequestParam long staffregid, Model model, HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		if (session != null) {
			if (session.getAttribute("usn") != null) {
				model.addAttribute("usn", usn);
				model.addAttribute("name", name);
				model.addAttribute("lastname", lastname);
				model.addAttribute("staffregid", staffregid);
				StaffImageDto imageByUsn = imageService.getImageByUsn(usn);
				String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getStaffImageData());
				model.addAttribute("image", base64Image);
				return "staff/subjects";
			} else {

				model.addAttribute("sessionMsg", true);
				return "login";
			}

		} else {
			model.addAttribute("sessionMsg", true);
			return "login";
		}

	}

	@RequestMapping("/get-Subjects")
	public String getAllSubjectsByScheme(SubjectsDto subjectsDto, @RequestParam String usn, @RequestParam String name,
			@RequestParam String lastname, @RequestParam long staffregid, Model model, HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		if (session != null) {
			if (session.getAttribute("usn") != null) {

				StaffDto byUsn = staffService.findByUsn(usn);

				List<SubjectsDto> allSubjects = subjectService
						.findAllByDepartmentAndSchemeOrderBySem(byUsn.getDepartment(), subjectsDto.getScheme());
				Set<String> processedSemesters = new HashSet<>();

				model.addAttribute("processedSemesters", processedSemesters);

				model.addAttribute("subjects", allSubjects);
				model.addAttribute("usn", usn);
				model.addAttribute("name", name);
				model.addAttribute("lastname", lastname);
				model.addAttribute("staffregid", staffregid);
				StaffImageDto imageByUsn = imageService.getImageByUsn(usn);
				String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getStaffImageData());
				model.addAttribute("image", base64Image);
				return "staff/subjects";
			} else {

				model.addAttribute("sessionMsg", true);
				return "login";
			}

		} else {
			model.addAttribute("sessionMsg", true);
			return "login";
		}
	}

	@RequestMapping("/edit-subject")
	public String edit_subject(@RequestParam long subid, @RequestParam String usn, @RequestParam String name,
			@RequestParam String lastname, @RequestParam long staffregid, Model model, HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		if (session != null) {
			if (session.getAttribute("usn") != null) {
				SubjectsDto bySubId = subjectService.findBySubId(subid);
				model.addAttribute("subject", bySubId);
				model.addAttribute("usn", usn);
				model.addAttribute("name", name);
				model.addAttribute("lastname", lastname);
				model.addAttribute("staffregid", staffregid);
				model.addAttribute("subid", subid);
				StaffImageDto imageByUsn = imageService.getImageByUsn(usn);
				String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getStaffImageData());
				model.addAttribute("image", base64Image);

				return "staff/edit-subjects";
			} else {

				model.addAttribute("sessionMsg", true);
				return "login";
			}

		} else {
			model.addAttribute("sessionMsg", true);
			return "login";
		}

	}

	@RequestMapping("/editSubject")
	public String editSubject(SubjectsDto subjectsDto, @RequestParam String usn, @RequestParam String name,
			@RequestParam String lastname, @RequestParam long staffregid, Model model, HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		if (session != null) {
			if (session.getAttribute("usn") != null) {

				subjectService.updateSubject(subjectsDto);

				StaffDto byUsn = staffService.findByUsn(usn);

				List<SubjectsDto> allSubjects = subjectService
						.findAllByDepartmentAndSchemeOrderBySem(byUsn.getDepartment(), subjectsDto.getScheme());
				Set<String> processedSemesters = new HashSet<>();

				model.addAttribute("processedSemesters", processedSemesters);

				model.addAttribute("subjects", allSubjects);

				model.addAttribute("usn", usn);
				model.addAttribute("name", name);
				model.addAttribute("lastname", lastname);
				model.addAttribute("staffregid", staffregid);
				StaffImageDto imageByUsn = imageService.getImageByUsn(usn);
				String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getStaffImageData());
				model.addAttribute("image", base64Image);
				return "staff/subjects";
			} else {

				model.addAttribute("sessionMsg", true);
				return "login";
			}

		} else {
			model.addAttribute("sessionMsg", true);
			return "login";
		}

	}

	@RequestMapping("/deleteSubject")
	public String deleteSubject(@RequestParam long subid, @RequestParam String usn, @RequestParam String name,
			@RequestParam String lastname, @RequestParam long staffregid, Model model, HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		if (session != null) {
			if (session.getAttribute("usn") != null) {

				subjectService.deleteById(subid);

				StaffDto byUsn = staffService.findByUsn(usn);

				List<SubjectsDto> allSubjects = subjectService.getAllSubjectsByDepartment(byUsn.getDepartment());
				Set<String> processedSemesters = new HashSet<>();

				model.addAttribute("processedSemesters", processedSemesters);

				model.addAttribute("subjects", allSubjects);

				model.addAttribute("usn", usn);
				model.addAttribute("name", name);
				model.addAttribute("lastname", lastname);
				model.addAttribute("staffregid", staffregid);
				StaffImageDto imageByUsn = imageService.getImageByUsn(usn);
				String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getStaffImageData());
				model.addAttribute("image", base64Image);
				return "staff/subjects";
			} else {

				model.addAttribute("sessionMsg", true);
				return "login";
			}

		} else {
			model.addAttribute("sessionMsg", true);
			return "login";
		}

	}

	@RequestMapping("/exam-declaration")
	public String exam_Declration(@RequestParam String usn, @RequestParam String name, @RequestParam String lastname,
			@RequestParam long staffregid, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);

		if (session != null) {
			if (session.getAttribute("usn") != null) {

				model.addAttribute("usn", usn);
				model.addAttribute("name", name);
				model.addAttribute("lastname", lastname);
				model.addAttribute("staffregid", staffregid);
				StaffImageDto imageByUsn = imageService.getImageByUsn(usn);
				String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getStaffImageData());
				model.addAttribute("image", base64Image);
				return "staff/exam-declaration";
			} else {

				model.addAttribute("sessionMsg", true);
				return "login";
			}

		} else {
			model.addAttribute("sessionMsg", true);
			return "login";
		}

	}

	@RequestMapping("/getSubjects")
	public String examDeclaration(ExamDto dto, @RequestParam String usn, @RequestParam String name,
			@RequestParam String lastname, @RequestParam long staffregid, Model model, HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		if (session != null) {
			if (session.getAttribute("usn") != null) {

				StaffDto byUsn = staffService.findByUsn(usn);
				if (byUsn.getDepartment().equalsIgnoreCase(dto.getDepartment())) {
					List<SubjectsDto> subjectByDepartmentAndSem = subjectService.findSubjectByDepartmentAndSemAndScheme(
							byUsn.getDepartment(), dto.getSem(), dto.getScheme());
					model.addAttribute("subjects", subjectByDepartmentAndSem);

					model.addAttribute("usn", usn);
					model.addAttribute("name", name);
					model.addAttribute("lastname", lastname);
					model.addAttribute("staffregid", staffregid);
					model.addAttribute("sem", dto.getSem());
					model.addAttribute("department", dto.getDepartment());
					model.addAttribute("scheme", dto.getScheme());
					StaffImageDto imageByUsn = imageService.getImageByUsn(usn);
					String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getStaffImageData());
					model.addAttribute("image", base64Image);
					return "staff/exam-declaration";
				}

				model.addAttribute("usn", usn);
				model.addAttribute("name", name);
				model.addAttribute("lastname", lastname);
				model.addAttribute("staffregid", staffregid);
				model.addAttribute("msg", "Data not found");
				StaffImageDto imageByUsn = imageService.getImageByUsn(usn);
				String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getStaffImageData());
				model.addAttribute("image", base64Image);
				return "staff/exam-declaration";
			} else {

				model.addAttribute("sessionMsg", true);
				return "login";
			}

		} else {
			model.addAttribute("sessionMsg", true);
			return "login";
		}

	}

	@RequestMapping("/examDeclared")
	public String exams(ExamDto dto, @RequestParam String usn, @RequestParam String name, @RequestParam String lastname,
			@RequestParam long staffregid, Model model, HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		if (session != null) {
			if (session.getAttribute("usn") != null) {

				if (examService.existsBySubjectNameAndCodeAndExamType(dto.getSubjectName(), dto.getSubjectCode(),
						dto.getExamType())) {
					StaffDto byUsn = staffService.findByUsn(usn);
					List<SubjectsDto> subjectByDepartmentAndSemAndScheme = subjectService
							.findSubjectByDepartmentAndSemAndScheme(byUsn.getDepartment(), dto.getSem(),
									dto.getScheme());
					model.addAttribute("subjects", subjectByDepartmentAndSemAndScheme);

					model.addAttribute("usn", usn);
					model.addAttribute("name", name);
					model.addAttribute("lastname", lastname);
					model.addAttribute("staffregid", staffregid);
					model.addAttribute("sem", dto.getSem());
					model.addAttribute("department", dto.getDepartment());
					model.addAttribute("scheme", dto.getScheme());
					model.addAttribute("examMsg", "Subject is already declare for exam");
					List<ExamDto> exam = examService.getExam(dto.getDepartment(), dto.getSem(), dto.getScheme());

					model.addAttribute("exams", exam);
					StaffImageDto imageByUsn = imageService.getImageByUsn(usn);
					String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getStaffImageData());
					model.addAttribute("image", base64Image);
					return "staff/exam-declaration";
				}
				examService.declareExam(dto);

				StaffDto byUsn = staffService.findByUsn(usn);
				List<SubjectsDto> subjectByDepartmentAndSemAndScheme = subjectService
						.findSubjectByDepartmentAndSemAndScheme(byUsn.getDepartment(), dto.getSem(), dto.getScheme());
				model.addAttribute("subjects", subjectByDepartmentAndSemAndScheme);

				model.addAttribute("usn", usn);
				model.addAttribute("name", name);
				model.addAttribute("lastname", lastname);
				model.addAttribute("staffregid", staffregid);
				model.addAttribute("sem", dto.getSem());
				model.addAttribute("department", dto.getDepartment());
				model.addAttribute("scheme", dto.getScheme());

				List<ExamDto> exam = examService.getExam(dto.getDepartment(), dto.getSem(), dto.getScheme());

				model.addAttribute("exams", exam);
				StaffImageDto imageByUsn = imageService.getImageByUsn(usn);
				String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getStaffImageData());
				model.addAttribute("image", base64Image);
				return "staff/exam-declaration";
			} else {

				model.addAttribute("sessionMsg", true);
				return "login";
			}

		} else {
			model.addAttribute("sessionMsg", true);
			return "login";
		}

	}

	@RequestMapping("/view-exams")
	public String exams(@RequestParam String usn, @RequestParam String name, @RequestParam String lastname,
			@RequestParam long staffregid, Model model, HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		if (session != null) {
			if (session.getAttribute("usn") != null) {
				model.addAttribute("usn", usn);
				model.addAttribute("name", name);
				model.addAttribute("lastname", lastname);
				model.addAttribute("staffregid", staffregid);
				StaffImageDto imageByUsn = imageService.getImageByUsn(usn);
				String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getStaffImageData());
				model.addAttribute("image", base64Image);
				return "staff/exam";
			} else {

				model.addAttribute("sessionMsg", true);
				return "login";
			}

		} else {
			model.addAttribute("sessionMsg", true);
			return "login";
		}
	}

	@RequestMapping("/getExams")
	public String getExams(ExamDto examDto, @RequestParam String usn, @RequestParam String name,
			@RequestParam String lastname, @RequestParam long staffregid, Model model, HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		if (session != null) {
			if (session.getAttribute("usn") != null) {
				List<ExamDto> exams = examService.getAllExamsBYDepartmentAndSemAndExamType(examDto.getDepartment(),
						examDto.getSem(), examDto.getExamType(), examDto.getScheme());
				Set<String> processedSemesters = new HashSet<>();

				model.addAttribute("processedSemesters", processedSemesters);

				model.addAttribute("exams", exams);
				model.addAttribute("usn", usn);
				model.addAttribute("name", name);
				model.addAttribute("lastname", lastname);
				model.addAttribute("staffregid", staffregid);
				StaffImageDto imageByUsn = imageService.getImageByUsn(usn);
				String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getStaffImageData());
				model.addAttribute("image", base64Image);
				return "staff/exam";
			} else {

				model.addAttribute("sessionMsg", true);
				return "login";
			}

		} else {
			model.addAttribute("sessionMsg", true);
			return "login";
		}

	}

	@RequestMapping("/add-exam-result")
	public String examResult(@RequestParam String usn, @RequestParam String name, @RequestParam String lastname,
			@RequestParam long staffregid, Model model, HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		if (session != null) {
			if (session.getAttribute("usn") != null) {
				StaffDto byUsn = staffService.findByUsn(usn);

				model.addAttribute("usn", usn);
				model.addAttribute("name", name);
				model.addAttribute("lastname", lastname);
				model.addAttribute("staffregid", staffregid);
				model.addAttribute("department", byUsn.getDepartment());
				StaffImageDto imageByUsn = imageService.getImageByUsn(usn);
				String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getStaffImageData());
				model.addAttribute("image", base64Image);
				return "staff/add-result";
			} else {

				model.addAttribute("sessionMsg", true);
				return "login";
			}

		} else {
			model.addAttribute("sessionMsg", true);
			return "login";
		}

	}

	@RequestMapping("/addResult")
	public String addResult(ExamResultDto examResultDto, @RequestParam String usn, @RequestParam String name,
			@RequestParam String lastname, @RequestParam long staffregid, Model model, HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		if (session != null) {
			if (session.getAttribute("usn") != null) {

				if (examResultService.existByStudentUsnAndSubjectNameAndSubjectCodeAndExamType(
						examResultDto.getStudentUsn(), examResultDto.getSubjectName(), examResultDto.getSubjectCode(),
						examResultDto.getExamType())) {
					StaffDto byUsn = staffService.findByUsn(usn);

					model.addAttribute("usn", usn);
					model.addAttribute("name", name);
					model.addAttribute("lastname", lastname);
					model.addAttribute("staffregid", staffregid);
					model.addAttribute("department", byUsn.getDepartment());
					model.addAttribute("scheme", examResultDto.getScheme());
					model.addAttribute("examresult", "Result is already added");
					StaffImageDto imageByUsn = imageService.getImageByUsn(usn);
					String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getStaffImageData());
					model.addAttribute("image", base64Image);
					return "staff/add-result";
				}

				examResultService.addResult(examResultDto);

				StaffDto byUsn = staffService.findByUsn(usn);

				List<ExamResultDto> results = examResultService.getResultsByDepartmentAndSemAndExamTypeAndScheme(
						examResultDto.getDepartment(), examResultDto.getSem(), examResultDto.getExamType(),
						examResultDto.getScheme());

				model.addAttribute("usn", usn);
				model.addAttribute("name", name);
				model.addAttribute("lastname", lastname);
				model.addAttribute("staffregid", staffregid);
				model.addAttribute("department", byUsn.getDepartment());
				model.addAttribute("results", results);
				model.addAttribute("scheme", examResultDto.getScheme());
				StaffImageDto imageByUsn = imageService.getImageByUsn(usn);
				String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getStaffImageData());
				model.addAttribute("image", base64Image);
				return "staff/add-result";
			} else {

				model.addAttribute("sessionMsg", true);
				return "login";
			}

		} else {
			model.addAttribute("sessionMsg", true);
			return "login";
		}

	}

	@RequestMapping("/view-result")
	public String viewResult(@RequestParam String usn, @RequestParam String name, @RequestParam String lastname,
			@RequestParam long staffregid, Model model, HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		if (session != null) {
			if (session.getAttribute("usn") != null) {

				StaffDto byUsn = staffService.findByUsn(usn);
				model.addAttribute("usn", usn);
				model.addAttribute("name", name);
				model.addAttribute("lastname", lastname);
				model.addAttribute("staffregid", staffregid);
				model.addAttribute("department", byUsn.getDepartment());
				StaffImageDto imageByUsn = imageService.getImageByUsn(usn);
				String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getStaffImageData());
				model.addAttribute("image", base64Image);
				return "staff/view-results";
			} else {

				model.addAttribute("sessionMsg", true);
				return "login";
			}

		} else {
			model.addAttribute("sessionMsg", true);
			return "login";
		}

	}

	@RequestMapping("/viewResults")
	public String Results(ExamResultDto examResultDto, @RequestParam String usn, @RequestParam String name,
			@RequestParam String lastname, @RequestParam long staffregid, Model model, HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		if (session != null) {
			if (session.getAttribute("usn") != null) {
				List<ExamResultDto> result = examResultService.getResultByStudentUsnAndDepartmentAndSchemeAndExamType(
						examResultDto.getStudentUsn(), examResultDto.getDepartment(), examResultDto.getScheme(),
						examResultDto.getExamType());

				Set<String> processedSemesters = new HashSet<>();

				StaffDto byUsn = staffService.findByUsn(usn);

				model.addAttribute("processedSemesters", processedSemesters);

				model.addAttribute("usn", usn);
				model.addAttribute("name", name);
				model.addAttribute("lastname", lastname);
				model.addAttribute("staffregid", staffregid);
				model.addAttribute("department", byUsn.getDepartment());
				model.addAttribute("studentUsn", examResultDto.getStudentUsn());
				model.addAttribute("scheme", examResultDto.getScheme());
				model.addAttribute("results", result);
				StaffImageDto imageByUsn = imageService.getImageByUsn(usn);
				String base64Image = Base64.getEncoder().encodeToString(imageByUsn.getStaffImageData());
				model.addAttribute("image", base64Image);
				return "staff/view-results";
			} else {

				model.addAttribute("sessionMsg", true);
				return "login";
			}

		} else {
			model.addAttribute("sessionMsg", true);
			return "login";
		}
	}

	@RequestMapping("/upload-notes")
	public String uploadNotes(@RequestParam String usn, @RequestParam String name, @RequestParam String lastname,
			@RequestParam long staffregid, @RequestParam String subjectCode, @RequestParam String subjectName,
			Model model) {
		List<SubjectNotes> allNotesBySubjectCode = notesService.getAllNotesBySubjectCode(subjectCode);
		model.addAttribute("usn", usn);
		model.addAttribute("notes", allNotesBySubjectCode);

		model.addAttribute("name", name);
		model.addAttribute("lastname", lastname);
		model.addAttribute("staffregid", staffregid);
		model.addAttribute("subjectName", subjectName);
		model.addAttribute("subjectCode", subjectCode);
		return "staff/upload-notes";
	}

	@RequestMapping("/uploadNotes")
	public String addNotes(SubjectNotesDto dto, @RequestParam String usn, @RequestParam String name,
			@RequestParam String lastname, @RequestParam long staffregid, Model model) {
		MultipartFile sujectNotesFile = dto.getSujectNotesFile();

		notesService.uploadNotes(sujectNotesFile, dto.getFileName(), dto.getSubjectCode(), dto.getSubjectName());
		List<SubjectNotes> allNotesBySubjectCode = notesService.getAllNotesBySubjectCode(dto.getSubjectCode());
		model.addAttribute("usn", usn);
		model.addAttribute("notes", allNotesBySubjectCode);
		model.addAttribute("name", name);
		model.addAttribute("lastname", lastname);
		model.addAttribute("staffregid", staffregid);
		model.addAttribute("subjectName", dto.getSubjectName());
		model.addAttribute("subjectCode", dto.getSubjectCode());
		return "staff/upload-notes";
	}

	@RequestMapping("/download-notes")
	public ResponseEntity<byte[]> download(@RequestParam String fileName) throws IOException {

		SubjectNotes byFileName = notesService.findByFileName(fileName);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + byFileName.getFileName() + "\"")
				.body(byFileName.getNotesData());

	}

	@RequestMapping("/delete-notes")
	public String deleteNotes(@RequestParam long notesid, @RequestParam String subjectCode,
			@RequestParam String subjectName, @RequestParam String usn, @RequestParam String name,
			@RequestParam String lastname, @RequestParam long staffregid, Model model) {

		notesService.deleteById(notesid);
		List<SubjectNotes> allNotesBySubjectCode = notesService.getAllNotesBySubjectCode(subjectCode);
		model.addAttribute("notes", allNotesBySubjectCode);
		model.addAttribute("usn", usn);
		model.addAttribute("name", name);
		model.addAttribute("lastname", lastname);
		model.addAttribute("staffregid", staffregid);
		model.addAttribute("subjectName", subjectName);
		model.addAttribute("subjectCode", subjectCode);
		return "staff/upload-notes";
	}

	@RequestMapping("/findAllStudents")
	public String findStudents(ExamResultDto dto, @RequestParam String usn, @RequestParam String name,
			@RequestParam String lastname, @RequestParam long staffregid, Model model) {
		StaffDto byUsn = staffService.findByUsn(usn);

		StudentSubjectDto allStudents = staffService.findAllStudents(byUsn.getDepartment(), dto.getSem(),
				dto.getScheme());
		if (allStudents != null) {
			
			model.addAttribute("student", allStudents.getStudents());
			model.addAttribute("subjects", allStudents.getSubjects());
			model.addAttribute("usn", usn);
			model.addAttribute("sem", dto.getSem());
			model.addAttribute("scheme", dto.getScheme());
		
			model.addAttribute("name", name);
			model.addAttribute("lastname", lastname);
			model.addAttribute("staffregid", staffregid);
			model.addAttribute("department", byUsn.getDepartment());
		}

		return "staff/add-result";
	}

	@RequestMapping("/subject")
	public String subject(ExamResultDto dto, @RequestParam String usn, @RequestParam String name,
			@RequestParam String lastname, @RequestParam long staffregid, Model model) {
		StaffDto byUsn = staffService.findByUsn(usn);
		
		StudentSubjectDto allStudents = staffService.findAllStudents(byUsn.getDepartment(), dto.getSem(),
				dto.getScheme());
		if (allStudents != null) {

			
			
			
			model.addAttribute("student", allStudents.getStudents());
			model.addAttribute("subjects", allStudents.getSubjects());
			model.addAttribute("subjectName", dto.getSubjectName());
			model.addAttribute("usn", usn);
			model.addAttribute("name", name);
			model.addAttribute("sem", dto.getSem());
			model.addAttribute("lastname", lastname);
			model.addAttribute("staffregid", staffregid);
			model.addAttribute("department", byUsn.getDepartment());
			model.addAttribute("scheme", dto.getScheme());
			
			
			
			return "staff/add-result";
		}
		return "staff/add-result";
		
	}
	
	@RequestMapping("/Declare-result")
	public String result(ExamResultDto dto,@RequestParam String usn, @RequestParam String name,
			@RequestParam String lastname, @RequestParam long staffregid, Model model) {
		
		staffService.updateResult(dto);
		
		StudentSubjectDto allStudents = staffService.findAllStudents(dto.getDepartment(), dto.getSem(),
				dto.getScheme());
		
        Map<String, ExamResult> results = staffService.getResultsByStudentUsn(dto.getStudentUsn());
       
       
        
        model.addAttribute("student", allStudents.getStudents());
		model.addAttribute("subjects", allStudents.getSubjects());
		model.addAttribute("subjectName", dto.getSubjectName());
		model.addAttribute("usn", usn);
		model.addAttribute("name", name);
		model.addAttribute("sem", dto.getSem());
		model.addAttribute("lastname", lastname);
		model.addAttribute("staffregid", staffregid);
		model.addAttribute("department", dto.getDepartment());
		model.addAttribute("scheme", dto.getScheme());
		model.addAttribute("results", results);
		
		return "staff/add-result";
	}

}
