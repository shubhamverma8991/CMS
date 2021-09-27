package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class CourseTable extends BaseEntity {
	
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Course course;
	@Column(length = 20)
	private String subjectname;
	
	public CourseTable() {
		// TODO Auto-generated constructor stub
	}

	public CourseTable(Course course, String subjectname) {
		super();
		this.course = course;
		this.subjectname = subjectname;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	@Override
	public String toString() {
		return "CourseTable [course=" + course + ", subjectname=" + subjectname + "]";
	}

	
	
}
