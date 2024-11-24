package com.webapp5.Studentservice;

import java.util.Optional;

import com.webapp5.Studententity.RegistrationEntity;
import com.webapp5.Studentpayload.RegistrationDto;

public interface RegistrationService {

	RegistrationEntity getRegistrationByUsn(String usn);

	void createRegistration(RegistrationDto dto);

	RegistrationDto getRegistrationByEmail(String email);

	RegistrationDto getRegistrationById(long id);

	void updateRegistration(RegistrationDto registrationById2);
	
	boolean existsByEmail(String email);

	Optional<RegistrationEntity> getByUsn(String usn);
	

}
