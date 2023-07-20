package com.masai.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class AuthConfig {

    @Bean
    public UserDetailsService userDetailsService(){
        return new CustomUserDetailsService();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	return http
    			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    			.and()
    			.csrf().disable()
    			.cors().configurationSource( new CorsConfigurationSource() {
    				
    				@Override
    				public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {	
    					
    					
    					CorsConfiguration cfg = new CorsConfiguration();
    					
    					//cfg.setAllowedOrigins(Collections.singletonList("*"));
    					cfg.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
    					//cfg.setAllowedMethods(Arrays.asList("GET", "POST","DELETE","PUT"));
    					cfg.setAllowedMethods(Collections.singletonList("*"));
    					cfg.setAllowCredentials(true);
    					cfg.setAllowedHeaders(Collections.singletonList("*"));
    					cfg.setExposedHeaders(Arrays.asList("Authorization"));
    					cfg.setMaxAge(3600L);
    					return cfg;
    					
    					
    					
    				}
    			})
    			.and()
                .authorizeHttpRequests()
                .requestMatchers("/auth/register", "/auth/token", "/auth/validate").permitAll()
                .anyRequest().authenticated()
                .and()
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
