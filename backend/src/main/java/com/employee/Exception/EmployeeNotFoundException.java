package com.employee.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeNotFoundException extends RuntimeException{

	private String exceptionmsg;

}
