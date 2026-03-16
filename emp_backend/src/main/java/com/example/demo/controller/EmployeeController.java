package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // GET ALL EMPLOYEES
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    // SEARCH EMPLOYEE BY ID OR NAME
    @GetMapping("/employees/search/{keyword}")
    public List<Employee> searchEmployee(@PathVariable String keyword){
        return employeeRepository.searchEmployee(keyword);
    }

    // CREATE EMPLOYEE
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    // GET EMPLOYEE BY ID
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getByID(@PathVariable Long id){

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee with id "+id+" does not exist"));

        return ResponseEntity.ok(employee);
    }

    // UPDATE EMPLOYEE
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployeeByID(
            @PathVariable Long id,
            @RequestBody Employee employeeDetails){

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee with id "+id+" does not exist"));

        employee.setFname(employeeDetails.getFname());
        employee.setLname(employeeDetails.getLname());
        employee.setEmail(employeeDetails.getEmail());
        employee.setDepartment(employeeDetails.getDepartment());
        employee.setDesignation(employeeDetails.getDesignation());
        employee.setJoiningDate(employeeDetails.getJoiningDate());
        employee.setSalary(employeeDetails.getSalary());

        Employee updatedEmployee = employeeRepository.save(employee);

        return ResponseEntity.ok(updatedEmployee);
    }

    // DELETE EMPLOYEE
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee with id "+id+" does not exist"));

        employeeRepository.delete(employee);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }
}