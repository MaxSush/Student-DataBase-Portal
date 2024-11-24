package com.webapp5.StaffRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp5.Staffentity.StaffRegistration;

public interface StaffRegistrationRepository extends JpaRepository<StaffRegistration, Long>{

	Optional<StaffRegistration> findRegistrationByUsn(String usn);
	boolean existsByEmail(String email);
	StaffRegistration findByEmail(String email);
	void deleteByUsn(String staffusn);
}
