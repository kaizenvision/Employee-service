package com.reactcurd.employeeservice.service;

import com.reactcurd.employeeservice.exception.EmployeeNotFound;
import com.reactcurd.employeeservice.model.Employee;
import com.reactcurd.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Optional<Employee> deleteEmployee(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(!Optional.ofNullable(employee).isEmpty())
            employeeRepository.deleteById(id);
        return employee;
    }

    public void updateEmployee(Employee employee, long id) throws EmployeeNotFound {
        Optional<Employee> employee1 = employeeRepository.findById(id);
        if (!Optional.ofNullable(employee1).isEmpty()){
            employeeRepository.save(employee);
        }
        else {
            throw new EmployeeNotFound("NO employee found");
        }
    }
}
