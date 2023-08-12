package com.example.springweb.service;

import com.example.springweb.model.Employee;

import java.util.List;

public interface EmployeeService {
    int getSumSalary();
    int getMinSalary();
    int getMaxSalary();
    List<Employee> getHighSalary();

    void create(List<Employee> employees);

    void update(int id, Employee employee);


    Employee get(int id);

    void delete(int id);

    List<Employee> getHigherSalaryThan(int salary);
}
