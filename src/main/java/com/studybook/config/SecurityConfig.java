package com.studybook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.filter.CorsFilter;

import com.studybook.config.jwt.JwtAuthenticationFilter;
import com.studybook.config.jwt.JwtAuthorizationFilter;
import com.studybook.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private final CorsFilter corsFilter;
	
	private final UserRepository userRepository;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.addFilter(corsFilter) //CrossOrigin 인증 x , 시큐리티 필터에 등록 인증 
			.csrf().disable()//csrf 사용안함
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//세션사용 안함
		.and()

			.formLogin().disable() //formLogin 사용 안함
			.httpBasic().disable() //http basic 방식을 사용안함(bearer 방식 사용)
			.addFilter(new JwtAuthenticationFilter(authenticationManager())) // AuthenticationManager를 던져줘야함
			.addFilter(new JwtAuthorizationFilter(authenticationManager(), userRepository))
			.authorizeRequests()
			.antMatchers("/admin/**")
			.hasRole("ADMIN")
			.antMatchers("/user/**")
			.hasRole("USER")
			.anyRequest().permitAll(); //모든 요청 허용
	}
}
