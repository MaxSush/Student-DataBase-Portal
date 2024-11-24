package com.webapp5.accountantService;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp5.AccountantPayload.FeesPayload;
import com.webapp5.AccountantPayload.TotalFeesDto;
import com.webapp5.accountantEntity.TotalFees;
import com.webapp5.accountantRepository.TotalFeesRepo;

@Service
public class TotalFeesService {

	@Autowired
	private TotalFeesRepo feesRepo;

	@Autowired
	private ModelMapper mapper;

	public void addAmount(TotalFeesDto dto) {
		TotalFees mapToEntity = mapToEntity(dto);
		feesRepo.save(mapToEntity);

	}

	public TotalFees getByUsn(FeesPayload dto) {
		TotalFees byStudentUsn = feesRepo.findByStudentUsn(dto.getStudentUsn());
		return byStudentUsn;
	}

	public boolean updateFees(FeesPayload dto) {

		int feesAmount = dto.getFeesAmount();

		TotalFees byStudentUsn = feesRepo.findByStudentUsn(dto.getStudentUsn());

		String studentUsn2 = byStudentUsn.getStudentUsn();

		if (studentUsn2 != null && dto.getYear().equals(byStudentUsn.getYear())) {
			feesAmount += byStudentUsn.getPaidFees();

			int remainingFees = byStudentUsn.getTotalAmout() - feesAmount;

			byStudentUsn.setPaidFees(feesAmount);
			byStudentUsn.setRemainingFees(remainingFees);
			byStudentUsn.setStudentname(dto.getStudentname());
			feesRepo.save(byStudentUsn);

			return true;

		}
		return false;

	}

	public List<TotalFees> getAllEntries() {
		List<TotalFees> all = feesRepo.findAll();
		return all;
	}

	TotalFees mapToEntity(TotalFeesDto dto) {
		return mapper.map(dto, TotalFees.class);
	}

}
