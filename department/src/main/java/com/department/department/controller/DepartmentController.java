package com.department.department.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.department.department.entity.Department;
import com.department.department.services.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/")
	private Optional<List<Department>> saveDepartment(@RequestBody List<Department> department) {
		return departmentService.saveDepartment(department);
	}
	@GetMapping("/{id}")
	private Department findByDepartmentId(@PathVariable("id")Long depId) {
		return departmentService.findByDepartmentId(depId);
	}

}
