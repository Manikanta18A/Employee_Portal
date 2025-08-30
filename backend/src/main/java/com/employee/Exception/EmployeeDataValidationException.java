package com.employee.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDataValidationException extends RuntimeException{

	private String exceptionmsg;
	
	
}
