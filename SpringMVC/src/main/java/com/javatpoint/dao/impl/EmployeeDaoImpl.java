package com.javatpoint.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.javatpoint.dao.EmployeeDao;
import com.javatpoint.jdbc.rowmappers.EmployeeRowMapper;
import com.javatpoint.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int saveEmployee(Employee employee) throws SQLException {
		String sql = "INSERT INTO employee (first_name, last_name, middle_name, salary)"
                + " VALUES (?, ?, ?, ?)";
		 int generatedId = 0;
		 
		 //below one follow when there is no primary key
		 
		//int  jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName(),
			//	employee.getMiddleName(), employee.getSalary());
		 
		 
		 //bellow method follow when there is primary key
		
		 Connection connection = jdbcTemplate.getDataSource().getConnection();
		    PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		    preparedStatement.setString(1, employee.getFirstName());
		    preparedStatement.setString(2, employee.getLastName());
		    preparedStatement.setString(3, employee.getMiddleName());
		    preparedStatement.setFloat(4, employee.getSalary());

		    preparedStatement.executeUpdate();
		    ResultSet keys = preparedStatement.getGeneratedKeys();

		    if (keys.next()) {
		         generatedId = keys.getInt(1); //id returned after insert execution
		    } 
		    
		    return generatedId;
	}

	@Override
	public List<Employee> findAll() {
		String sql = "SELECT * FROM EMPLOYEE";

        List<Employee> employeeList = jdbcTemplate.query(sql,new EmployeeRowMapper());

        return employeeList;
		
	}
	
	@Override
	public Employee getEmployee(int id) {
	    String sql = "SELECT * FROM EMPLOYEE WHERE id=" + id;
	    return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Employee.class));
	}

	@Override
	public void updateEmployee(Employee employee) {
		String sql = "UPDATE  employee  SET first_name=?, last_name=?, middle_name=?, salary=? WHERE id =?";
               
		   jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName(),
				employee.getMiddleName(), employee.getSalary(),employee.getId());
		
	}
	
	@Override
	public void delete(int id) {
	    String sql = "DELETE FROM EMPLOYEE WHERE id=?";
	    jdbcTemplate.update(sql, id);
	}


}
