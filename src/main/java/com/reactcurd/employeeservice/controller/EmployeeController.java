package com.reactcurd.employeeservice.controller;

import com.reactcurd.employeeservice.exception.EmployeeNotFound;
import com.reactcurd.employeeservice.model.Employee;
import com.reactcurd.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin( origins = {"http://localhost:3000/"})
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @PostMapping("/addEmployee")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @DeleteMapping("/delete/{id}")
    public Optional<Employee> deleteEmployee(@PathVariable long id){
        return employeeService.deleteEmployee(id);
    }

    @PutMapping("/update/{id}")
    public void updateEmployee(@RequestBody Employee employee, @PathVariable long id) throws EmployeeNotFound {
        employeeService.updateEmployee(employee,id);
    }
}
