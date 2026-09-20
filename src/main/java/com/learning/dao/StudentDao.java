package com.learning.dao;

import java.sql.SQLException;
import java.util.List;

import com.learning.entity.Student;

public interface StudentDao {

	public void saveStudent(Student s) throws SQLException;

	public void updateStudent(Student s);

	public void deleteStudent(int id);

	public Student getStudentById(int id);

	public void printStudentByName(String name);

	public List<Student> getAllStudent();

	public void printAllStudent();

}
