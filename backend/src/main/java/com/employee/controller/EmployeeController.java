package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.EmployeeDetails;
import com.employee.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	
	@PostMapping("/insertemployeedetails")
	public ResponseEntity<EmployeeDetails> insertEmployeeDetails(@RequestBody EmployeeDetails employeeDetails) {
		ResponseEntity<EmployeeDetails> details = employeeService.insertDetails(employeeDetails);
		return details;
	}
	
	@GetMapping("/selectEmployeeDetails")
	public ResponseEntity<EmployeeDetails> selectEmployee(@RequestParam("useremailid")String emailid) {
		System.out.println(emailid);
		return employeeService.getEmployeeByUsingEmailid(emailid);
	}
	
	@PutMapping("/updateEmployee/{deptno}/{salary}")
	public ResponseEntity<String> updateEmployeeDetails(@PathVariable("empdeptno") int deptno,@PathVariable("empsalalry")double salary) {
		return employeeService.updateEmployeeDetailsBasedOnDeptno(deptno, salary);
//		return "Data Updated";
	}
	
	@DeleteMapping("/deleteEmployee/{emailid}")
	public ResponseEntity<String> deleteEmployeeDetails(@PathVariable("emailid") String useremailid) {
		System.out.println(useremailid);
		/*inbulit method to perform deletion */
//		return employeeService.deleteByUsingEmailId(useremailid);
		/*Customized method to perform deletion operation */
		return employeeService.deleteByRemoveMethod(useremailid);
	}

}
