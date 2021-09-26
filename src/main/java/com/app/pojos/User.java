package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
//Map this to existing tables "users"
@Table(name = "users")
public class User extends BaseEntity {

	@Column(length = 20) // not needed if mapping to existing table /col
	private String name;
	@Column(length = 20, unique = true)
	private String email;
	@Column(length = 20)
	private String password;
	@Column(length = 20)
	private String sme;
	@Column(length = 20)
	private String gender;
	@Column(length = 20)
	private String age;

	private int experience;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private UserRole role;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String name, String email, String password, String sme, String gender, String age, int experience,
			 UserRole role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.sme = sme;
		this.gender = gender;
		this.age = age;
		this.experience = experience;
		
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSme() {
		return sme;
	}

	public void setSme(String sme) {
		this.sme = sme;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + ", sme=" + sme + ", gender="
				+ gender + ", age=" + age + ", experience=" + experience + ", role=" + role
				+ "]";
	}

}
