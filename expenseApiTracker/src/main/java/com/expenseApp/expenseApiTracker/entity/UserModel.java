package com.expenseApp.expenseApiTracker.entity;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserModel {

	private String name;
	
	private String email;
	
	private String password;
	
	private Long age = 0L;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}
	
	
}