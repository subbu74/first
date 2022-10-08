package com.javatpoint.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatpoint.dao.EmployeeDao;
import com.javatpoint.model.Employee;
import com.javatpoint.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public int saveEmployee(Employee e) throws SQLException {
		
		return employeeDao.saveEmployee(e);
	}

	@Override
	public List<Employee> findAll() {		
		return employeeDao.findAll();
	}

	@Override
	public Employee getEmployee(int id) {		
		return employeeDao.getEmployee(id);
	}

	@Override
	public void updateEmployee(Employee e) {
		employeeDao.updateEmployee(e);
		
	}

	@Override
	public void delete(int id) {
		employeeDao.delete(id);
		
	}

}
