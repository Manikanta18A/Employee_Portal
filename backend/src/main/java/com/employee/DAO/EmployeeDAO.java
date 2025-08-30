package com.employee.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.entity.EmployeeDetails;
import com.employee.repository.EmployeeRepository;

@Repository
public class EmployeeDAO {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public EmployeeDetails insertEmployeeDetails(EmployeeDetails employeeDetails) {
	  return 	employeeRepository.save(employeeDetails);
	}

	
	public List<EmployeeDetails> selectAllDetails() {
		List<EmployeeDetails> details = employeeRepository.findAll();
		return details;
	}
	
	public EmployeeDetails selectEmployeeDetailsByUsingEmailId(String emailid)
	{
		return employeeRepository.findByEmailid(emailid);
	}
	
	/*Normal inbuilt method to perform this deletion operation */
	public boolean deleteEmployeeDetailsByUsingEmailid(String emailid)
	{
		EmployeeDetails employeeDetails = employeeRepository.findByEmailid(emailid);
		if(employeeDetails!=null)
		{
			employeeRepository.delete(employeeDetails);
			return true;
		}
		else
		{
			return false;
		}
	}
	/*Customized method to perform Deletion operation */
	public int deleteEmployeeDetailsByRemoveMethod(String emailid) {
		return employeeRepository.removeByEmailid(emailid);
	}
	
	/*Update Operation By Using the Deptno to Update Salary*/
	public boolean updateByUsingDeptno(int deptno,double salary)
	{
		/*Normal Save() method  */
//		List<EmployeeDetails> details = employeeRepository.findAll();
//		if(details.isEmpty())
//		{
//			return false;
//		}
//		else
//		{
//			for (EmployeeDetails employeeDetails : details) {
//				
//				if(employeeDetails.getEmpdeptno()==deptno)
//				{
//					EmployeeDetails employeeDetails2 = employeeRepository.save(employeeDetails);
//					employeeDetails2.setEmpsalalry(salary);
//				}
//				
//			}
//			return true;
//		}
		/*Customized Method To Updation Operation*/
		List<EmployeeDetails> details = employeeRepository.readByEmpdeptno(deptno);
		if(details.isEmpty())
		{
			return false;
		}
		else
		{
			for (EmployeeDetails employeeDetails : details) {
				
				    employeeDetails.setEmpsalalry(salary);
					EmployeeDetails employeeDetails2 = employeeRepository.save(employeeDetails);
	
			}
			return true;
		}
		
	}
	
}
