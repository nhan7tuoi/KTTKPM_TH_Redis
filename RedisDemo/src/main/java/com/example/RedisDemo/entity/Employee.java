package com.example.RedisDemo.entity;

import java.io.Serializable;

public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3290036866499409666L;
	private String id;
	private String fullName;
	private int age;
	
	public Employee(String id, String fullName, int age) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.age = age;
	}

	public Employee() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fullName=" + fullName + ", age=" + age + "]";
	}
	
	
}
