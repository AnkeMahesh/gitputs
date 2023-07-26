package com.eight.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(2, 3, 5, 7, 4, 7, 8, 3, 1);

		List<String> words = Arrays.asList("mahesh", "uday", "naresh", "akhil", "narendra");

		// print oddnumber
		List<Integer> oddnumber = nums.stream().filter(a -> a % 2 == 1).collect(Collectors.toList());
		System.out.println(oddnumber);

		// even number
		List<Integer> evennumber = nums.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());
		System.out.println(evennumber);

		// print string as length

		List<String> word = words.stream().filter(a -> a.length() <= 4).collect(Collectors.toList());
		System.out.println(word);

		// for object
		Student s = new Student(25, 1, "mahesh");
		Student s1 = new Student(10, 2, "narayana");
		Student s2 = new Student(19, 3, "sathish");
		Student s3 = new Student(22, 4, "akhil");

		List<Student> students = Arrays.asList(s, s1, s2, s3);
		List<Student> filterstudents = students.stream().filter(a -> {
			int age = a.getAge();
			String name = a.getName();
			return age >= 20 && name.startsWith("ma");

		}).collect(Collectors.toList());

		System.out.println(filterstudents);

		List<Student> name = students.stream().filter(a -> a.getName().startsWith("ma")).collect(Collectors.toList());
		System.out.println(name);
		
	}

}
