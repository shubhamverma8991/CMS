package com.app.service;

import java.util.List;

import com.app.pojos.CourseTable;
import com.app.pojos.Student;
import com.app.pojos.StudentNotice;

public interface IStudentService {
	// add a method for user validation
	Student validateUser(String email, String pass);

	void saveFaculty(Student student);

	List<CourseTable> listAll();

	

	String updateStudentDetails(Student student);

	String deleteStudentDetails(int id);

	List<CourseTable> listDAC();

	List<CourseTable> listDBDA();

	List<CourseTable> listDTISS();

	Student getStudentDetails(int id);
	
	String updateCourseDetails(CourseTable user);
	CourseTable getCourseDetails(int vid);

	String deleteCourseDetails(int vid);

	List<StudentNotice> listnotice();

	

	// User saveFaculty(User u);
}
