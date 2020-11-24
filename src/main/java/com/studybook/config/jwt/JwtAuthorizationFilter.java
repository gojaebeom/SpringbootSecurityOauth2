package com.studybook.config.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtAuthorizationFilter extends GenericFilterBean{
	
	private final JwtTokenProvider tokenProvider;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("권한 요청중..");
		
		//헤더에서 JWT를 받아온다
		String token = tokenProvider.resolveToken((HttpServletRequest) request);
		
		System.out.println("헤더에서 토큰을 받아온다." + token);
		
		if(token != null) {
			
			System.out.println("토큰이 있음");
			//토큰이 유효하면 유저 정보를 받아온다.
			Authentication authentication = tokenProvider.getAuthentication(token);
			
			System.out.println("유효한 토큰확인, authentication 객체 생성");
			
			//인증을 위해 SecurityContext에 Authentication 객체 저장
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			System.out.println("SecurityContextHolder에 객체 저장 완료");
		}
		
		chain.doFilter(request, response);
	}
}
