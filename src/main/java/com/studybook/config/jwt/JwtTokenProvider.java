package com.studybook.config.jwt;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.studybook.config.auth.PrincipalDetails;
import com.studybook.config.auth.PrincipalDetailsService;

@Configuration
public class JwtTokenProvider{
	
	@Autowired
	PrincipalDetailsService principalDetailsService;
	
	private final String SECRET = "studybook"; //시크릿 키
	private final long EXPIRATION_TIME = 30 * 60 * 1000L;//토큰 유효시간 30분
	
	//토큰 생성하기
	public String createToken(long userID, String username) {
		System.out.println(System.currentTimeMillis()+EXPIRATION_TIME);
		return JWT.create()
				.withSubject("Token")
				.withExpiresAt(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
				.withClaim("id", userID)
				.withClaim("username", username)
				.sign(Algorithm.HMAC512(SECRET));
	}
	
	//JWT 토큰을 통해 인증 정보 조회
	public Authentication getAuthentication(String token) {
		String username = JWT.require(Algorithm.HMAC512(SECRET))
				.build()
				.verify(token)
				.getClaim("username")
				.asString();
		
		PrincipalDetails principalDetails = 
				(PrincipalDetails) principalDetailsService.loadUserByUsername(username);
	
		return new UsernamePasswordAuthenticationToken(principalDetails, "", principalDetails.getAuthorities());
	}
	
	//token 값 가져오기
	public String resolveToken(HttpServletRequest request) {
		return request.getHeader("Authorization");
	}
}
