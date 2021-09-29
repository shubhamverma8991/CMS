package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.CourseTable;
import com.app.pojos.FacultyNotice;
import com.app.pojos.Schedule;
import com.app.pojos.Student;
import com.app.pojos.StudentNotice;
import com.app.pojos.User;

public interface userrepositories extends JpaRepository<User, Integer> {

	void save(Student u);

	void save(CourseTable u);

	void save(FacultyNotice u);

	void save(StudentNotice u);

	void save(Schedule u);

	

}