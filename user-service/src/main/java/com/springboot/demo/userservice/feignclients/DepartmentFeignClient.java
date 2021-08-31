package com.springboot.demo.userservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.demo.userservice.dto.Department;


@FeignClient(value ="API-GATEWAY")
/*@FeignClient(url="${department.service.url}",value ="department-service",
path="/departments")*/
public interface DepartmentFeignClient {
	
	@GetMapping("/departments/{id}")
	public Department findByDepartmentId(@PathVariable("id")Long depId);

}
