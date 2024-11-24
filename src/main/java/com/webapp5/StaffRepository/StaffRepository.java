package com.webapp5.StaffRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp5.Staffentity.StaffEntity;

public interface StaffRepository extends JpaRepository<StaffEntity, Long>{

	Optional<StaffEntity> findStaffByUsnAndPassword(String usn,String password);
	
	List<StaffEntity> getStaffByUsn(String usn);
	
	StaffEntity findByusn(String usn);

	List<StaffEntity> findAllByDepartment(String department);

	void deleteByUsn(String staffusn);
	
}
