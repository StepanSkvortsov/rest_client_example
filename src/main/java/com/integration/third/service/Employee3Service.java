package com.integration.third.service;


import com.integration.third.models.Employee3;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface Employee3Service {
    List<Employee3> saveAll(List<Employee3> employees);

    List<Employee3> getAll() throws IOException;

    Optional<Employee3> getById(Integer id);

    Employee3 createEmployee3(Employee3 employee);

    Employee3 updateEmployee3(Integer id, Employee3 employee);

    void deleteEmployee3(Integer id);
}
