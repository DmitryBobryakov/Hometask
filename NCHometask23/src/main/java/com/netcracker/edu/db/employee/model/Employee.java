package com.netcracker.edu.db.employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee {

	

	private BigInteger id;
	private String name;
	private String surname;
	private String position;
	private long departmentId;
	private long salary;
}
