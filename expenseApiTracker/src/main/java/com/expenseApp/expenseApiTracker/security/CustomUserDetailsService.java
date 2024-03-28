//package com.expenseApp.expenseApiTracker.security;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.expenseApp.expenseApiTracker.entity.User;
//import com.expenseApp.expenseApiTracker.repository.UserRepository;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//	
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		User existingUser = userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("UserName not found for the email"+email));
//		
//		return new org.springframework.security.core.userdetails.User(existingUser.getEmail(),existingUser.getPassword(), new ArrayList());
//	}
//
//	
//
//}
