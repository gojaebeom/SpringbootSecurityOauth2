package com.studybook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.studybook.config.oauth.PrincipalOauth2UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private PrincipalOauth2UserService principalOauth2UserService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override //정적 자원에 대해서는 Security 적용 X
    public void configure(WebSecurity web) {
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
    	.csrf().disable()
    	.authorizeRequests()
		.antMatchers("/admin/**")
		.hasRole("ADMIN")
		.antMatchers("/login/**","/join/**")
		.not().hasAnyRole("ADMIN", "USER")
		.anyRequest().permitAll()
		.and()
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/login")
		.defaultSuccessUrl("/")
		.and()
		.oauth2Login()
		.loginPage("/login")
		.userInfoEndpoint()
		.userService(principalOauth2UserService);
		
    }
    
}
