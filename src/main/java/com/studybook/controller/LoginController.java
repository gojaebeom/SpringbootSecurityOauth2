package com.studybook.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.studybook.dto.UserDTO;
import com.studybook.service.login.LoginService;

@Controller
public class LoginController {
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private static final Log LOG = LogFactory.getLog(LoginController.class);

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String index() {
		
		return "/sign/login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String LoginCheck(UserDTO user) throws Exception {
		
		LOG.info("로그인 유저 정보 확인"+user);
		
		UserDTO loginUser = loginService.loginCheck(user);
		
		return "redirect:/";
	}
}
