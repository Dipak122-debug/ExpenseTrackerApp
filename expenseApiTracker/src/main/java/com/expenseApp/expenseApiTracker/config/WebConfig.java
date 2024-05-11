package com.expenseApp.expenseApiTracker.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.expenseApp.expenseApiTracker.security.JwtRequestFilter;



//import com.expenseApp.expenseApiTracker.security.CustomUserDetailsService;

//import com.expenseApp.expenseApiTracker.entity.User;

@Configuration
@EnableWebSecurity
public class WebConfig {
	
	
//	@Autowired
//	private CustomUserDetailsService userDetailsService;
	@Autowired
    private CustomAuthenticationProvider authenticationProvider;
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		

		 http
		        .csrf(csrf -> csrf.disable())
		        .authorizeHttpRequests(auth -> auth
		            .requestMatchers("/login", "/register").permitAll()
		            .anyRequest().authenticated()
		        ).authenticationProvider(authenticationProvider)
		        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
				http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		        
		       

		
		 return http.build();
	}
//	
//	 @Bean
//	 public UserDetailsService userDetailsService(PasswordEncoder encoder) {
//		 
//	        // InMemoryUserDetailsManager
//	        UserDetails admin = User.withUsername("Dipak")
//	                .password(encoder.encode("123"))
//	                .roles("ADMIN", "USER")
//	                .build();
//	 
//	        UserDetails user = User.withUsername("Banti")
//	                .password(encoder.encode("123"))
//	                .roles("USER")
//	                .build();
//	 
//	        return new InMemoryUserDetailsManager(admin,user);
//	    }  
	 
//		@Bean
//	 	public AuthenticationProvider authenticationProvider() {
//	 		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//	 		provider.setUserDetailsService(userDetailsService);
//	 		provider.setPasswordEncoder(passwordEncoder());
//	 		return provider;
//	 	}
	 
	
	@Bean
	public JwtRequestFilter authenticationJwtTokenFilter() {
		return new JwtRequestFilter();
	}
	// Password Encoding
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    
	    @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
	        return authenticationConfiguration.getAuthenticationManager();
	    }


}