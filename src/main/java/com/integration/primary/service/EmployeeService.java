package com.integration.primary.service;

import com.integration.primary.models.Employee;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> saveAll(List<Employee> employees);

    List<Employee> getAll() throws IOException;

    Optional<Employee> getById(Integer id);

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Integer id, Employee employee);

    void deleteEmployee(Integer id);
}
