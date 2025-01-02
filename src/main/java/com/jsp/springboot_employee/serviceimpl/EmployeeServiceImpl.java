package com.jsp.springboot_employee.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot_employee.entity.Employee;
import com.jsp.springboot_employee.entity.ResponseStructure;
import com.jsp.springboot_employee.repository.EmployeeRepository;
import com.jsp.springboot_employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public ResponseEntity<ResponseStructure<Employee>> addEmployee(Employee employee) 
	{
		Employee employee2 = employeeRepository.save(employee);
		
		ResponseStructure<Employee> responseStructure=new ResponseStructure<Employee>();
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Data Added Successfully");
		responseStructure.setData(employee2);
		
		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure,HttpStatus.CREATED) ;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Employee>>> findAllEmployee()
	{
		List<Employee> employee=employeeRepository.findAll();
		
		ResponseStructure<List<Employee>> responseStructure=new ResponseStructure<List<Employee>>();
		
		responseStructure.setStatuscode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Data Found Successfully");
		responseStructure.setData(employee);
		
		if(employee.isEmpty())
		{
			return null;
		}
		else
		{
			return new ResponseEntity<ResponseStructure<List<Employee>>>(responseStructure,HttpStatus.FOUND) ;
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Employee>> findEmployeeById(int employeeId) 
	{
		Optional<Employee> optional=employeeRepository.findById(employeeId);
		ResponseStructure<Employee> responseStructure=new ResponseStructure<Employee>();
		
		if(optional.isPresent())
		{
			Employee employee = optional.get();
			
			responseStructure.setStatuscode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Data Found Successfully");
			responseStructure.setData(employee);
			
			return new  ResponseEntity<ResponseStructure<Employee>>(responseStructure,HttpStatus.FOUND);
		}
		else
		{
			return null;
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(int employeeId, Employee employee)
	{
		Optional<Employee> optional=employeeRepository.findById(employeeId);
		ResponseStructure<Employee> responseStructure=new ResponseStructure<Employee>();
		
		
		if(optional.isPresent())
		{
			Employee currentEmployee = optional.get();
			
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setMessage("Data Updated Successfully");
			responseStructure.setData(employee);
			
			currentEmployee.setEmployeeId(employeeId);
		    employeeRepository.save(employee);
		    return new  ResponseEntity<ResponseStructure<Employee>>(responseStructure,HttpStatus.OK);
		}
		else
		{
			return null;
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(int employeeId)
	{
		Optional<Employee> optional=employeeRepository.findById(employeeId);
		ResponseStructure<Employee> responseStructure=new ResponseStructure<Employee>();
		
		if(optional.isPresent())
		{
			Employee employee = optional.get();
			
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setMessage("Data Deleted Successfully");
			responseStructure.setData(employee);
			
			employeeRepository.delete(employee);
			return new  ResponseEntity<ResponseStructure<Employee>>(responseStructure,HttpStatus.OK);
		}
		else
		{
			return null;
		}
	}

}
