package com.webapp5.Staffpayload;



public class StaffImageDto {

	private Long staffImgId;
	   
    private String type;
    private String usn;

    
    private byte[] staffImageData;


	public Long getStaffImgId() {
		return staffImgId;
	}


	public void setStaffImgId(Long staffImgId) {
		this.staffImgId = staffImgId;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getUsn() {
		return usn;
	}


	public void setUsn(String usn) {
		this.usn = usn;
	}


	public byte[] getStaffImageData() {
		return staffImageData;
	}


	public void setStaffImageData(byte[] staffImageData) {
		this.staffImageData = staffImageData;
	}
    
    
    
    
    
}
