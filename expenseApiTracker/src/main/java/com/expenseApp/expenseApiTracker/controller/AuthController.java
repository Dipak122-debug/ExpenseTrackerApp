package com.expenseApp.expenseApiTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.expenseApp.expenseApiTracker.entity.AuthModel;
import com.expenseApp.expenseApiTracker.entity.JwtResponse;
import com.expenseApp.expenseApiTracker.entity.User;
import com.expenseApp.expenseApiTracker.entity.UserModel;
import com.expenseApp.expenseApiTracker.security.CustomUserDetailsService;
import com.expenseApp.expenseApiTracker.services.UserService;
import com.expenseApp.expenseApiTracker.util.JwtTokenUtil;

import jakarta.validation.Valid;

@RestController
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CustomUserDetailsService userDetailService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody AuthModel authModel) throws Exception {
		
	//	Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authModel.getEmail(), authModel.getPassword()));
		
		authenticate(authModel.getEmail(),authModel.getPassword());
		
		//generate Jwt token
		
		final UserDetails userDetails = userDetailService.loadUserByUsername(authModel.getEmail());
		
		//final String token = "";
		final String token = jwtTokenUtil.generateToken(userDetails);
		
	//	SecurityContextHolder.getContext().setAuthentication(authentication);
		return new ResponseEntity<JwtResponse>(new JwtResponse(token), HttpStatus.OK);
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<User> save(@Valid @RequestBody UserModel user) {
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
	}
	
	private void authenticate(String email, String password) throws Exception {
		
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		} catch (DisabledException e) {
			throw new Exception("User disabled");
		}
		catch (BadCredentialsException e) {
			throw new Exception("Bad Credentials");
		}
		
	}
}
