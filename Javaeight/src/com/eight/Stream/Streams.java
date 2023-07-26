package com.eight.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
	static String revrs(String str) {
		String rev = "";

		for (int i = str.length() - 1; i >= 0; i--) {
			rev = rev + str.charAt(i);

		}
		return rev;
	}

	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();
		list.add(2);
		list.add(4);
		list.add(6);
		list.add(3);
		list.add(1);

		List<Integer> list1 = new LinkedList<>();
		list.add(2);
		list.add(44);
		list.add(66);
		list.add(34);
		list.add(13);

		// List of list
		List<List<Integer>> nums = new ArrayList<>();
		nums.add(list1);
		nums.add(list);
		List<Integer> output = new LinkedList<>();
		System.out.println(nums);
		for (List<Integer> out : nums) {
			for (int i : out) {
				output.add(i);
			}
		}
		System.out.println(output);
		List<Integer> it = nums.stream().flatMap((a) -> a.stream()).collect(Collectors.toList());
		System.out.println(it);

		List<String> words = new LinkedList<>();
		words.add("mahesh");
		words.add("Anke");
		words.add("ramesh");
		words.add("suri");
		words.add("ravi");

		List<Character> ch = new ArrayList<>();
		for (String word : words) {
			for (int i = 0; i < word.length(); i++) {
				char cha = word.charAt(i);
				ch.add(cha);

			}
		}
		System.out.println(ch);

		List<Character> outputt = words.stream().flatMap((a) -> {
			List<Character> out = new ArrayList<>();
			for (int i = 0; i < a.length(); i++) {
				char chaa = a.charAt(i);
				out.add(chaa);

			}
			return out.stream();
		}).collect(Collectors.toList());

		System.out.println(outputt);

		List<Character> wordchar = words.stream().flatMap(a -> a.chars().mapToObj(b -> (char) b))
				.collect(Collectors.toList());
		System.out.println(wordchar);
		/*
		 * // odd numbers Predicate<Integer> p = (a) -> a % 2 == 1; List<Integer> odd =
		 * list.stream().filter(p).collect(Collectors.toList());
		 * System.out.println("oddnumbers==" + odd);
		 * 
		 * // even numbers Predicate<Integer> even = (a) -> a % 2 == 0; List<Integer>
		 * evennumber = list.stream().filter(even).collect(Collectors.toList());
		 * System.out.println("evennumbers==" + evennumber);
		 * 
		 * List<String> word = words.stream().filter((a) -> a.length() >
		 * 4).collect(Collectors.toList()); System.out.println(word);
		 */
		// Student object

		Student s = new Student(25, 1, "mahesh");
		Student s1 = new Student(10, 2, "narayana");
		Student s2 = new Student(19, 3, "sathish");
		Student s3 = new Student(22, 4, "akhil");

		List<Student> students = Arrays.asList(s, s1, s2, s3);

		/*
		 * List<Student> getstudent = students.stream().filter((a) -> { int age =
		 * a.getAge(); String name = a.getName(); return age > 20 &&
		 * name.startsWith("ma"); }).collect(Collectors.toList());
		 * System.out.println(getstudent);
		 */

		// print length of String
		List<Integer> len = words.stream().map((a) -> a.length()).collect(Collectors.toList());
		System.out.println(len);

		// print index wise char
		List<Character> charector = words.stream().map((a) -> a.charAt(0)).collect(Collectors.toList());
		System.out.println(charector);
		// show even odd

		List<String> eo = list.stream().map((a) -> {
			if (a % 2 == 0) {
				return "even";
			} else {
				return "odd";
			}

		}).collect(Collectors.toList());
		System.out.println(eo);

		// Reverse String

		List<String> reverse = words.stream().map((a) -> new StringBuffer(a).reverse().toString())
				.collect(Collectors.toList());
		System.out.println(reverse);

		List<String> rever = words.stream().map(a -> revrs(a)).collect(Collectors.toList());
		System.out.println(rever);

		// get names from student object
		List<String> names = students.stream().map((a) -> a.getName()).collect(Collectors.toList());
		System.out.println(names);

		List<String> name = students.stream().filter((a) -> a.getAge() > 20).map((a) -> a.getName())
				.collect(Collectors.toList());
		System.out.println(name);

		List<Integer> numbers = list.stream().filter((a) -> a > 2).map((a) -> a * 2).collect(Collectors.toList());
		System.out.println(numbers);

		List<Integer> sortnumber = list.stream().filter((a) -> a > 2).map((a) -> a * 2).sorted()
				.collect(Collectors.toList());
		System.out.println(sortnumber);

		List<Integer> sortnumberrevers = list.stream().filter((a) -> a > 2).map((a) -> a * 2)
				.sorted((a, b) -> -1 * a.compareTo(b)).collect(Collectors.toList());
		System.out.println(sortnumberrevers);

		List<String> printword = words.stream().map((a) -> a.toUpperCase()).sorted().collect(Collectors.toList());
		System.out.println(printword);

		List<String> descendsestring = words.stream().map((a) -> a.toUpperCase()).sorted((a, b) -> -a.compareTo(b))
				.collect(Collectors.toList());
		System.out.println(descendsestring);

		List<Integer> stringnumber = words.stream().map((a) -> a.length()).sorted().collect(Collectors.toList());
		System.out.println(stringnumber);

		List<Integer> stringdesnumber = words.stream().map((a) -> a.length()).sorted((a, b) -> -a.compareTo(b))
				.collect(Collectors.toList());
		System.out.println(stringdesnumber);

		List<String> stu = students.stream().filter((a) -> a.getAge() > 11 && a.getAge() < 25).map((a) -> a.getName())
				.sorted().collect(Collectors.toList());
		System.out.println(stu);

		List<String> stu1 = students.stream().filter((a) -> a.getAge() > 11)
				.sorted((a, b) -> -a.getName().compareTo(b.getName())).map((a) -> {
					String out = "";
					int age = a.getAge();
					int id = a.getId();
					String name1 = a.getName();
					out = age + " " + id + " " + name1;
					return out;
				}).collect(Collectors.toList());
		System.out.println(stu1);

		List<String> stu2 = students.stream().filter((a) -> a.getAge() > 11)
				.sorted((a, b) -> -a.getName().compareTo(b.getName())).map((a) -> a.toString())
				.collect(Collectors.toList());
		System.out.println(stu2);
		//

		List<School> allschools = new ArrayList<>();

		School zphs = new School();
		zphs.setSchoolname("mahesh school");
		List<String> locations = Arrays.asList("atmakur", "thambapur", "thadimarri");
		zphs.setLocations(locations);

		Student st = new Student(6, 29, "anke");
		Student st1 = new Student(7, 30, "yesh");
		Student st2 = new Student(8, 40, "mahi");
		Student st3 = new Student(9, 50, "daniel");
		List<Student> zphsstudents = Arrays.asList(st, st1, st2, st3);
		zphs.setStudents(zphsstudents);

		School privateschool = new School();
		privateschool.setSchoolname("prasanth school");
		List<String> locations1 = Arrays.asList("bathalapalli", "ananthpur", "penugonda");
		privateschool.setLocations(locations1);

		Student st4 = new Student(10, 29, "sekar");
		Student st5 = new Student(11, 32, "som");
		Student st6 = new Student(12, 22, "ram");
		Student st7 = new Student(13, 26, "vani");
		List<Student> privateschoolstudents = Arrays.asList(st4, st5, st6, st7);
		privateschool.setStudents(privateschoolstudents);

		allschools.add(zphs);
		allschools.add(privateschool);

		List<Student> studentsss = allschools.stream().flatMap((a) -> a.getStudents().stream())
				.collect(Collectors.toList());
		System.out.println(studentsss);
		List<String> stringname = allschools.stream().flatMap((a) -> a.getStudents().stream()).map(a -> a.getName())
				.sorted().collect(Collectors.toList());

		System.out.println(stringname);

		List<String> stringnamebysal = allschools.stream().flatMap((a) -> a.getStudents().stream())
				.filter((a) -> a.getAge() > 8).map((a) -> a.getName()).sorted().collect(Collectors.toList());
		System.out.println(stringnamebysal);

		String str = "mahesh";
		List<Character> charrr = str.chars().mapToObj(a -> (char) a).collect(Collectors.toList());

		System.out.println(charrr);
		Map<Character, Long> countchar = str.chars().mapToObj(a -> (char) a)
				.collect(Collectors.groupingBy(a -> a, Collectors.counting()));

		System.out.println(countchar);

		List<Integer> numbes = Arrays.asList(123, 345, 678);

		List<Integer> numsa = numbes.stream()
				.flatMap(a -> a.toString().chars().mapToObj(b -> Integer.parseInt((char) b + "")))
				.collect(Collectors.toList());

		System.out.println(numsa);

		Map<String, Long> si = students.stream()
				.collect(Collectors.groupingBy(a -> a.getName(), Collectors.summingLong(b -> b.getAge())));
		System.out.println(si);

	}

}
