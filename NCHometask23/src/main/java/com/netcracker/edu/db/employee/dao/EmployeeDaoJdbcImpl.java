package com.netcracker.edu.db.employee.dao;

import com.netcracker.edu.db.employee.model.Employee;

import java.math.BigInteger;
import java.security.cert.CollectionCertStoreParameters;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class EmployeeDaoJdbcImpl implements EmployeeDao {

	private Statement getConnectionandStatement() throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@127.0.0.1:1521:XE", "HR", "steam373");
		Statement stmt = con.createStatement();
		return stmt;

	}
	public EmployeeDaoJdbcImpl() {
		Locale.setDefault(Locale.ENGLISH);
		try {
			this.getConnectionandStatement();

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();

		}
	}

	public Employee getEmployeeById(BigInteger employeeId) {

		try {
			Employee ret = new Employee();

			ResultSet rs = this.getConnectionandStatement()
					.executeQuery(QueryConstants.selectWithId + employeeId);

			if (rs.next()) {
				ret.setId(rs.getObject("id", BigInteger.class));
				ret.setName(rs.getObject("name", String.class));
				ret.setSurname(rs.getObject("surname", String.class));
				ret.setPosition(rs.getObject("position", String.class));
				ret.setDepartmentId(
						rs.getObject("departmentId", Integer.class));
				ret.setSalary(rs.getObject("salary", Integer.class));

				return ret;

			} else {
				System.out.println("No employee with such ID");
				return null;
			}

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();

		}
		return null;
	}

	public boolean addEmployee(Employee employee) {
		try {

			this.getConnectionandStatement().execute(QueryConstants.insertAll
					+ employee.getId() + ", '" + employee.getName() + "', '"
					+ employee.getSurname() + "', '" + employee.getPosition()
					+ "', '" + employee.getDepartmentId() + "', "
					+ employee.getSalary() + ")");

			return true;

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();

		}

		return false;
	}

	public boolean updateEmployee(Employee employee) {
		try {

			this.getConnectionandStatement()
					.execute(QueryConstants.updateAll + employee.getName()
							+ "',surname='" + employee.getSurname()
							+ "',position='" + employee.getPosition()
							+ "', departmentid=" + employee.getDepartmentId()
							+ ", salary=" + employee.getSalary() + " where id="
							+ employee.getId());

			return true;

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();

		}

		return false;

	}

	public boolean deleteEmployee(Employee employee) {

		try {

			this.getConnectionandStatement()
					.execute(QueryConstants.deleteWithId + employee.getId());

			return true;

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();

		}

		return false;
	}

	public List<Employee> getEmployeesBySurname(String surname) {
		try (ResultSet rs = this.getConnectionandStatement().executeQuery(
				QueryConstants.selectWithSurname + surname + "'");) {
			List<Employee> ret = new LinkedList<Employee>();

			while (rs.next()) {

				ret.add(new Employee(rs.getObject("id", BigInteger.class),
						rs.getObject("name", String.class),
						rs.getObject("surname", String.class),
						rs.getObject("position", String.class),
						rs.getObject("departmentId", Integer.class),
						rs.getObject("salary", Integer.class)));

			}
			return ret;
		} catch (Exception e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public List<Employee> getEmployeesByDepartmentId(long departmentId) {
		try (ResultSet rs = this.getConnectionandStatement().executeQuery(
				QueryConstants.selectWithDepartment + departmentId);) {
			List<Employee> ret = new LinkedList<Employee>();

			while (rs.next()) {

				ret.add(new Employee(rs.getObject("id", BigInteger.class),
						rs.getObject("name", String.class),
						rs.getObject("surname", String.class),
						rs.getObject("position", String.class),
						rs.getObject("departmentId", Integer.class),
						rs.getObject("salary", Integer.class)));

			}
			return ret;
		} catch (Exception e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		return Collections.emptyList();

	}

	public List<Employee> getEmployeesWithGreaterSalary(long thresholdSalary) {
		try (ResultSet rs = this.getConnectionandStatement().executeQuery(
				QueryConstants.selectWithGreaterSalary + thresholdSalary);) {
			List<Employee> ret = new LinkedList<Employee>();

			while (rs.next()) {

				ret.add(new Employee(rs.getObject("id", BigInteger.class),
						rs.getObject("name", String.class),
						rs.getObject("surname", String.class),
						rs.getObject("position", String.class),
						rs.getObject("departmentId", Integer.class),
						rs.getObject("salary", Integer.class)));

			}
			return ret;
		} catch (Exception e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		return Collections.emptyList();

	}

	public List<Employee> getAllEmployees() {
		try (ResultSet rs = this.getConnectionandStatement()
				.executeQuery(QueryConstants.selectAll);) {
			List<Employee> ret = new LinkedList<Employee>();

			while (rs.next()) {

				ret.add(new Employee(rs.getObject("id", BigInteger.class),
						rs.getObject("name", String.class),
						rs.getObject("surname", String.class),
						rs.getObject("position", String.class),
						rs.getObject("departmentId", Integer.class),
						rs.getObject("salary", Integer.class)));

			}
			return ret;
		} catch (Exception e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		return Collections.emptyList();

	}
}
