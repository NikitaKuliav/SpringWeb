package com.example.springweb.repository;


import com.example.springweb.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeRepositoryImpl implements EmployeeRespository {

    private static final List<Employee> EMPLOYEE_LIST = List.of(
            new Employee("Sergey", 80000),
            new Employee("Ivan", 90000),
            new Employee("Maria", 100000),
            new Employee("Anna", 110000),
            new Employee("Gleb", 70000)
    );


    @Override
    public ArrayList<Employee> getEmployees() {
        return new ArrayList<>(EMPLOYEE_LIST);
    }

    @Override
    public void addEmployee(Employee employee) {
        EMPLOYEE_LIST.add(employee);
    }

    @Override
    public Optional<Employee> getEmployee(int id) {
//        Employee employee = EMPLOYEE_LIST.get(id);
        return EMPLOYEE_LIST.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst();
    }
}

