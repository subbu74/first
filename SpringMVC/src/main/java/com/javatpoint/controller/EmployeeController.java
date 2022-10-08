package com.javatpoint.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javatpoint.model.Employee;
import com.javatpoint.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "dispalyaddemployeepage", method = RequestMethod.GET)
	public String dispalyaddcustomerpage()
	{		
    	return "addemployee";
	}
	
    @RequestMapping(value = "saveemployeeinfo", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee") Employee emp)
	{
    	int id=0;
    	try {
			 id=employeeService.saveEmployee(emp);
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
    	return "redirect:/getallemployee";
	}
    
    @RequestMapping(value = "updateemployeeinfo", method = RequestMethod.POST)
   	public String updateEmployee(@ModelAttribute("employee") Employee emp)
   	{
    	employeeService.updateEmployee(emp);
       	return "redirect:/getallemployee";
   	}
    
    @RequestMapping(value = "deleteemployee/{id}")
   	public String updateEmployee(@PathVariable int id)
   	{
    	employeeService.delete(id);
       	return "redirect:/getallemployee";
   	}
    
    @RequestMapping(value = "editemployee/{id}")
	public String addEmployee(@PathVariable int id, Model model)
	{
    	Employee emp = employeeService.getEmployee(id);
    	model.addAttribute("emp", emp);
    	return "editemployee";
	}
    
    
    @RequestMapping(value = "getallemployee")
   	public String getAllEmployee()
   	{
    	setAllEmployeetoModel();
       	return "getemployees";
   	}
    
    @ModelAttribute("employees")
    private List<Employee> setAllEmployeetoModel()
    {
    	return employeeService.findAll();
    }

}
