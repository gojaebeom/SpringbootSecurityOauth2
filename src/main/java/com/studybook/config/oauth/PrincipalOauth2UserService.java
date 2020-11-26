package com.studybook.config.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.studybook.config.auth.PrincipalDetails;
import com.studybook.model.User;
import com.studybook.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService{
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		log.info("getClientRegistration: {}", userRequest.getClientRegistration());
		log.info("getAccessToken: {}", userRequest.getAccessToken());
		
		
		OAuth2User oauth2User = super.loadUser(userRequest);
		log.info("getAttributes: {}", oauth2User.getAttributes());
		
		String provider = userRequest.getClientRegistration().getRegistrationId();
		String providerId = oauth2User.getAttribute("sub");
		String username = provider+"_"+providerId;
		String password = bCryptPasswordEncoder.encode("studybook");
		String email = oauth2User.getAttribute("email");
		String nickname = oauth2User.getAttribute("name");
		String role = "ROLE_USER";
		
		User user = userRepository.findByUsername(username);
		
		if(user == null) {
			log.info("최초로그인 - 회원가입 진행");
			user = User.builder()
					.provider(provider)
					.providerId(providerId)
					.username(username)
					.password(password)
					.email(email)
					.nickname(nickname)
					.role(role)
					.build();
			
			log.info("user: {}", user);
			userRepository.save(user);
		}
		log.info("회원가입 된 계정");
		
		return new PrincipalDetails(user, oauth2User.getAttributes());
	}
}
