package com.studybook.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;

import com.studybook.model.User;
import com.studybook.repository.UserRepository;

public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	//로그인한 사용자 정보 요청
	@GetMapping("/users/login-info")
	public List<Map<String, String>> loginUserInfo() {
		System.out.println("로그인 유저 요청!");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		User user = userRepository.findByUsername(username);
		
		List<Map<String, String>> userList = new ArrayList<>();
		Map<String, String> userInfo = new HashMap<>();
		
		userInfo.put("id", String.valueOf(user.getId()));
		userInfo.put("nickname", user.getNickname());
		
		userList.add(userInfo);
		
		return userList;
	}
	
	@GetMapping("/users")
	public void index() { //유저 리스트
		
	}
	@GetMapping("/users/{id}")
	public void show() { //유저 상세
		
	}
	@PatchMapping("/users/{id}")
	public void edit() { //유저 정보 수정
		
	}
	@DeleteMapping("/users/{id}")
	public void destroy() { //유저 삭제
		
	}
}
