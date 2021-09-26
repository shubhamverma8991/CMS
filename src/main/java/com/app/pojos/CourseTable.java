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
	
	public CourseTable() {
		// TODO Auto-generated constructor stub
	}

	public CourseTable(Course course) {
		super();
		this.course = course;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "CourseTable [course=" + course + "]";
	}
	
	
}
