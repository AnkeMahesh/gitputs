package com.eight.Stream;

import java.util.List;

public class School {
	
	private String schoolname;
	private List<Student> students;
	private List<String> locations;
	public String getSchoolname() {
		return schoolname;
	}
	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	@Override
	public String toString() {
		return "School [schoolname=" + schoolname + ", students=" + students + ", locations=" + locations + "]";
	}
	public School(String schoolname, List<Student> students, List<String> locations) {
		super();
		this.schoolname = schoolname;
		this.students = students;
		this.locations = locations;
	}
	public List<String> getLocations() {
		return locations;
	}
	public void setLocations(List<String> locations) {
		this.locations = locations;
	}
	public School() {
		super();
		// TODO Auto-generated constructor stub
	}

}
