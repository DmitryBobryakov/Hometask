package com.netcracker.edu.db.employee.model;

import lombok.Data;

import java.math.BigInteger;

@Data
public class Employee {
    private BigInteger id;
    private String name;
    private String surname;
    private String position;
    private long departmentId;
    private long salary;
}