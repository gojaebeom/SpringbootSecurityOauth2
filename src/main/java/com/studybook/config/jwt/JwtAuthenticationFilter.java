package com.studybook.config.jwt;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.studybook.config.auth.PrincipalDetails;
import com.studybook.model.User;


//UsernamePasswordAuthenticationFilter 를 상속받으면 
// /login 요청을 해서 username, password를 전송하면 이 필터가 동작하지만 
// SecurityConfig 에서 form로그인을 막아놔서 동작안함
// 때문에 이 필터를 상속받아 구현하여 다시 SecurityConfig에 등록해줌으로써 해결
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	private final AuthenticationManager authenticationManager;
	
	// Authentication 객체 만들어서 리턴 => 의존 : AuthenticationManager
	// 인증 요청시에 실행되는 함수 => /login
	
	public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	// /login 요청을 하면 로그인 시도를 위해서 실행되는 함수
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		System.out.println("JwtAuthenticationFilter : 진입");
		
		//1. username, password를 받아서 토큰발급
		ObjectMapper om = new ObjectMapper();//json 데이터 파싱
		User user = null;
		
		try {
			user = om.readValue(request.getInputStream(), User.class);			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(user);
		
		// 유저네임패스워드 토큰 생성
		UsernamePasswordAuthenticationToken authenticationToken
			= new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
		
		System.out.println("JwtAuthenticationFilter : 토큰생성완료");
		
		// authenticate() 함수가 호출 되면 인증 프로바이더가 유저 디테일 서비스의
		// loadUserByUsername(토큰의 첫번째 파라메터) 를 호출하고
		// UserDetails를 리턴받아서 토큰의 두번째 파라메터(credential)과
		// UserDetails(DB값)의 getPassword()함수로 비교해서 동일하면
		// Authentication 객체를 만들어서 필터체인으로 리턴해준다.
		
		// Tip: 인증 프로바이더의 디폴트 서비스는 UserDetailsService 타입
		// Tip: 인증 프로바이더의 디폴트 암호화 방식은 BCryptPasswordEncoder
		// 결론은 인증 프로바이더에게 알려줄 필요가 없음.
		Authentication authentication =
				authenticationManager.authenticate(authenticationToken);
		
		
		PrincipalDetails principalDetails = (PrincipalDetails)authentication.getPrincipal();
		System.out.println(principalDetails.getUser().getUsername());
		
		//return 될때 athentication 객체가 session 영역에 저장됨 => 로그인이 되었다는 뜻
		
		//3. PrincipalDetails를 세션에 담기 ( 굳이 세션을 만드는 이유는 권한 관리를 위해서)
		//권한이 필요 없는 앱일 경우 사용 안해도 무방
		
		//4. JWT토큰을 만들어서 응답
		return authentication;
	}
	
	// attemptAuthentication  인증이 정상적으로 되었으면 다음에 실행되는 메서드
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		System.out.println("successfulAuthentication 실행됨 : 인증완료");
		PrincipalDetails principalDetails = (PrincipalDetails)authResult.getPrincipal();
		
		String jwtToken = JWT.create()
				.withSubject("코스토큰")
				.withExpiresAt(new Date(System.currentTimeMillis()+(60000*10)))
				.withClaim("id", principalDetails.getUser().getId())
				.withClaim("username", principalDetails.getUser().getUsername())
				.sign(Algorithm.HMAC512("cos"));
		
		
		response.addHeader("Authorization", "Bearer "+jwtToken);
	}
	
}
