package com.webapp5.Staffservice;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp5.StaffRepository.StaffRegistrationRepository;
import com.webapp5.Staffentity.StaffEntity;
import com.webapp5.Staffentity.StaffRegistration;
import com.webapp5.Staffpayload.StaffRegistrationDto;
import com.webapp5.Studentpayload.RegistrationDto;
import com.webapp5.exception.PasswordNotFoundException;

@Service
public class StaffRegistrationServiceImpl implements StaffRegistrationService {
	
	@Autowired
	private StaffRegistrationRepository staffRegistrationRepository;
	
	@Autowired
	private ModelMapper  modelMapper;

	@Override
	public Optional<StaffRegistration> getRegistrationByUsn(String usn) {
		Optional<StaffRegistration> registrationByUsn = staffRegistrationRepository.findRegistrationByUsn(usn);
		return registrationByUsn;
	}

	@Override
	public void createRegistration(RegistrationDto dto) {
		
		 StaffRegistration mapToEntity = mapToEntity(dto);
		
		staffRegistrationRepository.save(mapToEntity);
		
	}
	@Override
	public StaffRegistrationDto getRegistrationById(long id) {
		StaffRegistration staffRegistration = staffRegistrationRepository.findById(id).orElseThrow(
				()-> new PasswordNotFoundException("Invalid passowrd")
				);
		
		StaffRegistrationDto mapToDto = mapToDto(staffRegistration);
		return mapToDto;
	}
	
	@Override
	public void updateStaffReg(StaffRegistrationDto registrationById3) {
		StaffRegistration mapToEntity = mapToEntity(registrationById3);
		staffRegistrationRepository.save(mapToEntity);
		
	}
	
	@Override
	public boolean existsByEmail(String email) {
		boolean existsByEmail = staffRegistrationRepository.existsByEmail(email);
		return existsByEmail;
	}
	
	@Override
	public StaffRegistrationDto getRegistrationByEmail(String email) {
		StaffRegistration byEmail = staffRegistrationRepository.findByEmail(email);
		StaffRegistrationDto mapToDto = mapToDto(byEmail);
		return mapToDto;
	}
	
	StaffRegistration mapToEntity(RegistrationDto dto){
		return modelMapper.map(dto, StaffRegistration.class);
	}
	
	StaffRegistration mapToEntity(StaffRegistrationDto dto){
		return modelMapper.map(dto, StaffRegistration.class);
	}
	StaffRegistrationDto mapToDto(StaffRegistration staffRegistration) {
		return modelMapper.map(staffRegistration, StaffRegistrationDto.class);
	}

	

	

	
	
}
