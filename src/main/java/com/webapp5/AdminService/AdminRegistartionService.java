package com.webapp5.AdminService;

import java.util.Optional;


import com.webapp5.AdminEntity.AdminRegistration;
import com.webapp5.AdminPayload.AdminRegistrationDto;
import com.webapp5.Studentpayload.RegistrationDto;

public interface AdminRegistartionService {

	void createAdminRegistration(RegistrationDto dto);

	Optional<AdminRegistration> getRegistrationByUsn(String usn);

	AdminRegistrationDto findById(long adminRegId);

	void updateRegistration(AdminRegistrationDto byId2);

	boolean existsByEmail(String email);

	AdminRegistrationDto getAdminRegistrationByEmail(String email);

}
