package com.netcracker.edu.db.employee.dao;

public class QueryConstants {
	static String selectWithId = new String(
			"select * from test_table where id=");
	static String insertAll = new String(
			"insert into test_table (id, name,surname,position,departmentid,salary) values (");
	static String updateAll=new String("update test_table set name='");
	static String deleteWithId=new String("delete from test_table where id=");
	static String selectWithSurname=new String("select * from test_table where surname='");
	static String selectWithDepartment=new String("select * from test_table where departmentId=");
	static String selectWithGreaterSalary=new String("select * from test_table where salary>");
	static String selectAll=new String("select * from test_table");
	
}