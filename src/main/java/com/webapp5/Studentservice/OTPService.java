package com.webapp5.Studentservice;

import java.util.Random;

public class OTPService {

	public String OtpSrevice() {
		Random r=new Random();
		String otp="";
		for(int i=0;i<6;i++) {
			int num=r.nextInt(9);
			otp+=String.valueOf(num);
		}
		return otp;
	}
	}

