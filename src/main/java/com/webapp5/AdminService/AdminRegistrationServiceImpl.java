package com.webapp5.AdminService;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp5.AdminEntity.Admin;
import com.webapp5.AdminEntity.AdminRegistration;
import com.webapp5.AdminPayload.AdminRegistrationDto;
import com.webapp5.AdminRepository.AdminRegistrationRepository;
import com.webapp5.Studentpayload.RegistrationDto;

@Service
public class AdminRegistrationServiceImpl implements AdminRegistartionService {

	@Autowired
	private AdminRegistrationRepository adminRegistrationRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public void createAdminRegistration(RegistrationDto dto) {
		AdminRegistration mapToEntity = mapToEntity(dto);
		adminRegistrationRepository.save(mapToEntity);

	}

	@Override
	public Optional<AdminRegistration> getRegistrationByUsn(String usn) {
		Optional<AdminRegistration> byUsn = adminRegistrationRepository.getByUsn(usn);
		return byUsn;
	}

	@Override
	public AdminRegistrationDto findById(long adminRegId) {
		AdminRegistration byAdminRegId = adminRegistrationRepository.findByAdminRegId(adminRegId);
		return mapToDto(byAdminRegId);
	}

	@Override
	public void updateRegistration(AdminRegistrationDto byId2) {
		AdminRegistration mapToEntity = mapToEntity(byId2);
		adminRegistrationRepository.save(mapToEntity);
	}

	@Override
	public boolean existsByEmail(String email) {
		boolean existsByEmail = adminRegistrationRepository.existsByEmail(email);
		return existsByEmail;
	}

	@Override
	public AdminRegistrationDto getAdminRegistrationByEmail(String email) {
		AdminRegistration byEmail = adminRegistrationRepository.findByEmail(email);
		return mapToDto(byEmail);
	}

	AdminRegistration mapToEntity(RegistrationDto dto) {
		return mapper.map(dto, AdminRegistration.class);
	}

	AdminRegistrationDto mapToDto(AdminRegistration admin) {
		return mapper.map(admin, AdminRegistrationDto.class);
	}

	AdminRegistration mapToEntity(AdminRegistrationDto dto) {
		return mapper.map(dto, AdminRegistration.class);
	}

}
