package com.spring.orm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_det")
public class Student {

	@Id
	@Column(name = "Id")
	private int studentId;
	@Column(name = "name")
	private String sname;
	@Column(name = "city")
	private String sCity;
	
	
	
	public Student(int studentId, String sname, String sCity) {
		super();
		this.studentId = studentId;
		this.sname = sname;
		this.sCity = sCity;
	}



	public Student() {
		super();
	}



	public int getStudentId() {
		return studentId;
	}



	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}



	public String getSname() {
		return sname;
	}



	public void setSname(String sname) {
		this.sname = sname;
	}



	public String getsCity() {
		return sCity;
	}



	public void setsCity(String sCity) {
		this.sCity = sCity;
	}
	
	
	
	
	
}
