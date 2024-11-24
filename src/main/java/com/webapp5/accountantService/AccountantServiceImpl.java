package com.webapp5.accountantService;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp5.Studentpayload.RegistrationDto;
import com.webapp5.accountantEntity.Accountant;
import com.webapp5.accountantEntity.AccountantRegistration;
import com.webapp5.accountantRepository.AccountantRegRepository;
import com.webapp5.accountantRepository.AccountantRepository;

@Service
public class AccountantServiceImpl {
	
	@Autowired 
	private AccountantRepository accountantRepository;
	@Autowired
	private ModelMapper  modelMapper;
	
	@Autowired 
	private AccountantRegRepository  accountantRegRepository;
	
	public void create(RegistrationDto dto) {
		Accountant mapToEntity = mapToEntity(dto);
		accountantRepository.save(mapToEntity);
		
	}
	
	Accountant mapToEntity(RegistrationDto dto){
		
		return modelMapper.map(dto, Accountant.class);
	}

	public Optional<AccountantRegistration> getAccountantRegistrationByUsn(String usn) {
		
		Optional<AccountantRegistration> byUsn = accountantRegRepository.findByUsn(usn);
		return byUsn;
		
	}
	

}
