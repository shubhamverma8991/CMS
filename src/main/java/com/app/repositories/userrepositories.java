package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Student;
import com.app.pojos.User;

public interface userrepositories extends JpaRepository<User, Integer> {

	void save(Student u);

	

}