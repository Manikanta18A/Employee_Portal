package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.EmployeeDetails;

public interface EmployeeRepository  extends JpaRepository<EmployeeDetails, Integer>{
	

	EmployeeDetails findByEmailid(String emailid);
	
	int removeByEmailid(String emailid);
	
	/*Customized Method To Perform Updation Operation */
	
	
     List<EmployeeDetails>  readByEmpdeptno(int deptno);
}
