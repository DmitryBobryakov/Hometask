package com.netcracker.edu.db.employee.dao;

import com.netcracker.edu.db.employee.model.Employee;

import java.math.BigInteger;
import java.util.List;

/**
 * TODO: Implement using jdbc
 */
public class EmployeeDaoJdbcImpl implements EmployeeDao {

    public Employee getEmployeeById(BigInteger employeeId) {
        return null;
    }

    public boolean addEmployee(Employee employee) {
        return false;
    }

    public boolean updateEmployee(Employee employee) {
        return false;
    }

    public boolean deleteEmployee(Employee employee) {
        return false;
    }

    public List<Employee> getEmployeesBySurname(String surname) {
        return null;
    }

    public List<Employee> getEmployeesByDepartmentId(long departmentId) {
        return null;
    }

    public List<Employee> getEmployeesWithGreaterSalary(long thresholdSalary) {
        return null;
    }

    public List<Employee> getAllEmployees() {
        return null;
    }
}
