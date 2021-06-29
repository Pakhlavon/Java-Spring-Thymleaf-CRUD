package uz.developer.springthymleafcrud.service;

import org.springframework.data.domain.Page;
import uz.developer.springthymleafcrud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);
    Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
