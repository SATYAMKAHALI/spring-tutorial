package com.example.Satyam.service;

import com.example.Satyam.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    JdbcTemplate jdbcTemplate;   //Autowired annotation creates an object automatically...
    // here it created an object of JDBC Template predefined class

    public List<Employee> getEmps() {

        String sql = "select * from employee";
        List<Employee> employees = jdbcTemplate.query(sql, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee emp = new Employee();
                emp.setId(rs.getInt("emp_id"));
                emp.setName(rs.getString("emp_name"));
                emp.setRole(rs.getString("emp_role"));
                emp.setDob(rs.getDate("emp_dob"));
                return emp;
            }
        });
        return employees;


}

    public String saveEmp(Employee e) {
        String sql= "insert into employee values (?, ?, ?, ?) ";
       try{
           jdbcTemplate.update(sql,e.getId(),e.getName(),e.getRole(),e.getDob());
       }catch (Exception er){
           er.printStackTrace();
           return "Cant save employee";
       }
       return "Employee saved successfully";

    }

    public String updateEmployee(String name, String role) {
        String sql= " update employee set emp_role= ? where emp_name=? ";
        try{
            jdbcTemplate.update(sql,role,name);
        }catch (Exception er){
            er.printStackTrace();
            return "Can't save employee";
        }
        return "Employee updated successfully";
    }

    public String deleteEmp(String name) {
        String sql="delete from employee where emp_name = ?";
        try{
            jdbcTemplate.update(sql,name);
        }catch (Exception er){
            er.printStackTrace();
            return "Can't delete employee";
        }
        return "Employee deleted";
    }

    public Employee getEmplByID(int id) {
        String sql= "select * from employee where emp_id= ? ";
        Employee empl;
        try{
            empl=jdbcTemplate.queryForObject(sql, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee emplo= new Employee();
                emplo.setId(rs.getInt("emp_id"));
                emplo.setName(rs.getString("emp_name"));
                emplo.setRole(rs.getString("emp_role"));
                emplo.setDob(rs.getDate("emp_dob"));
                return emplo;
                           }
        },id);
    }catch (Exception e){
            e.printStackTrace();
            return new Employee();
        }
        return empl;

        }
}
