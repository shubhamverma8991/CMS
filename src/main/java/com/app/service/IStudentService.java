package com.app.service;

import java.util.List;

import com.app.pojos.CourseTable;
import com.app.pojos.Student;

public interface IStudentService {
	// add a method for user validation
	Student validateUser(String email, String pass);
	void saveFaculty(Student student);
	List<CourseTable> listAll();
	//User saveFaculty(User u);
}
