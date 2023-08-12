package com.example.springweb.repository;

import com.example.springweb.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface EmployeeRespository {

    ArrayList<Employee> getEmployees();
    void addEmployee(Employee employee);
    Optional<Employee> getEmployee(int id);
    void updateEmployee(int id, Employee employee);
    void deleteEmployee(int id);
}
