package com.masai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class AppConfig {

	@Bean
	 public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
		
	}



	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers(HttpMethod.POST,"/users")
		.permitAll()
		.requestMatchers(HttpMethod.GET,"/broker").hasRole("ADMIN")
		.requestMatchers(HttpMethod.GET,"/customers/**").hasAnyRole("ADMIN","USER")
		.anyRequest().authenticated()
		.and()
		.addFilterAfter(new JwtTokenGenaratorFilter(), BasicAuthenticationFilter.class)
		.addFilterBefore(new JwtTokenValidatorFilter(), BasicAuthenticationFilter.class)
		.formLogin()
		.and().httpBasic();
		

		return httpSecurity.build();

	}

}