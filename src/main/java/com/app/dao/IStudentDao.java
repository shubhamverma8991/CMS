package com.app.dao;

import java.util.List;

import com.app.pojos.CourseTable;
import com.app.pojos.Student;
import com.app.pojos.StudentNotice;

public interface IStudentDao {
//add a method for user validation
	Student validateUser(String email,String pass);
	
	public Student registerUser(Student u);
	
	List<CourseTable> list();
	
	Student getStudentDetails(int id);
	String updateStudentDetails(Student student);

	String deleteStudentDetails(Student user);
	//String registerUser(String name, int age, String email, String password, String address, String sme, int experience,
	//		String gender, String role);

	List<CourseTable> listDAC();

	List<CourseTable> listDBDA();

	List<CourseTable> listDTISS();

	

	CourseTable getCourseDetails(int uid);

	String updateCourseDetails(CourseTable user);

	String deleteCourseDetails(CourseTable user);

	List<StudentNotice> listnotice();
}
