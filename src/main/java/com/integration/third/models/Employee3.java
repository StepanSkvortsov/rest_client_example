package com.integration.third.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Employee3 {
    @Id
    @SequenceGenerator(name = "employee_gen", sequenceName = "employee_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "employee_gen", strategy = GenerationType.IDENTITY)
    private int id;
    private int employee_age;
    private String employee_name;
    private String employee_salary;
    private String profile_image;
}
