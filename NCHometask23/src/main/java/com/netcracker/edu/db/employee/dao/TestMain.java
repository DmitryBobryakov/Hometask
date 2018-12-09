package com.netcracker.edu.db.employee.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

import com.netcracker.edu.db.employee.model.Employee;

public class TestMain {
	public static void main(String[] args)
			throws NumberFormatException, IOException {
		EmployeeDaoJdbcImpl daoJdbcImpl = new EmployeeDaoJdbcImpl();

		while (true) {
			BufferedReader input = new BufferedReader(
					new InputStreamReader(System.in));
			System.out.println("1) ����� ���������� �� ID");
			System.out.println("2) �������� ����������");
			System.out.println("3) �������� ����������");
			System.out.println("4) ������� ����������");
			System.out.println("5) ����� ����������� �� �������");
			System.out.println("6) ����� ����������� �� ������");
			System.out
					.println("7) ����� ����������� � ��������� ���� ��������");
			System.out.println("8) ������� ���� �����������");

			int i = Integer.parseInt(input.readLine());

			switch (i) {
				case 1 :
					System.out.println("������� ID ����������:");
					Employee ret = daoJdbcImpl.getEmployeeById(BigInteger
							.valueOf(Integer.parseInt(input.readLine())));
					System.out.println(ret);
					break;

				case 2 :
					System.out.println(
							"������� ID, ���, �������, ���������. ����� � �������� ����������");
					Employee employee = new Employee();
					employee.setId(BigInteger
							.valueOf(Integer.parseInt(input.readLine())));
					employee.setName(input.readLine());
					employee.setSurname(input.readLine());
					employee.setPosition(input.readLine());
					employee.setDepartmentId(
							Integer.parseInt(input.readLine()));
					employee.setSalary(Integer.parseInt(input.readLine()));

					daoJdbcImpl.addEmployee(employee);
					break;

				case 3 :
					System.out.println(
							"������� ID ���������� � ��� ����� ������");
					Employee employee1 = new Employee();
					employee1.setId(BigInteger
							.valueOf(Integer.parseInt(input.readLine())));
					employee1.setName(input.readLine());
					employee1.setSurname(input.readLine());
					employee1.setPosition(input.readLine());
					employee1.setDepartmentId(
							Integer.parseInt(input.readLine()));
					employee1.setSalary(Integer.parseInt(input.readLine()));

					if (daoJdbcImpl.updateEmployee(employee1)) {
						System.out.println("�������");
					} else {
						System.out.println("��������");
					}

					break;
				case 4 :
					System.out.println("������� ID ����������");
					Employee employee2 = new Employee();
					employee2.setId(BigInteger
							.valueOf(Integer.parseInt(input.readLine())));
					if (daoJdbcImpl.deleteEmployee(employee2)) {
						System.out.println("�������");
					} else {
						System.out.println("��������");
					}
					break;
				case 5 :
					System.out.println("������� ������� �����������");
					String surname = input.readLine();
					System.out.println(
							daoJdbcImpl.getEmployeesBySurname(surname));

					break;

				case 6 :
					System.out.println("������� ����� �����������");
					long departmentID = Integer.parseInt(input.readLine());
					System.out.println(daoJdbcImpl
							.getEmployeesByDepartmentId(departmentID));

					break;
				case 7 :
					System.out.println("������� ��������");
					long newSalary = Integer.parseInt(input.readLine());
					System.out.println(daoJdbcImpl
							.getEmployeesWithGreaterSalary(newSalary));

					break;
				case 8 :

					System.out.println(daoJdbcImpl.getAllEmployees());

					break;
			}
		}

	}
}
