package ar.com.erchamatur.employeemanager.controller;

import ar.com.erchamatur.employeemanager.model.Employee;
import ar.com.erchamatur.employeemanager.service.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employeeToAdd){
        Employee employee = employeeService.addEmployee(employeeToAdd);
        return new ResponseEntity<>(employee,HttpStatus.CREATED);
    }

    @PostMapping("/add/all")
    public ResponseEntity<List<Employee>> addManyEmployees(@NonNull @RequestBody List<Employee> employeesToAdd){
        List<Employee> employees = new ArrayList<Employee>();
        employeesToAdd.forEach((employee) ->  {
            employees.add(employeeService.addEmployee(employee));
        });
        return new ResponseEntity<List<Employee>>(employees,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employeeToUpdate){
        Employee employee = employeeService.updateEmployee(employeeToUpdate);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Long id){
        boolean deleted = employeeService.deleteEmployee(id);
        return (deleted) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>( HttpStatus.NOT_MODIFIED);
    }

}
