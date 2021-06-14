package ar.com.erchamatur.employeemanager.repo;

import ar.com.erchamatur.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {

}
