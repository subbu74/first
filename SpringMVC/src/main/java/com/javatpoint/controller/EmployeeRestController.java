package com.javatpoint.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.model.Employee;
import com.javatpoint.service.EmployeeService;


@RestController
public class EmployeeRestController
{
	

	@Autowired
	private EmployeeService employeeService;
	
	
	@RequestMapping(value = "getemployee/{id}")
	public Employee getCustomer(@PathVariable int id)
	{
	return employeeService.getEmployee(id);
	}

	@RequestMapping(value = "saveemployee",method = RequestMethod.POST)
	public Employee saveEmployee(@RequestBody Employee employee) throws SQLException
	{
		int saveEmployee=employeeService.saveEmployee(employee);
		employee.setId(saveEmployee);
	    return employee;
	}
	
	@RequestMapping(value = "updateemployee",consumes = "application/json",produces = "application/json",method = RequestMethod.POST)
	public Employee updateEmployee(@RequestBody Employee employee)
	{
		employeeService.updateEmployee(employee);
	return employee;
	}

	@RequestMapping(value = "deleteemployeeinfo/{id}")
	public void deleteEmployee(@PathVariable int id)
	{
		employeeService.delete(id);
	}

	  @RequestMapping(value = "getallemployeeinfo")
	  public List<Employee> getAllEmployee()
	  {
	   
	      return employeeService.findAll();
	  }

	
}
