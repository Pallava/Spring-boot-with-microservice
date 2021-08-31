package com.springboot.demo.userservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.userservice.dto.Department;
import com.springboot.demo.userservice.feignclients.DepartmentFeignClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CommonService {
	
	int count;
	org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Userservice.class);
	@Autowired
	private DepartmentFeignClient deprtFeignClinet;
	//departmentService = instance name in yml file
	@CircuitBreaker(name = "departmentService",fallbackMethod = "departmentServiceFallBack")
	Department getDepartmentDetails(Long deptId) {
		logger.info("Count is "+count);
		count++;
		
		Department dept = deprtFeignClinet.findByDepartmentId(deptId);
		return dept;
		
	}
	
	Department departmentServiceFallBack(Long deptId,Throwable th){
		logger.info("Error->>>>>>>> "+th);
		return new Department();
	}

}
