package com.integration.secondary.service;


import com.integration.primary.models.Employee;
import com.integration.primary.repositories.EmployeeRepository;
import com.integration.primary.service.EmployeeService;
import com.integration.secondary.models.Employee2;
import com.integration.secondary.repositories.Employee2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class Employee2ServiceImpl implements Employee2Service {


    @Autowired
    Employee2Repository employee2Repository;

    @Override
    public List<Employee2> saveAll(List<Employee2> employees) {
        List<Employee2> employeeList = employee2Repository.saveAll(employees);
        return employeeList;
    }

    @Override
    public List<Employee2> getAll() throws IOException {

        List<Employee2> employeeList = employee2Repository.findAll();

        return employeeList;
    }

    @Override
    public Optional<Employee2> getById(Integer id) {

        Optional<Employee2> employee = employee2Repository.findById(id);

        return employee;
    }



    @Override
    public Employee2 createEmployee2(Employee2 employee) {
        Employee2 employee1 = employee2Repository.save(employee);
        return employee1;
    }

    @Override
    public Employee2 updateEmployee2(Integer id, Employee2 employee) {

        Optional<Employee2> employee1 = employee2Repository.findById(id);
        if (employee1.isPresent()) {
            return employee2Repository.save(employee);
        }
        return null;
    }

    @Override
    public void deleteEmployee2(Integer id) {
        employee2Repository.deleteById(id);
    }

}
