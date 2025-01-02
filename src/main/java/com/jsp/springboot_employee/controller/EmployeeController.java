package com.jsp.springboot_employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsp.springboot_employee.entity.Employee;
import com.jsp.springboot_employee.entity.ResponseStructure;
import com.jsp.springboot_employee.service.EmployeeService;

@Controller
@ResponseBody
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/employee/addEmployee",method = RequestMethod.POST)
	public ResponseEntity<ResponseStructure<Employee>> addEmployee(@RequestBody Employee employee)
	{
		return employeeService.addEmployee(employee);
	}
	
	@RequestMapping(value = "/employee/findAllEmployee",method = RequestMethod.GET)
	public  ResponseEntity<ResponseStructure<List<Employee>>> findAllEmployeee()
	{
		return employeeService.findAllEmployee();
	}
	
	@RequestMapping(value = "/employee/findEmployeeById",method = RequestMethod.GET)
	public ResponseEntity<ResponseStructure<Employee>> findEmployeeById(@RequestParam int employeeId)
	{
		return employeeService.findEmployeeById(employeeId);
	}
	
	@RequestMapping(value = "/employee/updateEmployee",method = RequestMethod.PUT)
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestParam int employeeId,@RequestBody Employee employee)
	{
		return employeeService.updateEmployee(employeeId,employee);
	}
	
	@RequestMapping(value = "/employee/deleteEmployee",method = RequestMethod.DELETE)
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(@RequestParam int employeeId)
	{

		return employeeService.deleteEmployee(employeeId);
	}

}
