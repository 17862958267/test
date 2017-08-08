package com.oracle.entity;

import java.util.Date;

public class Student {

	private String uuid;
	private String name;
	private int age;
	private Date birthDay;
	
	
	public Student(String name, int age, Date birthDay) {
		super();
		this.name = name;
		this.age = age;
		this.birthDay = birthDay;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	@Override
	public String toString() {
		return "Student [uuid=" + uuid + ", name=" + name + ", age=" + age + ", birthDay=" + birthDay + "]";
	}
}
