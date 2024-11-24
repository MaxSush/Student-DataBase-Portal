package com.webapp5.AdminRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp5.AdminEntity.Admin;
import com.webapp5.AdminEntity.AdminRegistration;
import com.webapp5.AdminPayload.AdminRegistrationDto;

public interface AdminRegistrationRepository extends JpaRepository<AdminRegistration, Long> {

	Optional<AdminRegistrationDto> findByUsn(String usn);

	boolean existsByEmail(String email);

	Optional<AdminRegistration> getByUsn(String usn);

	AdminRegistration findByAdminRegId(long adminRegId);

	AdminRegistration findByEmail(String email);

}
