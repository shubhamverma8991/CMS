package com.app.dao;

import java.util.List;

import com.app.pojos.FacultyNotice;
import com.app.pojos.Schedule;
import com.app.pojos.Student;
import com.app.pojos.User;

public interface IUserDao {
//add a method for user validation
	User validateUser(String email,String pass);
	
	public User registerUser(User u);
	
	List<User> listFaculty();
	List<Student> listStudent();
	
	User getFacultyDetails(int id);
	String updateFacultyDetails(User u);

	String deleteFacultyDetails(User user);
	//String registerUser(String name, int age, String email, String password, String address, String sme, int experience,
	//		String gender, String role);

	List<FacultyNotice> listnotice();

	List<Schedule> listschedule();
}
