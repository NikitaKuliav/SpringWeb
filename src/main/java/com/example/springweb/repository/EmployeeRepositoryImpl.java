package com.example.springweb.repository;


import com.example.springweb.exceptions.EmployeeNotFoundException;
import com.example.springweb.model.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRespository {

    private static final List<Employee> EMPLOYEE_LIST = new ArrayList<>();

    @PostConstruct
    public void init(){
        EMPLOYEE_LIST.add(new Employee(1,"Sergey", 80000));
        EMPLOYEE_LIST.add(new Employee(2,"Ivan", 90000));
        EMPLOYEE_LIST.add(new Employee(3,"Maria", 100000));
        EMPLOYEE_LIST.add(new Employee(4,"Anna", 110000));
        EMPLOYEE_LIST.add(new Employee(5,"Gleb", 70000));

    }

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

    @Override
    public void updateEmployee(int id, Employee employee) {
        Employee oldEmployee = EMPLOYEE_LIST.stream().
                filter(emp -> emp.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        EMPLOYEE_LIST.set(id-1, employee);

    }

    @Override
    public void deleteEmployee(int id) {
        Employee oldEmployee = EMPLOYEE_LIST.stream().
                filter(emp -> emp.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        EMPLOYEE_LIST.remove(id-1);
    }
}

