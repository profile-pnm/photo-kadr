package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
class SecurityConfig {
    final private String passwordEncoding = "none";

    @SuppressWarnings("deprecation")
	@Bean
    public PasswordEncoder passwordEncoder() {
        return switch (passwordEncoding) {
            case "none" -> NoOpPasswordEncoder.getInstance();
            case "bcrypt" -> new BCryptPasswordEncoder();
            default -> NoOpPasswordEncoder.getInstance(); //TODO
        };
    }

    @Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
        	//.csrf(csrf -> csrf.disable()) // Disable CSRF
        	//.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Disable session
        	.authorizeHttpRequests(auth -> auth
    		    .requestMatchers("/api/**").permitAll()
    		    .requestMatchers("/").permitAll()
    		    .requestMatchers("/css/**").permitAll()
    		    .requestMatchers("/img/**").permitAll()
    		    .requestMatchers("/authorization").permitAll()
    		    .anyRequest().authenticated()
    		)
            //.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
	}
}
