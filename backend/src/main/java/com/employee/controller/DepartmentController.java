package com.employee.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

	
	@PostMapping("/insertdepartmentdetails")
	public String insertDepartmentDetails() {
		return "Inserted Department Details Succesfully";
	}

	@GetMapping("/selectdepartmentdetails")
	public String selectDepartmentDetails() {
		return "Selected Department Details";
	}
	
	@PutMapping("/updatedepartmentdetails")
	public String updateDepartmentDetails() {
		return "Succesfully Updated Department Details";
	}
	
	@DeleteMapping("/deletedepartmentdetails")
	public String deleteDepartmentDetails() {
		return "Succesfully Deleted Department Details";
	}
}
