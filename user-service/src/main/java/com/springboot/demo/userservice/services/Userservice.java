package com.springboot.demo.userservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.springboot.demo.userservice.dto.Department;
import com.springboot.demo.userservice.dto.RestResponseSO;
import com.springboot.demo.userservice.entity.User;
import com.springboot.demo.userservice.feignclients.DepartmentFeignClient;
import com.springboot.demo.userservice.repository.UserRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Component
public class Userservice {
	
	int count ;
	org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Userservice.class);
	@Autowired
	private UserRepository userRepository;
	/*
	 * @Autowired private RestTemplate resttemplate;
	 * 
	 * @Autowired private DepartmentFeignClient deprtFeignClinet;
	 */
	@Autowired
	private CommonService commonService;
	
	public Optional<List<User>> saveUser(List<User> user) {
		logger.info("saveUser in Userservices");
		user.stream().forEach(d->{userRepository.save(d);});
		 return Optional.of(user);
		
	}

	public RestResponseSO getUserWithDepartment(Long userId) {
		RestResponseSO responseSO=new RestResponseSO();
		User user =  userRepository.findByUserId(userId);
		logger.info("before making rest call to department services");
		//Department dept = resttemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDeptId(), Department.class);
		/*
		 * Department dept = deprtFeignClinet.findByDepartmentId(user.getDeptId());
		 */		responseSO.setUser(user);
		responseSO.setDepartment(commonService.getDepartmentDetails(user.getDeptId()));
		return responseSO;
		
		
	}
	//departmentService = instance name in yml file
	/*
	 * @CircuitBreaker(name = "departmentService",fallbackMethod =
	 * "departmentServiceFallBack") Department getDepartmentDetails(Long deptId) {
	 * logger.debug("Count is "+count); count++;
	 * 
	 * Department dept = deprtFeignClinet.findByDepartmentId(deptId); return dept;
	 * 
	 * }
	 * 
	 * Department departmentServiceFallBack(Long deptId,Throwable th){
	 * logger.debug("Error->>>>>>>> "+th); return new Department(); }
	 */
	

}
