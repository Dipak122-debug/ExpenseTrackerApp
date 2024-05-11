package com.expenseApp.expenseApiTracker.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JwtResponse {

	private  String jwtToken = "";

	public JwtResponse(String jwtToken) {
		this.jwtToken=jwtToken;
	}

	public String getJwtToken() {
		return jwtToken;
	}
}
