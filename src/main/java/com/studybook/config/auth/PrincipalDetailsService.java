package com.studybook.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.studybook.model.User;
import com.studybook.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PrincipalDetailsService implements UserDetailsService{
	
	private final UserRepository userRepository;
	
	public PrincipalDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("진입");
		log.info("PrincipalDetailsService 진입");
		log.info("파라미터로 받은 아이디 : " +username);
		User loginUser = userRepository.findByUsername(username);
		if( loginUser == null ) {
			log.debug("## 계정정보가 존재하지 않습니다. ##");
			throw new UsernameNotFoundException(username);
		}
		log.info("로그인 인증 정보 : " +  loginUser);
		
		return new PrincipalDetails(loginUser);
	}
	
}
