package com.javatpoint.jdbc.rowmappers;
import org.springframework.jdbc.core.RowMapper;

import com.javatpoint.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {

	
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

    	Employee emp = new Employee();
    	emp.setId(rs.getInt("id"));
    	emp.setFirstName(rs.getString("first_name"));
    	emp.setLastName(rs.getString("last_name"));
    	emp.setMiddleName(rs.getString("middle_name"));
    	emp.setSalary(rs.getFloat("salary"));

        return emp;

    }
}
