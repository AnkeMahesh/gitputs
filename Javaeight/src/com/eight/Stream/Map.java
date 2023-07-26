package com.eight.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Map {
public static void main(String[] args) {
	
	
	List<String> words=Arrays.asList("mahesh","anke","narayana", "prasanth","akhil");
	
	List<Integer> names=  words.stream().map(a->a.length()).collect(Collectors.toList());
	System.out.println(names);
}
}
