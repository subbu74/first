package com.javatpoint.dao;

import java.sql.SQLException;
import java.util.List;

import com.javatpoint.model.Employee;

public interface EmployeeDao {
	int saveEmployee(Employee e) throws SQLException;
	void updateEmployee(Employee e);
	List<Employee> findAll();
	Employee getEmployee(int id);
	void delete(int id);

}
