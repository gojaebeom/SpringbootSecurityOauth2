package com.studybook.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.studybook.model.User;
import com.studybook.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class JoinController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	//회원가입 페이지 요청
	@GetMapping("/join")
	public String create() {
		log.info("회원가입 페이지 요청");
		
		return "join";
	}
	
	//회원가입 중 아이디 중복 확인 비동기 요청
	@ResponseBody
	@GetMapping("/join/{username}")
	public String usernameCheck(@PathVariable String username) {
		log.info("회원가입 아이디 중복 확인 요청");
		
		return "";
	}
	
	//회원가입 요청
	@PostMapping("/join")
	public String store(User user) {
		log.info("회원가입 요청 {}: ", user);
		user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		user.setCreatedAt(LocalDateTime.now());
		userRepository.save(user);
		return "redirect:/";
	}
}
