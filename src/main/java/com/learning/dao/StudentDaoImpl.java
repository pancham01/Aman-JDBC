package com.learning.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.learning.entity.Student;

public class StudentDaoImpl implements StudentDao {

	public static final String INSERT_QUERY = "INSERT INTO STUDENT(ID,NAME,GENDER,AGE) VALUES(%d,'%s','%s',%d)";
	public static final String UPDATE_QUERY = "UPDATE STUDENT SET NAME = '%s' , AGE = %d WHERE ID = %d";
	public static final String DELETE_QUERY = "DELETE FROM STUDENT WHERE ID = %d";
	public static final String SELECT_QUERY = "SELECT * FROM STUDENT ";
	public static final String SELECT_BY_ID_QUERY = "SELECT * FROM STUDENT WHERE ID = %d";
	public static final String SELECT_BY_NAME_QUERY = "SELECT * FROM STUDENT WHERE NAME = %s";

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

		statement.executeUpdate(String.format(INSERT_QUERY, s.getId(), s.getName(), s.getGender(), s.getAge()));
		statement.close();
		System.err.println(String.format(INSERT_QUERY, s.getId(), s.getName(), s.getGender(), s.getAge()));

	}

	@Override
	public void updateStudent(Student s) {

		try (Statement statement = conn.createStatement()) {

			statement.executeUpdate(String.format(UPDATE_QUERY, s.getName(), s.getAge(), s.getId()));

			System.err.println(String.format(UPDATE_QUERY, s.getName(), s.getAge(), s.getId()));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteStudent(int id) {
		try (Statement statement = conn.createStatement()) {

			statement.executeUpdate(String.format(DELETE_QUERY, id));

			System.err.println(String.format(DELETE_QUERY, id));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Student getStudentById(int id) {

		Student s1 = new Student();
		
		try (Statement statement = conn.createStatement()) {

			ResultSet rs = statement.executeQuery(String.format(SELECT_BY_ID_QUERY, id));

			rs.next();

			s1.setId(rs.getInt(1));
			s1.setName(rs.getString(2));
			s1.setGender(rs.getString(3));
			s1.setAge(rs.getInt(4));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return s1;

	}

	@Override
	public void printAllStudent() {

		try (Statement statement = conn.createStatement()) {

			ResultSet rs = statement.executeQuery(SELECT_QUERY);

			while (rs.next()) {

				System.out.println("Id = " + rs.getInt(1) + "\t Name = " + rs.getString(2) + "\t Gender = "
						+ rs.getString(3) + "\t Age = " + rs.getInt(4));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void printStudentByName(String name) {
		
		
		try (Statement statement = conn.createStatement()) {

			ResultSet rs = statement.executeQuery("SELECT * FROM STUDENT WHERE NAME = '"+name);

			while (rs.next()) {

				System.out.println("Id = " + rs.getInt(1) + "\t Name = " + rs.getString(2) + "\t Gender = "
						+ rs.getString(3) + "\t Age = " + rs.getInt(4));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}		
	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}

}
