package com.integration.primary.service;

import com.integration.primary.models.Employee;
import com.integration.primary.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> saveAll(List<Employee> employees) {
        List<Employee> employeeList = employeeRepository.saveAll(employees);
        return employeeList;
    }

    @Override
    public List<Employee> getAll() throws IOException {

        List<Employee> employeeList = employeeRepository.findAll();

        return employeeList;
    }

    @Override
    public Optional<Employee> getById(Integer id) {

        Optional<Employee> employee = employeeRepository.findById(id);

        return employee;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        Employee employee1 = employeeRepository.save(employee);
        return employee1;
    }

    @Override
    public Employee updateEmployee(Integer id, Employee employee) {

        Optional<Employee> employee1 = employeeRepository.findById(id);
        if (employee1.isPresent()) {
            return employeeRepository.save(employee);
        }
        return null;
    }

    @Override
    public void deleteEmployee(Integer id) {

        employeeRepository.deleteById(id);
    }
}
