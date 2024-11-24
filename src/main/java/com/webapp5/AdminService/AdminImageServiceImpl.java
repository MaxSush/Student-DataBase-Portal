package com.webapp5.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp5.AdminEntity.AdminImage;
import com.webapp5.AdminRepository.AdminImageRepository;

@Service
public class AdminImageServiceImpl implements AdminImageService {

	@Autowired
	private AdminImageRepository adminImageRepository;
	@Override
	public void storeDefaultImag(String usn, byte[] defaultImageBytes) {
		AdminImage image=new AdminImage();
		image.setAdminImageData(defaultImageBytes);
		image.setType("image/jpg");
		image.setUsn(usn);
		adminImageRepository.save(image);
	}

}
