package com.webapp5.accountantService;

import java.io.IOException;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.webapp5.AccountantPayload.FeesPayload;
import com.webapp5.accountantEntity.FeesAmount;
import com.webapp5.accountantEntity.TotalFees;
import com.webapp5.accountantRepository.FeesAmountRepository;
import com.webapp5.accountantRepository.TotalFeesRepo;

@Service
public class FeesAmountService {

	@Autowired
	private FeesAmountRepository amountRepository;
	
	
	
	public void addFees(FeesPayload dto) {
		
		try {
			MultipartFile feesImageData = dto.getFeesImageData();
			
			FeesAmount amount=new FeesAmount();
			amount.setRecieptId(dto.getRecieptId());
			amount.setStudentUsn(dto.getStudentUsn());
			amount.setDepartment(dto.getDepartment());
			amount.setDate(dto.getDate());
			amount.setFeesAmount(dto.getFeesAmount());
			amount.setSem(dto.getSem());
			amount.setYear(dto.getYear());
			amount.setFeesReciptimg(feesImageData.getBytes());
			
			amountRepository.save(amount);
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}



	public List<FeesAmount> getAll() {
		List<FeesAmount> all = amountRepository.findAll();
		return all;
		
	}
	
	
	
	
	

}
