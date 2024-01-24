package com.expenseApp.expenseApiTracker.entity;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserModel {
	
	@NotBlank(message="Name Should not be Empty")
	private String name;
	
	@NotNull(message="Email should not be Empty")
	@Email(message="Please Enter valid Email")
	private String email;
	
	@NotNull(message="Email should not be Empty")
	@Size(min=5,message="Password should have atleast 5 characters")
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
