package com.studybook.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.studybook.model.User;
import com.studybook.repository.UserRepository;

import lombok.RequiredArgsConstructor;

// /login 요청시 동작해야하지만 securityConfig 설정에서 formLogin을 막아놔서 동작하지 않음
// 그래서 직접 이 클래스를 실행시켜줄 필터를 만들어야 함
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService{
	
	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("loadUserByUsername");
		System.out.println(username);
		User userEntity = userRepository.findByUsername(username);
		System.out.println(userEntity);
		return new PrincipalDetails(userEntity);
	}

}
