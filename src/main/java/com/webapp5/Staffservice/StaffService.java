package com.webapp5.Staffservice;



import java.util.List;
import java.util.Map;

import com.webapp5.Staffentity.ExamResult;
import com.webapp5.Staffpayload.ExamResultDto;
import com.webapp5.Staffpayload.StaffDto;
import com.webapp5.Staffpayload.StudentSubjectDto;
import com.webapp5.Studentpayload.RegistrationDto;

public interface StaffService {

	void createRegistration(RegistrationDto dto);

	List<StaffDto> getStaffByUsn(String usn);

	StaffDto findStaffById(long id);

	void createStaff(StaffDto dto);

	void updateStaff(StaffDto staffById);

	StaffDto findByUsn(String usn);

	StudentSubjectDto findAllStudents(String department, String sem, String Scheme);

	List<ExamResultDto> getResult(String sem, String department, String string);

	void updateResult(ExamResultDto dto);

	Map<String, ExamResult> getResultsByStudentUsn(String studentUsn);

	

	

}
