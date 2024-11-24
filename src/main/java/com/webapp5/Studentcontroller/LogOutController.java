package com.webapp5.Studentcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogOutController {

	@RequestMapping("/log-out")
	public String login(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		
		session.invalidate();
		return "login";
	}
}
