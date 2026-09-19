package com.learning.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.learning.entity.Student;

public class StudentDaoImpl implements StudentDao {

	public static final String INSERT_QUERY = "INSERT INTO STUDENT(ID,NAME,GENDER,AGE) VALUES(%d,'%s','%s',%d)";
	public static final String UPDATE_QUERY = "UPDATE STUDENT SET NAME = '%s' , AGE = %d WHERE ID = %d";

	static Connection conn;
	static {

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myjdbc", "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void saveStudent(Student s) throws SQLException {

		Statement statement = conn.createStatement();

//		statement.executeUpdate("INSERT INTO STUDENT(ID,NAME,GENDER,AGE) VALUES(" + s.getId() + ",'" + s.getName()
//				+ "','" + s.getGender() + "'," + s.getAge() + ")");

		statement.executeUpdate(String.format(INSERT_QUERY, s.getId(),s.getName(),s.getGender(),s.getAge()));
		statement.close();
		System.err.println(String.format(INSERT_QUERY, s.getId(), s.getName(), s.getGender(), s.getAge()));

	}

	@Override
	public void updateStudent(Student s) {

		try (Statement statement = conn.createStatement()) {
			
			statement.executeUpdate(String.format(UPDATE_QUERY,s.getName(),s.getAge(),s.getId()));
			
			System.err.println(String.format(UPDATE_QUERY,s.getName(),s.getAge(),s.getId()));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getStudentById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getAllStudent() {
		// TODO Auto-generated method stub

	}

}
