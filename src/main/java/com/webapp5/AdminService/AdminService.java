package com.webapp5.AdminService;

import java.util.List;
import java.util.Optional;

import com.webapp5.AdminEntity.Admin;
import com.webapp5.AdminPayload.AdminDto;
import com.webapp5.AdminPayload.AdminRegistrationDto;
import com.webapp5.Staffentity.StaffEntity;
import com.webapp5.Staffpayload.ExamResultDto;
import com.webapp5.Staffpayload.StaffDto;
import com.webapp5.Studentpayload.RegistrationDto;
import com.webapp5.Studentpayload.StudentDto;

public interface AdminService {

	Optional<AdminRegistrationDto> getAdminRegistrationByUsn(String usn);

	boolean existsBYEmail(String email);

	void createAdmin(RegistrationDto dto);

	List<StudentDto> findAllStudentsByDepartment(String department);

	List<StudentDto> findFirst5ByDepartmentOrderByCreatedDateDesc(String department);

	List<AdminDto> findadmin(String usn);

	AdminDto findById(long adminId);

	void updateAdmin(AdminDto adminDto);

	List<StudentDto> findStudentByCategoryAndDepartment(String category,String department);

	List<StudentDto> findBySemAndDepartment(String sem,String department);

	List<StudentDto> findStudentByUsn(String usn);

	List<ExamResultDto> getExamResultByUsn(String studentusn);

	List<ExamResultDto> getExamResultByUsnAndExamType(String studentUsn, String examType);

	void deleteStudentByUsn(String studentusn);

	List<StaffDto> AllStaffByDepartment(String department);

	void promoteStudents(StudentDto dto,String department);

	List<StudentDto> findTop100StudentsByDepartmentOrderBySem(String department);

	Optional<Admin> findAdminByDepartment(String department);

	List<StaffEntity> findAllStaffsByDepartment(String department);

	void deleteStaffByUsn(String staffusn);

}
