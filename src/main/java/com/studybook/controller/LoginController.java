package com.studybook.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.studybook.domain.LoginDTO;
import com.studybook.domain.UserVO;
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
	
	@ResponseBody
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public int LoginCheck(@RequestBody LoginDTO login, HttpSession session) throws Exception {
		
		LOG.info("로그인 유저 정보 확인"+login);
		
		UserVO loginUser = loginService.loginCheck(login);
		
		if(loginUser == null) return 0;
		
		boolean passwordCheck = passwordEncoder.matches(login.getPassword(), loginUser.getPassword());
		
		if(!passwordCheck) return -1;
		
		//위의 모든 조건을 만족했기 때문에 세션 저장
		session.setAttribute("login", loginUser);
		
		return 1;
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		
		System.out.println("로그아웃 요청!");
		
		if(session.getAttribute("login") != null) {
			session.removeAttribute("login");
		}
		
		return "redirect:/";
	}
}
