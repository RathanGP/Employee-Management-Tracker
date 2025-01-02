package com.jsp.springboot_employee.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.springboot_employee.entity.Employee;
import com.jsp.springboot_employee.entity.ResponseStructure;

public interface EmployeeService
{
	public ResponseEntity<ResponseStructure<Employee>> addEmployee(Employee employee);
	public ResponseEntity<ResponseStructure<List<Employee>>> findAllEmployee();
	public ResponseEntity<ResponseStructure<Employee>> findEmployeeById(int employeeId);
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(int employeeId,Employee employee);
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(int employeeId);

}
