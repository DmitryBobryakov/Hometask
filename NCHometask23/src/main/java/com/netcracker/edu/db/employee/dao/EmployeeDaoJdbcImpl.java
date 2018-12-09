package com.netcracker.edu.db.employee.dao;

import com.netcracker.edu.db.employee.model.Employee;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class EmployeeDaoJdbcImpl implements EmployeeDao {

	public EmployeeDaoJdbcImpl() {
		Locale.setDefault(Locale.ENGLISH);
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:XE", "HR", "steam373");

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();

		}
	}

	public Employee getEmployeeById(BigInteger employeeId) {

		try {
			Employee ret = new Employee();
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:XE", "HR", "steam373");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select * from test_table where id=" + employeeId);
			if (rs.next()) {
				ret.setId(BigInteger.valueOf(rs.getInt(1)));
				ret.setName(rs.getString(2));
				ret.setSurname(rs.getString(3));
				ret.setPosition(rs.getString(4));
				ret.setDepartmentId(rs.getLong(5));
				ret.setSalary(rs.getInt(6));

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

			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:XE", "HR", "steam373");
			Statement stmt = con.createStatement();

			stmt.execute(
					"insert into test_table (id, name,surname,position,departmentid,salary)"
							+ " values (" + employee.getId() + ", '"
							+ employee.getName() + "', '"
							+ employee.getSurname() + "', '"
							+ employee.getPosition() + "', '"
							+ employee.getDepartmentId() + "', "
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

			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:XE", "HR", "steam373");
			Statement stmt = con.createStatement();

			stmt.execute("update test_table set name='" + employee.getName()
					+ "',surname='" + employee.getSurname() + "',position='"
					+ employee.getPosition() + "', departmentid="
					+ employee.getDepartmentId() + ", salary="
					+ employee.getSalary() + " where id=" + employee.getId());

			return true;

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();

		}

		return false;

	}

	public boolean deleteEmployee(Employee employee) {

		try {

			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:XE", "HR", "steam373");
			Statement stmt = con.createStatement();

			stmt.execute("delete from test_table where id=" + employee.getId());

			return true;

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();

		}

		return false;
	}

	public List<Employee> getEmployeesBySurname(String surname) {
		try (Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@127.0.0.1:1521:XE", "HR", "steam373");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt
						.executeQuery("select * from test_table where surname='"
								+ surname + "'");) {
			List<Employee> ret = new LinkedList<Employee>();

			while (rs.next()) {

				ret.add(new Employee(BigInteger.valueOf(rs.getInt(1)),
						rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getLong(5), rs.getLong(6)));

			}
			return ret;
		} catch (Exception e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		return null;
	}

	public List<Employee> getEmployeesByDepartmentId(long departmentId) {
		try (Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@127.0.0.1:1521:XE", "HR", "steam373");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(
						"select * from test_table where departmentId="
								+ departmentId);) {
			List<Employee> ret = new LinkedList<Employee>();

			while (rs.next()) {

				ret.add(new Employee(BigInteger.valueOf(rs.getInt(1)),
						rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getLong(5), rs.getLong(6)));

			}
			return ret;
		} catch (Exception e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		return null;

	}

	public List<Employee> getEmployeesWithGreaterSalary(long thresholdSalary) {
		try (Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@127.0.0.1:1521:XE", "HR", "steam373");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt
						.executeQuery("select * from test_table where salary>"
								+ thresholdSalary);) {
			List<Employee> ret = new LinkedList<Employee>();

			while (rs.next()) {

				ret.add(new Employee(BigInteger.valueOf(rs.getInt(1)),
						rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getLong(5), rs.getLong(6)));

			}
			return ret;
		} catch (Exception e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		return null;

	}

	public List<Employee> getAllEmployees() {
		try (Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@127.0.0.1:1521:XE", "HR", "steam373");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from test_table");) {
			List<Employee> ret = new LinkedList<Employee>();

			while (rs.next()) {

				ret.add(new Employee(BigInteger.valueOf(rs.getInt(1)),
						rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getLong(5), rs.getLong(6)));

			}
			return ret;
		} catch (Exception e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		return null;

	}
}
