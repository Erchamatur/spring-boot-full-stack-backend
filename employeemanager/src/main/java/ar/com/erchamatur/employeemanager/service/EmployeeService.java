package ar.com.erchamatur.employeemanager.service;

import ar.com.erchamatur.employeemanager.exception.UserNotFoundException;
import ar.com.erchamatur.employeemanager.model.Employee;
import ar.com.erchamatur.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User by id: "+id+" not found"));
    }

    public boolean deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
        return true;
    }


}
