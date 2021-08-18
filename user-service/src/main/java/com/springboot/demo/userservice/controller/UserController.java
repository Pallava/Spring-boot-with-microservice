package com.springboot.demo.userservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springboot.demo.userservice.dto.Department;
import com.springboot.demo.userservice.dto.RestResponseSO;
import com.springboot.demo.userservice.entity.User;
import com.springboot.demo.userservice.services.Userservice;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private Userservice userservice;
	
	@PostMapping("/")
	private Optional<List<User>> saveUser(@RequestBody List<User> user) {
		
		return userservice.saveUser(user);
		
	}
	
	@GetMapping("/{id}")
	@HystrixCommand(fallbackMethod = "fallbackMethod")
	private RestResponseSO getUserWithDepartment(@PathVariable("id") Long userId) {
		
		RestResponseSO respone =  userservice.getUserWithDepartment(userId);
		return respone;
		
	}
	private RestResponseSO fallbackMethod() {
		User user = new User();
		Department department=new Department();
		RestResponseSO rr= new RestResponseSO();
		rr.setUser(user);
		rr.setDepartment(department);
		return  rr;
		
	}
	
	
	
	

}
