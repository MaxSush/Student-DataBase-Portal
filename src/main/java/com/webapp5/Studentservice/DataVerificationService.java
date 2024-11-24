package com.webapp5.Studentservice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataVerificationService {

	public boolean verifyUsername(String username) {
		Pattern p = Pattern.compile("^\\d{1}MM\\d{2}[A-Z]{2}\\d{3}$");
		Matcher m = p.matcher(username);
		if(m.matches()) {
			return true;
		}
		
		return false;
	}
	
	public boolean verifyEmail(String email) {
		Pattern p = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
		Matcher m = p.matcher(email);
		if(m.matches()) {
			return true;
		}
		
		return false;
	}
	
	public boolean verifyMobile(long mobile) {
		Pattern p = Pattern.compile("^[6-9]\\d{9}$");
		Matcher m = p.matcher(String.valueOf(mobile));
		if(m.matches()) {
			return true;
		}
		
		return false;
		
	}
}
