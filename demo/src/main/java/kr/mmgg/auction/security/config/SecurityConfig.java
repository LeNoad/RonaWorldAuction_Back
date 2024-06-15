package kr.mmgg.auction.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import kr.mmgg.auction.security.jwt.JwtSecurityConfig;
import kr.mmgg.auction.security.jwt.TokenProvider;
import kr.mmgg.auction.security.jwt.UserDetailService;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	private TokenProvider tokenProvider;
	
	@Autowired
	private UserDetailService userDetailService;

	public SecurityConfig(TokenProvider tokenProvider) {
		super();
		this.tokenProvider = tokenProvider;
	}
	@Bean
    AuthenticationProvider preauthAuthProvider() {
        PreAuthenticatedAuthenticationProvider provider = new PreAuthenticatedAuthenticationProvider();
        provider.setPreAuthenticatedUserDetailsService(userDetailsServiceWrapper());
        return provider;
    }

    @Bean
    AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> userDetailsServiceWrapper() {
        return new UserDetailsByNameServiceWrapper<>(userDetailService);
    }
    
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers("/resources/**");
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
        	.cors()
        .and()
        	.csrf()
        .disable()
        	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        	.authenticationProvider(preauthAuthProvider())
        	.authorizeRequests()
        	.anyRequest().permitAll() // 모든 요청에 대해 인증을 거치지 않도록 설정
        .and()
        	.apply(new JwtSecurityConfig(tokenProvider)); // JwtSecurityConfig 적용
     return httpSecurity.build();
	}
}
