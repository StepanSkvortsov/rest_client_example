package com.integration.rest_client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.integration.controller.EmpForApi;
import com.integration.primary.models.Employee;
import com.integration.primary.service.EmployeeServiceImpl;
import com.integration.secondary.models.Employee2;
import com.integration.secondary.service.Employee2ServiceImpl;
import com.integration.third.models.Employee3;
import com.integration.third.service.Employee3ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Service
public class RestClientService{

    @Autowired
    EmployeeServiceImpl employeeService;
    @Autowired
    Employee2ServiceImpl employee2Service;
    @Autowired
    Employee3ServiceImpl employee3Service;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ObjectMapper mapper;
    @Autowired
    HttpEntity entity;
    @Value("${get-all-employees-url}")
    private String getAllurl;
    @Value("${get-one-employee-url}")
    private String getOneUrl;
    @Value("${create-employee-url}")
    private String createUrl;
    @Value("${update-employee-url}")
    private String updateUrl;
    @Value("${delete-employee-url}")
    private String deleteUrl;

    public void loadEmployees() throws IOException {

        ResponseEntity<String> responseEntity = restTemplate.exchange(getAllurl, HttpMethod.GET, entity, String.class);
        String json = responseEntity.getBody();

        List<Employee> employees = mapper.readValue(json, new TypeReference<List<Employee>>() {
        });
        List<Employee2> employees2 = mapper.readValue(json, new TypeReference<List<Employee2>>() {
        });
        List<Employee3> employees3 = mapper.readValue(json, new TypeReference<List<Employee3>>() {
        });

        employeeService.saveAll(employees);
        employee2Service.saveAll(employees2);
        employee3Service.saveAll(employees3);
    }

    public List<Employee> getAll() throws IOException {
        ResponseEntity<String> responseEntity = restTemplate.exchange(getAllurl, HttpMethod.GET, entity, String.class);
        String json = responseEntity.getBody();
        List<Employee> employees = mapper.readValue(json, new TypeReference<List<Employee>>() {
        });
        return employees;
    }

    public Employee getById(Integer id) throws IOException {
        ResponseEntity<String> responseEntity = restTemplate.exchange(getOneUrl+id, HttpMethod.GET, entity, String.class);
        String json = responseEntity.getBody();
        Employee employee = mapper.readValue(json, Employee.class);
        return employee;
    }

    public EmpForApi createEmployee(EmpForApi employee) throws IOException {
        HttpEntity<String> entity = new HttpEntity(employee, new HttpHeaders());
        ResponseEntity<String> responseEntity = restTemplate.exchange(createUrl, HttpMethod.POST, entity, String.class);
        String json = responseEntity.getBody();
        EmpForApi employee1 = mapper.readValue(json, EmpForApi.class);
        return employee1;
    }

    public String deleteEmployee(Integer id){
        ResponseEntity<String> responseEntity = restTemplate.exchange(deleteUrl+id, HttpMethod.DELETE, entity, String.class);
        return responseEntity.getBody();
    }

    public EmpForApi updateEmployee(Integer id, EmpForApi employee) throws IOException {
        HttpEntity<String> entity = new HttpEntity(employee, new HttpHeaders());
        ResponseEntity<String> responseEntity = restTemplate.exchange(updateUrl+id, HttpMethod.PUT, entity, String.class);
        String json = responseEntity.getBody();
        EmpForApi employee1 = mapper.readValue(json, EmpForApi.class);
        return employee1;
    }

}
