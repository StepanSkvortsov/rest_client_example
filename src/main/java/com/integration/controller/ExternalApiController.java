package com.integration.controller;

import com.integration.primary.models.Employee;
import com.integration.primary.service.EmployeeServiceImpl;
import com.integration.rest_client.RestClientService;
import com.integration.secondary.service.Employee2ServiceImpl;
import com.integration.third.service.Employee3ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class ExternalApiController {

    @Autowired
    EmployeeServiceImpl employeeService;
    @Autowired
    Employee2ServiceImpl employee2Service;
    @Autowired
    Employee3ServiceImpl employee3Service;
    @Autowired
    RestClientService restClientService;

    @GetMapping("/getFromExternalApi")
    public String loadEmployees() throws IOException {

        try {
            restClientService.loadEmployees();
            return "done";
        } catch (Exception e) {
            return "error :"+e.getMessage();
        }
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() throws IOException {
        return restClientService.getAll();
    }
    @GetMapping("/employees/{id}")
    public Employee getById(Integer id) throws IOException {
        return restClientService.getById(id);
    }
    @PostMapping("/employee")
    public EmpForApi createEmployee(@RequestBody EmpForApi employee) throws IOException {
        return restClientService.createEmployee(employee);
    }
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        return restClientService.deleteEmployee(id);
    }
    @PutMapping("/employee/{id}")
    public EmpForApi updateEmployee(Integer id, @RequestBody EmpForApi employee) throws IOException {
        return restClientService.updateEmployee(id, employee);
    }

}
