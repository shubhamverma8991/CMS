package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="studentnotice")
public class StudentNotice extends BaseEntity{

	@Column(name="date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	@Column(length = 20)
	private String topic;
	@Column(length = 400)
	private String description;
	
	public StudentNotice() {
		// TODO Auto-generated constructor stub
	}

	public StudentNotice(LocalDate date, String topic, String description) {
		super();
		this.date = date;
		this.topic = topic;
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "StudentNotice [date=" + date + ", topic=" + topic + ", description=" + description + "]";
	}
	
	
	
	
}
