package uz.developer.springthymleafcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.developer.springthymleafcrud.entity.Employee;
import uz.developer.springthymleafcrud.service.EmployeeService;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listEmployees", service.getAllEmployee());
        return "index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model)
    {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        service.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showFromForUpdate/{id}")
    public String showFromForUpdate(@PathVariable(value="id") long id, Model model){
        Employee employee = service.getEmployeeById(id);

        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") long id){
        this.service.deleteEmployeeById(id);
        return "redirect:/";
    }
}
