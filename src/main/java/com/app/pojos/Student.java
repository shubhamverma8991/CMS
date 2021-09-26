package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name="student")

public class Student extends BaseEntity{
	
	@Column(length = 20) 
	private String name;
	@Column(length = 20) 
	private String gender;
	
	private int age;
	@Column(length = 200) 
	private String address;
	@Column(length = 20) 
	private String email;
	@Column(length = 20) 
	private String password;
	private int classx;
	private int classxii;
	private int graduation;
	private int phoneno;
	@Column(length = 30) 
	private String fathername;
	@Column(length = 30) 
	private String mothername;
	private int adharnumber;
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Course coursename;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String gender, int age, String address, String email, String password, int classx,
			int classxii, int graduation, int phoneno, String fathername, String mothername, int adharnumber,
			Course coursename) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.email = email;
		this.password = password;
		this.classx = classx;
		this.classxii = classxii;
		this.graduation = graduation;
		this.phoneno = phoneno;
		this.fathername = fathername;
		this.mothername = mothername;
		this.adharnumber = adharnumber;
		this.coursename = coursename;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getClassx() {
		return classx;
	}

	public void setClassx(int classx) {
		this.classx = classx;
	}

	public int getClassxii() {
		return classxii;
	}

	public void setClassxii(int classxii) {
		this.classxii = classxii;
	}

	public int getGraduation() {
		return graduation;
	}

	public void setGraduation(int graduation) {
		this.graduation = graduation;
	}

	public int getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public String getMothername() {
		return mothername;
	}

	public void setMothername(String mothername) {
		this.mothername = mothername;
	}

	public int getAdharnumber() {
		return adharnumber;
	}

	public void setAdharnumber(int adharnumber) {
		this.adharnumber = adharnumber;
	}

	public Course getCoursename() {
		return coursename;
	}

	public void setCoursename(Course coursename) {
		this.coursename = coursename;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", gender=" + gender + ", age=" + age + ", address=" + address + ", email="
				+ email + ", password=" + password + ", classx=" + classx + ", classxii=" + classxii + ", graduation="
				+ graduation + ", phoneno=" + phoneno + ", fathername=" + fathername + ", mothername=" + mothername
				+ ", adharnumber=" + adharnumber + ", coursename=" + coursename + "]";
	}
	
}
