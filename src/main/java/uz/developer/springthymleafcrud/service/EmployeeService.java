package uz.developer.springthymleafcrud.service;

import uz.developer.springthymleafcrud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);
}
