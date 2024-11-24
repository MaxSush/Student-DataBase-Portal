package com.webapp5.AdminRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp5.AdminEntity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	Optional<Admin> findAdminByUsnAndPassword(String usn, String password);

	List<Admin> findByUsn(String usn);

	Admin findByAdminId(long adminId);

	Optional<Admin> findByDepartment(String department);

}
