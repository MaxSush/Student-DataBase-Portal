package com.webapp5.Staffservice;

import java.io.IOException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.webapp5.StaffRepository.StaffImageRepository;
import com.webapp5.Staffentity.StaffImageEntity;
import com.webapp5.Staffpayload.StaffImageDto;


@Service
public class StaffImageServiceImpl implements StaffImageService {
	
	@Autowired
	private StaffImageRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public StaffImageDto getImageByUsn(String usn) {
		 StaffImageEntity byUsn = repository.findByUsn(usn);
		return mapToDto(byUsn);
	}

	@Override
	public void storeDefaultImag(String usn, byte[] defaultImageBytes) {
		StaffImageEntity entity=new StaffImageEntity();
		entity.setData(defaultImageBytes);
		entity.setType("image/jpg");
		entity.setUsn(usn);
		repository.save(entity);
		
	}
	@Override
	public void updateStaffImage(Long staffImgId, MultipartFile staffImageData, String usn) {
		StaffImageEntity entity=new StaffImageEntity();
		try {
			entity.setData(staffImageData.getBytes());
			entity.setImgId(staffImgId);
			entity.setType("image/jpg");
			entity.setUsn(usn);
			repository.save(entity);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	StaffImageDto mapToDto(StaffImageEntity entity){
		return modelMapper.map(entity, StaffImageDto.class);
	}

	

	


	
}
