package com.integration.secondary.service;

import com.integration.secondary.models.Employee2;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface Employee2Service {

    List<Employee2> saveAll(List<Employee2> employees);

    List<Employee2> getAll() throws IOException;

    Optional<Employee2> getById(Integer id);

    Employee2 createEmployee2(Employee2 employee);

    Employee2 updateEmployee2(Integer id, Employee2 employee);

    void deleteEmployee2(Integer id);
}
