package com.example.Satyam.controller;

import com.example.Satyam.model.Employee;
import com.example.Satyam.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService empService;

    @GetMapping("/getAllEmployees")
    public List<Employee> getEmployees(){
        return empService.getEmps();
    }
    @PostMapping("/saveEmployee")
    public String saveEmp(@RequestBody Employee e){
        return empService.saveEmp(e);
    }
    @PutMapping("/updateEmployeeRoleByName/{role}/{name}")
    public String updateEmployee(@PathVariable("role") String role,@PathVariable("name") String name){
        return empService.updateEmployee(name,role);
    }
    @DeleteMapping("/deleteEmployeeByName/{name}")
    public String deleteEmployee(@PathVariable("name")String name){
        return empService.deleteEmp(name);
    }
    @GetMapping("/getEmployeeById/{id}")
    public Employee getEmpById(@PathVariable int id ){
        return empService.getEmplByID(id);
    }
}
