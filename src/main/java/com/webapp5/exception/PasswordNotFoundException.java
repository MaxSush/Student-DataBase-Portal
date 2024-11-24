package com.webapp5.exception;

public class PasswordNotFoundException extends RuntimeException{
	
	public PasswordNotFoundException(String message) {
		super(message);
	}

}
