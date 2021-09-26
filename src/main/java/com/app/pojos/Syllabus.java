package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
@Entity
@Table(name="syllabus")
public class Syllabus extends BaseEntity{

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Course course;
	@Column(length = 30)
	private String subject;

}
