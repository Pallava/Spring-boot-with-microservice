package com.springboot.demo.userservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.springboot.demo.userservice.dto.Department;
import com.springboot.demo.userservice.dto.RestResponseSO;
import com.springboot.demo.userservice.entity.User;
import com.springboot.demo.userservice.repository.UserRepository;

@Component
public class Userservice {
	org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Userservice.class);
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate resttemplate;

	public Optional<List<User>> saveUser(List<User> user) {
		logger.info("saveUser in Userservice");
		user.stream().forEach(d->{userRepository.save(d);});
		 return Optional.of(user);
		
	}

	public RestResponseSO getUserWithDepartment(Long userId) {
		RestResponseSO responseSO=new RestResponseSO();
		User user =  userRepository.findByUserId(userId);
		logger.info("before making rest call to department services");
		Department dept = resttemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDeptId(), Department.class);
		responseSO.setUser(user);
		responseSO.setDepartment(dept);
		return responseSO;
		
		
	}

}
