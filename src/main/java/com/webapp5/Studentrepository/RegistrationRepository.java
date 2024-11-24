package com.webapp5.Studentrepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp5.Studententity.RegistrationEntity;
import com.webapp5.Studentpayload.RegistrationDto;


public interface RegistrationRepository extends JpaRepository<RegistrationEntity, Long>{

	Optional<RegistrationEntity> findByUsn(String usn);
	RegistrationEntity findByEmail(String email);
	
	boolean existsByEmail(String email);
	void deleteByUsn(String studentusn);
	Optional<RegistrationEntity> getByUsn(String usn);
	
}
