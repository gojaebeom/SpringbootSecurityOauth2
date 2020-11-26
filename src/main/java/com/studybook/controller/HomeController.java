package com.studybook.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.studybook.config.auth.PrincipalDetails;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index() {
		log.info("home 메서드 요청");
		return "home";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "home";
	}
	
	@GetMapping("/user")
	public @ResponseBody String user(@AuthenticationPrincipal PrincipalDetails principalDetails) {
		log.info("principalDetails : {} ", principalDetails.getUser());
		
		return "user";
	}
}
