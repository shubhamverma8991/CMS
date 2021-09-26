package com.app.dao;

import com.app.pojos.User;

public interface IUserDao {
//add a method for user validation
	User validateUser(String email,String pass);
	
	public User registerUser(User u);

	//String registerUser(String name, int age, String email, String password, String address, String sme, int experience,
	//		String gender, String role);
}
