package com.webapp5.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.webapp5.Studentpayload.ErrorDetailsDto;
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFound.class)
	public String handleresourceNotFoundException(ResourceNotFound e,Model model) {
		ErrorDetailsDto error=new ErrorDetailsDto(e.getMessage());
		model.addAttribute("error", error);
		return "login";
	}
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	public String handleUserAlreadyExistsException(UserAlreadyExistsException e,Model model) {
		ErrorDetailsDto error=new ErrorDetailsDto(e.getMessage());
		model.addAttribute("msg4", error);
		return "registration";
	}
	
	@ExceptionHandler(PasswordNotFoundException.class)
	
	public String handlePasswordNotFoundException(PasswordNotFoundException e,Model model) {
		ErrorDetailsDto error=new ErrorDetailsDto(e.getMessage());
		model.addAttribute("error", error);
		model.addAttribute("msg", true);
		return "student/profile";
	}
	
	@ExceptionHandler(Exception.class)
	public String sqlException(Exception e,Model model) {
		
		ErrorDetailsDto detailsDto=new ErrorDetailsDto(e.getMessage());
		
		return "error-404";
	}
}
