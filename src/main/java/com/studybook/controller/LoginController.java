package com.studybook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String create() { //생성화면
		log.info("로그인 페이지 요청");
		return "login";
	}
}
