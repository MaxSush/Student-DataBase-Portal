package com.webapp5.Studententity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="images")
public class ImageEntity {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long imgId;
	   
	    private String type;
	    private String usn;

	    @Lob
	    @Column(length=100000)
	    private byte[] imageData;

	    public ImageEntity() {
	    }

	    public  ImageEntity( String type, byte[] imageData,String usn) {
	      
	        this.type = type;
	        this.imageData = imageData;
	        this.usn = usn;
	    }

	    
	    public String getUsn() {
			return usn;
		}

		public void setUsn(String usn) {
			this.usn = usn;
		}

		public void setImgId(Long imgId) {
			this.imgId = imgId;
		}

		public Long getImgId() {
	        return imgId;
	    }

	    

	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	    public byte[] getData() {
	        return imageData;
	    }

	    public void setData(byte[] imageData) {
	        this.imageData = imageData;
	    }
	
}
