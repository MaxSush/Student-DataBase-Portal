package com.webapp5.Studentrepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp5.Studententity.ImageEntity;
import com.webapp5.Studentpayload.ImageDto;

public interface ImageRepository extends JpaRepository<ImageEntity, Long> {

	ImageEntity findImageByUsn(String usn);

	void deleteByUsn(String studentusn);

}
