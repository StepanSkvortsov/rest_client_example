package com.integration.controller;

import com.integration.primary.models.Employee;
import com.integration.primary.service.EmployeeServiceImpl;
import com.integration.secondary.models.Employee2;
import com.integration.secondary.service.Employee2ServiceImpl;
import com.integration.third.models.Employee3;
import com.integration.third.service.Employee3ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class LocalController {

    @Autowired
    EmployeeServiceImpl employeeService;
    @Autowired
    Employee2ServiceImpl employee2Service;
    @Autowired
    Employee3ServiceImpl employee3Service;

    @GetMapping("/mysql/employees")
    public List<Employee> getAll() throws IOException {
        return employeeService.getAll();
    }

    @GetMapping("/postgresql/employees")
    public List<Employee2> getAll2() throws IOException {
        return employee2Service.getAll();
    }

    @GetMapping("/h2/employees")
    public List<Employee3> getAll3() throws IOException {
        return employee3Service.getAll();
    }

    @PostMapping("/mysql/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PostMapping("/postgresql/employees")
    public Employee2 createEmployee2(@RequestBody Employee2 employee) {
        return employee2Service.createEmployee2(employee);
    }

    @PostMapping("/h2/employees")
    public Employee3 createEmployee3(@RequestBody Employee3 employee) {
        return employee3Service.createEmployee3(employee);
    }

    @GetMapping("/mysql/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer id) {

        Optional<Employee> employee = employeeService.getById(id);
        if (employee.isPresent()) {
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/postgresql/employees/{id}")
    public ResponseEntity<Employee2> getEmployee2(@PathVariable("id") Integer id) {

        Optional<Employee2> employee = employee2Service.getById(id);
        if (employee.isPresent()) {
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/h2/employees/{id}")
    public ResponseEntity<Employee3> getEmployee3(@PathVariable("id") Integer id) {

        Optional<Employee3> employee = employee3Service.getById(id);
        if (employee.isPresent()) {
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/mysql/employee/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Integer id) {

        employeeService.deleteEmployee(id);

        return new ResponseEntity<>(HttpStatus.GONE);
    }

    @DeleteMapping("/postgresql/employee/{id}")
    public ResponseEntity<Void> deleteEmployee2(@PathVariable("id") Integer id) {

        employee2Service.deleteEmployee2(id);

        return new ResponseEntity<>(HttpStatus.GONE);
    }

    @DeleteMapping("/h2/employee/{id}")
    public ResponseEntity<Employee> deleteEmployee3(@PathVariable("id") Integer id) {

        employee3Service.deleteEmployee3(id);

        return new ResponseEntity<>(HttpStatus.GONE);
    }

    @PutMapping("/mysql/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {

        Employee employee1 = employeeService.updateEmployee(id, employee);

        return new ResponseEntity<>(employee1, HttpStatus.ACCEPTED);
    }

    @PutMapping("/postgresql/employee/{id}")
    public ResponseEntity<Employee2> updateEmployee2(@PathVariable("id") Integer id, @RequestBody Employee2 employee) {

        Employee2 employee1 = employee2Service.updateEmployee2(id, employee);

        return new ResponseEntity<>(employee1, HttpStatus.ACCEPTED);
    }

    @PutMapping("/h2/employee/{id}")
    public ResponseEntity<Employee3> updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee3 employee) {

        Employee3 employee1 = employee3Service.updateEmployee3(id, employee);

        return new ResponseEntity<>(employee1, HttpStatus.ACCEPTED);
    }

}
