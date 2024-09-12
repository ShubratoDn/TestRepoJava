package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class Home {
	@GetMapping({"/","/login"})
	public String createSession() {
		
		return "login.jsp";
	}
	
	
	@PostMapping("/login")
	public String login(HttpSession httpSession, HttpServletRequest httpServletRequest, 
			@RequestParam(name = "username", required = true) String username,
			@RequestParam(name = "password", required = false) String password
			) {
		
		if(password.equalsIgnoreCase("1111")) {
			httpServletRequest.getSession().setAttribute("username", username);
			return "redirect:/dashboard";
		}
		
		return "redirect:/login?loginFailed";
	}
	
	
	@GetMapping("/dashboard")
	public String viewSession(HttpSession httpSession) {
		if(httpSession.getAttribute("username") == null) {
			return "redirect:/login?loginRequired";
		}
		return "dashboard.jsp";
	}
	
	@GetMapping("/remove-session")
	public String removeSession(HttpSession session) {
		session.removeAttribute("username");
		return "redirect:/login";
	}
}
