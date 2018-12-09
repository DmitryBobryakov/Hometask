package com.netcracker.edu.db.employee.model;

import lombok.Data;

import java.math.BigInteger;

@Data
public class Employee {

	public Employee(BigInteger id, String name, String surname, String position,
			long departmentid, long salary) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.position = position;
		this.departmentId = departmentid;
		this.salary = salary;
	}
	public Employee() {

	}

	private BigInteger id;
	private String name;
	private String surname;
	private String position;
	private long departmentId;
	private long salary;
}
