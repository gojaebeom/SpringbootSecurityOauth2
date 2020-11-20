package com.studybook.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studybook.model.User;
import com.studybook.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RestApiController {
	
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	

	@GetMapping("/")
	public String home() {
		System.out.println("hello world!");
		return "<h1>hello world!</h1>";
	}
	
	@PostMapping("/token")
	public String token() {
		return "<h1>TOKEN</h1>";
	}
	
	@PostMapping("/join/usernameCheck")
	public boolean usernameCheck(@RequestBody String username) {
		User user =  userRepository.findByUsername(username);
		System.out.println(user);
		return true;
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "hello";
	}
	
	@GetMapping("/user")
	public String user() {
		return "hello";
	}
	
	@PostMapping("/join")
	public String join(@RequestBody User user) {
		System.out.println("회원가입!");
		System.out.println(user);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRoles("USER");
		userRepository.save(user);
		return "회원가입 완료";
	}
}
