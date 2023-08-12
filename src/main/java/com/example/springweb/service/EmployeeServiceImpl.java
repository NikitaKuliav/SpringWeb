package com.example.springweb.service;

import com.example.springweb.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;
import com.example.springweb.model.Employee;
import com.example.springweb.repository.EmployeeRepositoryImpl;
import com.example.springweb.repository.EmployeeRespository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRespository employeeRespository = new EmployeeRepositoryImpl();

    public int getSumSalary() {

        ArrayList<Employee> employeeArrayList = employeeRespository.getEmployees();
        int sum = 0;
        for (Employee employee : employeeArrayList) {
            sum += employee.getSalary();
        }
        return sum;
    }

    public int getMinSalary() {
        ArrayList<Employee> employeeArrayList = employeeRespository.getEmployees();
        int min = Integer.MAX_VALUE;
        for (Employee employee : employeeArrayList) {
            if (employee.getSalary() < min) {
                min = employee.getSalary();
            }
        }
        return min;
    }

    public int getMaxSalary() {
        ArrayList<Employee> employeeArrayList = employeeRespository.getEmployees();
        int max = Integer.MIN_VALUE;
        for (Employee employee : employeeArrayList) {
            if (employee.getSalary() > max) {
                max = employee.getSalary();
            }
        }
        return max;
    }

    public List<Employee> getHighSalary() {
        ArrayList<Employee> employeeArrayList = employeeRespository.getEmployees();
        int sum = getSumSalary();
        int average = sum / employeeArrayList.size();
        ArrayList<Employee> employeesBetterAverage = new ArrayList<>(10);

        for (Employee employee : employeeArrayList){
            if(employee.getSalary() > average) {
                employeesBetterAverage.add(employee);
            }
        }
        return employeesBetterAverage;
    }



    @Override
    public void create(List<Employee> employees) {
        employees.forEach(employeeRespository::addEmployee);
    }

    @Override
    public void update(int id, Employee employee) {
        Employee oldEmployee = employeeRespository.getEmployee(id)
                .orElseThrow(()-> new EmployeeNotFoundException(id));


        employeeRespository.updateEmployee(id, employee);;

    }

    @Override
    public Employee get(int id) {
        Employee employee = employeeRespository.getEmployee(id)
                .orElseThrow(()-> new EmployeeNotFoundException(id));
        return employee;
    }

    @Override
    public void delete(int id) {
        Employee oldEmployee = employeeRespository.getEmployee(id)
                .orElseThrow(()-> new EmployeeNotFoundException(id));

        employeeRespository.deleteEmployee(id);;

    }

    @Override
    public List<Employee> getHigherSalaryThan(int salary) {

        List<Employee> employees = employeeRespository.getEmployees();
        employees = employees.stream().
                filter(employee -> employee.getSalary()>salary)
                .toList();
        return employees;
    }
}
