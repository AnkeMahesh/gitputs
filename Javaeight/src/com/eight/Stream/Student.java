package com.eight.Stream;

public class Student {
	
	private int age;
	private int id;
	private String name;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
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
	
	@Override
	public String toString() {
		return "Student [age=" + age + ", id=" + id + ", name=" + name + "]";
	}
	public Student(int age, int id, String name) {
		super();
		this.age = age;
		this.id = id;
		this.name = name;
		
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
