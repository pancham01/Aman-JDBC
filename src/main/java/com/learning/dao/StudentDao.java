package com.learning.dao;

import java.sql.SQLException;

import com.learning.entity.Student;

public interface StudentDao {

	public void saveStudent(Student s)throws SQLException;

	public void updateStudent(Student s);

	public void deleteStudent(int id);

	public void getStudentById(int id);

	public void getAllStudent();

}
