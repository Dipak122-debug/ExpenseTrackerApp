package com.expenseApp.expenseApiTracker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//import com.expenseApp.expenseApiTracker.security.CustomUserDetailsService;

//import com.expenseApp.expenseApiTracker.entity.User;

@Configuration
public class WebConfig {
	

	
//	@Autowired
//	private CustomUserDetailsService userDetailsService;
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		

		 http
		        .csrf(csrf -> csrf.disable())
		        .authorizeHttpRequests(auth -> auth
		            .requestMatchers("/login", "/register").permitAll()
		            .anyRequest().authenticated()
		        )
		        .httpBasic(Customizer.withDefaults());
		       
		       
		
		 return http.build();
	}
	
	 @Bean
	 public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		 
	        // InMemoryUserDetailsManager
	        UserDetails admin = User.withUsername("Dipak")
	                .password(encoder.encode("123"))
	                .roles("ADMIN", "USER")
	                .build();
	 
	        UserDetails user = User.withUsername("Banti")
	                .password(encoder.encode("123"))
	                .roles("USER")
	                .build();
	 
	        return new InMemoryUserDetailsManager(admin, user);
	    }  
	 
		
//	@Bean
//	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//	    return authenticationConfiguration.getAuthenticationManager(userDetailsService);
//	}
	 
	// Password Encoding
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

}
