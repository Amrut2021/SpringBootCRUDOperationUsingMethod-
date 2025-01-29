package com.Tka.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	private int id;
	private String name;
	private String course;
	private String age;
	private double moblieNo;
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public double getMoblieNo() {
		return moblieNo;
	}
	public void setMoblieNo(double moblieNo) {
		this.moblieNo = moblieNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", course=" + course + ", age=" + age + ", moblieNo=" + moblieNo
				+ ", email=" + email + "]";
	}
	public Student(int id, String name, String course, String age, double moblieNo, String email) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.age = age;
		this.moblieNo = moblieNo;
		this.email = email;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
