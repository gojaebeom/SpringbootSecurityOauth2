package com.studybook.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studybook.config.jwt.JwtTokenProvider;
import com.studybook.model.User;
import com.studybook.repository.UserRepository;

@RestController
public class SignController {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	//회원가입 요청
	@PostMapping("/join")
	public boolean join(@RequestBody User user) {
		System.out.println("회원가입 컨트롤러 진입");
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		
		User joinUser = userRepository.save(user);
		
		return (joinUser != null) ? true : false;
	}
	
	//회원가입 - 유저 아이디 중복 검사
	@PostMapping("/join/username-check")
	public boolean usernameCheck(@RequestBody String username) {
		System.out.println("유저네임 채크 메서드 진입");
		
		User user = userRepository.findByUsername(username);
		
		return (user == null) ? true : false;
	}
	
	//로그인 요청
	@PostMapping("/login")
	public Map<String, String> login(@RequestBody User user) {
		Map<String, String> result  = new HashMap<>();
		System.out.println("로그인 컨트롤러 진입");

		User loginUser =  userRepository.findByUsername(user.getUsername());
		if(loginUser == null) {
			result.put("false", "해당하는 아이디가 없습니다");
			return result;
		}
		if(!passwordEncoder.matches(user.getPassword(), loginUser.getPassword())) {
			result.put("false", "비밀번호가 일치하지 않습니다");
			return result;
		}
		result.put("token", 
			new JwtTokenProvider().createToken(loginUser.getId(), loginUser.getUsername()));
		return result;
	}
	
	//로그아웃 요청
	@PostMapping("/logout")
	public String logout() {
		System.out.println("로그아웃 성공!");
		return "로그아웃";
	}
}
