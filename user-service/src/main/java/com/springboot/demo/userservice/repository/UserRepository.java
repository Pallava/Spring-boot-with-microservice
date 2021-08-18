package com.springboot.demo.userservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.demo.userservice.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	//User getUserDetailsById(Long userId);

	User findByUserId(Long userId);
	
	

}
