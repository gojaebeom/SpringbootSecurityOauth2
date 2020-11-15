package com.studybook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.studybook.dto.UserDTO;
import com.studybook.service.register.RegisterService;

@Controller
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String index() {
		
		return "/sign/register";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String store(UserDTO user) throws Exception {
		
		String encodePassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodePassword);
		
		int result = registerService.insertUser(user);
		
		if(result == 0) {
			
		}
		
		return "redirect:/";
	}
}
