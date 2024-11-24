package com.webapp5.Studentrepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.webapp5.Studententity.StudentEntity;
import com.webapp5.Studentpayload.StudentDto;

public interface StudentRepository extends JpaRepository<StudentEntity, Long>{
	
	Optional<StudentEntity> findByUsnAndPassword(String usn,String password);
	
	Optional<StudentEntity> findByUsn(String usn);
	
	 
	 
	
	
	List<StudentEntity> getByUsn(String usn);
	
	List<StudentEntity> getById(long id);
	
	Optional<StudentDto> findByUsnAndSem(String usn,String sem);
	
	List<StudentEntity> getByUsnAndSem(String usn,String sem);
	
	Optional<StudentDto> searchByUsn(String usn);

	List<StudentEntity> findAllByDepartmentOrderBySem(String department);

	

	List<StudentEntity> findTop5ByDepartmentOrderByCreatedAtDesc(String department);

	List<StudentEntity> findBycategoryAndDepartment(String category,String department);

	List<StudentEntity> findAllByDepartmentAndSem(String department, String sem);

	void deleteByUsn(String studentusn);

	List<StudentEntity> findTop50StudentsByDepartmentOrderBySem(String department);

	List<StudentEntity> getByUsnAndPassword(String usn, String password);
	
	List<StudentEntity> findByCategory(String filterBy);
	
	List<StudentEntity> findAllByDepartment(String department);

	Page<StudentEntity> findByDepartmentOrderBySem(String department, Pageable pageable);
	
	

}
