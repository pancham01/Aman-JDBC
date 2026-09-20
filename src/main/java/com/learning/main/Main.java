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
//		dao.updateStudent(stu1);
//		dao.deleteStudent(10);
//		dao.printAllStudent();
//		System.out.println(dao.getStudentById(3));
		dao.printStudentByName("csdfew' or 1=1");
		System.out.println("Main.main()");

	}

}
