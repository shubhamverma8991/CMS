package com.app.service;

import java.util.List;

import com.app.pojos.CourseTable;
import com.app.pojos.FacultyNotice;
import com.app.pojos.Schedule;
import com.app.pojos.Student;
import com.app.pojos.StudentNotice;
import com.app.pojos.User;

public interface IUserService {
	// add a method for user validation
	User validateUser(String email, String pass);
	void saveFaculty(User facutly);
	
	List<User> listFaculty();
	List<Student> listStudent();
	
	User getFacultyDetails(int id);
	String updateFacultyDetails(User u);
	
	String deleteFacultyDetails(int id);
	void saveCourse(CourseTable u);
	void saveNotice(FacultyNotice u);
	void saveNoticestudent(StudentNotice u);
	List<FacultyNotice> listnotice();
	void saveSchedule(Schedule u);
	List<Schedule> listschedule();
	
	
	
	//User saveFaculty(User u);
}
