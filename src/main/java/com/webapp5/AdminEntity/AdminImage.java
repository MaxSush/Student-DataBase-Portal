package com.webapp5.AdminEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class AdminImage {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long adminImgId;
	private String usn;
	private String type;
	
	@Lob
    @Column(length=100000)
	private  byte [] adminImageData;

	public long getAdminImgId() {
		return adminImgId;
	}

	public void setAdminImgId(long adminImgId) {
		this.adminImgId = adminImgId;
	}

	public String getUsn() {
		return usn;
	}

	public void setUsn(String usn) {
		this.usn = usn;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getAdminImageData() {
		return adminImageData;
	}

	public void setAdminImageData(byte[] adminImageData) {
		this.adminImageData = adminImageData;
	}
	
	
	
	
	
	
	
}
