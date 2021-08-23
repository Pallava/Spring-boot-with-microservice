package com.springboot.demo.apigateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

	
	@GetMapping("/userServiceFallback")
	public String userServiceFallbackMethod() {
		return "User service is taking time to responsd   ";
	}
	
	@GetMapping("/departmentServiceFallback")
	public String departmentServiceFallbackMethod() {
		return "Departmennt service is taking time to respond";
	}
	
	
}
