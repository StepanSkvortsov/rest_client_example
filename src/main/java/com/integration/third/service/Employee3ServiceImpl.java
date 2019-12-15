package com.integration.third.service;


import com.integration.primary.models.Employee;
import com.integration.third.models.Employee3;
import com.integration.third.repositories.Employee3Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class Employee3ServiceImpl implements Employee3Service {

    @Autowired
    Employee3Repository employee3Repository;

    @Override
    public List<Employee3> saveAll(List<Employee3> employees) {
        List<Employee3> employeeList = employee3Repository.saveAll(employees);
        return employeeList;
    }

    @Override
    public List<Employee3> getAll() throws IOException {

        List<Employee3> employeeList = employee3Repository.findAll();

        return employeeList;
    }

    @Override
    public Optional<Employee3> getById(Integer id) {

        Optional<Employee3> employee = employee3Repository.findById(id);

        return employee;
    }

    @Override
    public Employee3 createEmployee3(Employee3 employee) {
        Employee3 employee1 = employee3Repository.save(employee);
        return employee1;
    }

    @Override
    public Employee3 updateEmployee3(Integer id, Employee3 employee) {

        Optional<Employee3> employee1 = employee3Repository.findById(id);
        if (employee1.isPresent()) {
            return employee3Repository.save(employee);
        }
        return null;
    }

    @Override
    public void deleteEmployee3(Integer id) {
        employee3Repository.deleteById(id);
    }
}
