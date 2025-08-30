package com.employee.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeDataValidationException.class)
	public ResponseEntity<String> employeRelatedException(EmployeeDataValidationException dataValidationException) {
		
		System.out.println("Employee Related Exception");
		String employeexceptionmsg = dataValidationException.getExceptionmsg();
		return  new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> employeeRelatedSelection(EmployeeNotFoundException employeeNotFoundException)
	{
		String noDataFound = employeeNotFoundException.getExceptionmsg();
		return new ResponseEntity<String>(noDataFound, HttpStatus.NOT_FOUND);
	}
	

}
