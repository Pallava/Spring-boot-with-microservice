package com.department.department.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.department.department.entity.Department;
import com.department.department.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(DepartmentService.class);
	@Autowired
	private DepartmentRepository departmentRepository;

	public Optional<List<Department>> saveDepartment(List<Department> department) {
		department.stream().forEach(d->{departmentRepository.save(d);});
		//return ;	
		logger.info("After saving departments...............");
		return Optional.of(department);
	}

	public Department findByDepartmentId(Long depId) {
		logger.info("findByDepartmentId departments...............depId ->"+depId);
		return departmentRepository.findByDepartmentId(depId);
	}
	
	
	

}
