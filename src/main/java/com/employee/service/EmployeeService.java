package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employee.DAO.EmployeeDAO;
import com.employee.Exception.EmployeeDataValidationException;
import com.employee.Exception.EmployeeNotFoundException;
import com.employee.config.EmailConfig;
import com.employee.controller.DepartmentController;
import com.employee.entity.EmployeeDetails;

@Service
public class EmployeeService {

    private final DepartmentController departmentController;

	@Autowired
	EmployeeDAO employeeDAO;
	
	@Autowired
	EmailConfig emailConfig;

    EmployeeService(DepartmentController departmentController) {
        this.departmentController = departmentController;
    }
	
    public 	ResponseEntity<EmployeeDetails> insertDetails(EmployeeDetails details) 
    {
    	
    	List<EmployeeDetails> allEmployeeDetails = employeeDAO.selectAllDetails();
    	
    	long emailcount = allEmployeeDetails.stream().filter((employee) -> employee.getEmailid().equals(details.getEmailid())).count();
    	if(emailcount==0)
    	{
    		EmployeeDetails details2 = employeeDAO.insertEmployeeDetails(details);
         	if (details2.getEmpid()>=0) {
         		
         		emailConfig.sendTextMsg(details2.getEmailid(), details2.getEmpname()+"Your Account Created Succesfully");
         		return new ResponseEntity<EmployeeDetails>(details2, HttpStatus.OK);
    			
    		} else {

    			return new ResponseEntity<EmployeeDetails>(HttpStatus.INTERNAL_SERVER_ERROR);
    		}
    		
    	}
    	else
    	{
    		throw new EmployeeDataValidationException("Email Already Existed");
    	}
    }
    
    
    public ResponseEntity<EmployeeDetails> getEmployeeByUsingEmailid(String emailid)
    {
    	EmployeeDetails employeeDetails = employeeDAO.selectEmployeeDetailsByUsingEmailId(emailid);
    	if(employeeDetails!=null)
    	{
    		return new ResponseEntity<EmployeeDetails>(employeeDetails, HttpStatus.OK);
    	}
    	else
    	{
    		throw new EmployeeNotFoundException("No Data Found");
    	}
    }
    
    public ResponseEntity<String> deleteByUsingEmailId(String emailid) {
    	
    	if(employeeDAO.deleteEmployeeDetailsByUsingEmailid(emailid))
    	{
    		return new ResponseEntity<String>("Data Deleted", HttpStatus.OK);
    	}
    	else
    	{
    		throw new EmployeeNotFoundException("No Data Found");
    	}
    	
    }
    
    public ResponseEntity<String> deleteByRemoveMethod(String emailid) {
    	if(employeeDAO.deleteEmployeeDetailsByUsingEmailid(emailid))
    	{
    		return new ResponseEntity<String>("Data Deleted", HttpStatus.OK);
    	}
    	else
    	{
    		throw new EmployeeNotFoundException("No Data Found");
    	}
    			
    }
    
    /*Updation operation */
    public ResponseEntity<String> updateEmployeeDetailsBasedOnDeptno(int deptno,double salary) {
    	if(employeeDAO.updateByUsingDeptno(deptno,salary))
    	{
    		return new ResponseEntity<String>("Data Updated", HttpStatus.OK);
    	}
    	else {
    		throw new EmployeeNotFoundException("No Data Found");
    	}
    }
    
    
}
