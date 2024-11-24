package com.webapp5.StaffRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp5.Staffentity.StaffImageEntity;
import com.webapp5.Staffpayload.StaffImageDto;

public interface StaffImageRepository extends JpaRepository<StaffImageEntity, Long> {

	StaffImageEntity findByUsn(String usn);

	void deleteByUsn(String staffusn);

	

}
