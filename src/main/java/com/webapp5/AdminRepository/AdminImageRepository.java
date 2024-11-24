package com.webapp5.AdminRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp5.AdminEntity.AdminImage;

public interface AdminImageRepository extends JpaRepository<AdminImage, Long> {

	AdminImage findByUsn(String usn);

}
