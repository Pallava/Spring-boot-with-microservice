package com.springboot.demo.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department {
	
	
	private Long depId;
	private String depName;
	private String depAddress;
	private String depCode;
	public Long getDepId() {
		return depId;
	}
	public void setDepId(Long depId) {
		this.depId = depId;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public String getDepAddress() {
		return depAddress;
	}
	public void setDepAddress(String depAddress) {
		this.depAddress = depAddress;
	}
	public String getDepCode() {
		return depCode;
	}
	public void setDepCode(String depCode) {
		this.depCode = depCode;
	}
	
	
	
}
