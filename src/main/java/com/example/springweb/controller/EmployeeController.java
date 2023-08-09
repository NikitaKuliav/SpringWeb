package com.example.springweb.controller;

import com.example.springweb.model.Employee;
import org.springframework.web.bind.annotation.*;
import com.example.springweb.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/salary/sum")
    public int getSumSalary(){
        return employeeService.getSumSalary();
    }
    @GetMapping("/salary/min")
    public int min(){
        return employeeService.getMinSalary();
    }
    @GetMapping("/salary/max")
    public int max(){
        return employeeService.getMaxSalary();
    }
    @GetMapping("/high-salary")
    public List highSalary(){
        return employeeService.getHighSalary();

    }

    @PostMapping
    public void create(@RequestBody List<Employee> employees) {
        employeeService.create(employees);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Employee employee) {
        employeeService.update(id, employee);
    }

    @GetMapping("/{id}")
    public Employee get(@PathVariable int id) {
        return employeeService.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        employeeService.delete(id);
    }

    @GetMapping("/salaryHigherThan")
    public List<Employee> getSalaryHigherThan(@RequestParam int salary){
        return employeeService.getHigherSalaryThan(salary);
    }
}
