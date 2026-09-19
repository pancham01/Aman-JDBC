package com.learning.main;

import java.sql.SQLException;

import com.learning.dao.StudentDao;
import com.learning.dao.StudentDaoImpl;
import com.learning.entity.Student;

public class Main {

	public static void main(String[] args) throws SQLException {

		
		Student stu1 = new Student();
		stu1.setId(10);
		stu1.setName("Ankit Kumar");
		stu1.setGender("Male");
		stu1.setAge(54);
		
		StudentDao dao = new StudentDaoImpl();
//		dao.saveStudent(stu1);
		dao.updateStudent(stu1);
		
		System.out.println("Main.main()");

	}

}
