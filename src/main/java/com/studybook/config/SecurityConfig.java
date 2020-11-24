package com.studybook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.studybook.config.jwt.JwtAuthorizationFilter;
import com.studybook.config.jwt.JwtTokenProvider;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	private final JwtTokenProvider jwtTokenProvider;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    CorsFilter corsFilter() {
        return new CorsFilter();
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.addFilterBefore(corsFilter(), UsernamePasswordAuthenticationFilter.class) //adds your custom CorsFilter
			.addFilterBefore(new JwtAuthorizationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
			.formLogin().disable()
			.httpBasic().disable()
			.authorizeRequests()
			.antMatchers("/users/**")
			.hasAnyRole("ADMIN","USER")
			.antMatchers("/admin/**")
			.hasRole("ADMIN")
			.anyRequest().permitAll()
			.and()
			.logout().logoutUrl("/logout");
	}
	
}
