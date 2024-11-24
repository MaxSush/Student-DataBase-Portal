package com.webapp5.Staffentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="staff_images")
public class StaffImageEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long staffImgId;
   
    private String type;
    private String usn;

    @Lob
    @Column(length=100000)
    private byte[] staffImageData;

    public StaffImageEntity() {
    }

    public  StaffImageEntity( String type, byte[] staffImageData,String usn) {
      
        this.type = type;
        this.staffImageData = staffImageData;
        this.usn = usn;
    }

    
    public String getUsn() {
		return usn;
	}

	public void setUsn(String usn) {
		this.usn = usn;
	}

	public void setImgId(Long staffImgId) {
		this.staffImgId = staffImgId;
	}

	public Long getImgId() {
        return staffImgId;
    }

    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return staffImageData;
    }

    public void setData(byte[] staffImageData) {
        this.staffImageData = staffImageData;
    }

}
