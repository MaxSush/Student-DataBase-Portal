package com.webapp5.Studentservice;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp5.Studententity.RegistrationEntity;
import com.webapp5.Studentpayload.RegistrationDto;
import com.webapp5.Studentrepository.RegistrationRepository;
import com.webapp5.exception.PasswordNotFoundException;
import com.webapp5.exception.ResourceNotFound;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	private RegistrationRepository registrationRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public  RegistrationEntity getRegistrationByUsn(String usn) {
		 RegistrationEntity registrationEntity = registrationRepository.findByUsn(usn).orElseThrow(
				 ()-> new ResourceNotFound("You Are Not Registered Yet ...")
				 );
				 
				
		
		return registrationEntity;
	}

	@Override
	public void createRegistration(RegistrationDto dto) {
		RegistrationEntity mapToEntity = mapToEntity(dto);
		registrationRepository.save(mapToEntity);
	}
	
	@Override
	public RegistrationDto getRegistrationByEmail(String email) {
		RegistrationEntity byEmail = registrationRepository.findByEmail(email);
		RegistrationDto mapToDto = mapToDto(byEmail);
		return mapToDto;
		
	}
	@Override
	public RegistrationDto getRegistrationById(long id) {
		RegistrationEntity registrationEntity = registrationRepository.findById(id).orElseThrow(
				()-> new PasswordNotFoundException("Wrong Password")
				);
		RegistrationDto mapToDto = mapToDto(registrationEntity);
		return mapToDto;
		
	}
	
	@Override
	public void updateRegistration(RegistrationDto registrationById2) {
		RegistrationEntity mapToEntity = mapToEntity(registrationById2);
		registrationRepository.save(mapToEntity);
		
	}
	
	@Override
	public boolean existsByEmail(String email) {
		
		return registrationRepository.existsByEmail(email);
	}
	
	@Override
	public Optional<RegistrationEntity> getByUsn(String usn) {
		Optional<RegistrationEntity> byUsn = registrationRepository.getByUsn(usn);
		return byUsn;
	}

	RegistrationEntity mapToEntity(RegistrationDto dto){
		return modelMapper.map(dto, RegistrationEntity.class);
	}

	RegistrationDto mapToDto(RegistrationEntity entity){
		return modelMapper.map(entity, RegistrationDto.class);
	}

	
	

	

	

}
