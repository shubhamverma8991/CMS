package com.app.dao;

import java.util.List;

import com.app.pojos.CourseTable;
import com.app.pojos.Student;

public interface IStudentDao {
//add a method for user validation
	Student validateUser(String email,String pass);
	
	public Student registerUser(Student u);
	
	List<CourseTable> list();

	//String registerUser(String name, int age, String email, String password, String address, String sme, int experience,
	//		String gender, String role);
}
