package com.webapp5.accountantService;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp5.Studentpayload.RegistrationDto;
import com.webapp5.accountantEntity.Accountant;
import com.webapp5.accountantEntity.AccountantRegistration;
import com.webapp5.accountantRepository.AccountantRegRepository;

@Service
public class AccountantRegistrationService {

	@Autowired
	private AccountantRegRepository accountantRegRepository;
	
	@Autowired
	private ModelMapper  modelMapper;
	
	public Optional<AccountantRegistration> getByUsn(String usn) {
		
		Optional<AccountantRegistration> byUsn = accountantRegRepository.findByUsn(usn);
		
		return byUsn;
		
	}

	public boolean existsBYEmail(String email) {
		accountantRegRepository.existsByEmail(email);
		return false;
	}

	public void createAccountant(RegistrationDto dto) {
		AccountantRegistration mapToEntity = mapToEntity(dto);
		accountantRegRepository.save(mapToEntity);
		
	}
	
	AccountantRegistration mapToEntity(RegistrationDto dto){
		return modelMapper.map(dto, AccountantRegistration.class);
	}

}
