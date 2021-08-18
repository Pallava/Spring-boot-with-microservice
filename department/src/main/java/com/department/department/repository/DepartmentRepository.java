package com.department.department.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.department.department.entity.Department;

@Repository
public interface DepartmentRepository  extends CrudRepository<Department, Long>{

	@Query("from Department d where d.depId=:depId")
	Department findByDepartmentId(@Param("depId") Long  depId);

}
