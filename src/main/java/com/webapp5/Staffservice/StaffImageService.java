package com.webapp5.Staffservice;

import org.springframework.web.multipart.MultipartFile;

import com.webapp5.Staffpayload.StaffImageDto;


public interface StaffImageService {

	StaffImageDto getImageByUsn(String usn);

	void storeDefaultImag(String usn, byte[] defaultImageBytes);

	void updateStaffImage(Long staffImgId, MultipartFile staffImageData, String usn);

	

}
