package com.webapp5.Staffservice;

import java.util.Optional;

import com.webapp5.Staffentity.StaffRegistration;
import com.webapp5.Staffpayload.StaffRegistrationDto;
import com.webapp5.Studentpayload.RegistrationDto;

public interface StaffRegistrationService {

    Optional<StaffRegistration> getRegistrationByUsn(String usn);

	void createRegistration(RegistrationDto dto);

	StaffRegistrationDto getRegistrationById(long id);

	void updateStaffReg(StaffRegistrationDto registrationById3);

	boolean existsByEmail(String email);

	StaffRegistrationDto getRegistrationByEmail(String email);

}
