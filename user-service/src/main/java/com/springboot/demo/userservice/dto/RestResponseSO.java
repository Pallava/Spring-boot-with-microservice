package com.springboot.demo.userservice.dto;

import com.springboot.demo.userservice.entity.User;

public class RestResponseSO {
	
	private User user;
	private Department department;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	

}
