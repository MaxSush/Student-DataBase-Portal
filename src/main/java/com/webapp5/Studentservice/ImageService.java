package com.webapp5.Studentservice;

import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.webapp5.AdminEntity.AdminImage;
import com.webapp5.Studentpayload.ImageDto;

public interface ImageService {

	ImageDto getImageByUsn(String usn);

	void uplodImage(MultipartFile imageData, String usn,long imgId);

	void storeDefaultImag(String usn, byte[] defaultImageBytes);

	AdminImage getImageByAdminUsn(String usn);

	void updateAdminImage(long adminImgId, MultipartFile adminImageData, String usn);

}
