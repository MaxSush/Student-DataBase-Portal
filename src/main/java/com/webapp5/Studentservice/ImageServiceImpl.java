package com.webapp5.Studentservice;

import java.io.IOException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.webapp5.AdminEntity.AdminImage;
import com.webapp5.AdminRepository.AdminImageRepository;
import com.webapp5.Studententity.ImageEntity;
import com.webapp5.Studentpayload.ImageDto;
import com.webapp5.Studentrepository.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageRepository imageRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AdminImageRepository adminimgRepository;
	
	@Override
	public ImageDto getImageByUsn(String usn) {
		  ImageEntity imageByUsn = imageRepository.findImageByUsn(usn);
		return mapToDto(imageByUsn);
	}
	
	@Override
	public void uplodImage(MultipartFile imageData, String usn,long imgId) {
		ImageEntity entity=new  ImageEntity();
		try {
			entity.setData(imageData.getBytes());
			entity.setUsn(usn);
			entity.setType("image/jpg");
			entity.setImgId(imgId);
			imageRepository.save(entity);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public void storeDefaultImag(String usn, byte[] defaultImageBytes) {
		ImageEntity entity=new  ImageEntity();
		entity.setUsn(usn);
		entity.setData(defaultImageBytes);
		entity.setType("image/jpg");
		imageRepository.save(entity);
		
	}
	
	ImageDto mapToDto(ImageEntity entity){
		return modelMapper.map(entity, ImageDto.class);
	}

	@Override
	public AdminImage getImageByAdminUsn(String usn) {
		AdminImage byUsn = adminimgRepository.findByUsn(usn);
		return byUsn;
	}

	@Override
	public void updateAdminImage(long adminImgId, MultipartFile adminImageData, String usn) {
		AdminImage admin=new AdminImage();
		admin.setUsn(usn);
		try {
			admin.setAdminImageData(adminImageData.getBytes());
			admin.setType(adminImageData.getContentType());
			admin.setAdminImgId(adminImgId);
			adminimgRepository.save(admin);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

	

}
