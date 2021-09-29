package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="schedule")
public class Schedule extends BaseEntity {
	@Column(length = 20)
	private Course course;
	@Column(length = 20)
	private String subject;
	@Column(length = 100)
	private String faculty;
	@Column(length = 30)
	private String venue;
	@Column(length = 50)
	private String timing;
	
	@Column(name="date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	
	public Schedule() {
		// TODO Auto-generated constructor stub
	}

	public Schedule(Course course, String subject, String faculty, String venue, String timing, LocalDate date) {
		super();
		this.course = course;
		this.subject = subject;
		this.faculty = faculty;
		this.venue = venue;
		this.timing = timing;
		this.date = date;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Schedule [course=" + course + ", subject=" + subject + ", faculty=" + faculty + ", venue=" + venue
				+ ", timing=" + timing + ", date=" + date + "]";
	}
	
	
}
