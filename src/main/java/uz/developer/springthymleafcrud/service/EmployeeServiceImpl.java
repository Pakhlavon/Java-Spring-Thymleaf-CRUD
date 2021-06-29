package uz.developer.springthymleafcrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.developer.springthymleafcrud.entity.Employee;
import uz.developer.springthymleafcrud.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository repository;
    @Override
    public List<Employee> getAllEmployee() {
        return repository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.repository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> optional = repository.findById(id);
        Employee employee=null;
        if (optional.isPresent()){
            employee = optional.get();
        }
        else {
            throw new RuntimeException("Employee not found for id ::" + id);
        }
        return employee;
    }

    @Override
    public void deleteEmployeeById(long id) {
    this.repository.deleteById(id);
    }

    @Override
    public Page<Employee> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return this.repository.findAll(pageable);
    }
}
