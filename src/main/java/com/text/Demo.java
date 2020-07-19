package com.text;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Demo {

	static int i;
	int j;

	public static void main(String[] args) {

		List<Person> people = new ArrayList<>();
		people.add(new Person("John", "London", "1000"));
		people.add(new Person("Swann", "London", "5000"));
		people.add(new Person("Kevin", "London", "1000"));
		people.add(new Person("Monobo", "Tokyo", "5000"));
		people.add(new Person("Sam", "Paris", "1000"));
		people.add(new Person("Nadal", "Paris", "5000"));

//		people.stream().collect(Collectors.groupingBy(Person::getSalary)).entrySet().stream().forEach(lists->{
//		lists.getValue().forEach(list->{
//			System.out.println("name :"+ list.getName()+" salary: "+list.getSalary());
//		});	
//		});
//
//		collect.values().forEach(lists -> {
//			lists.forEach(list -> {
//				System.out.println("salary: " + list.getSalary() + " name: " + list.getName());
//			});
//		});

		// to covert list into map

//		people.stream().collect(Collectors.toMap(Person::getCity, Person::getName, (oldVlaue, newValue) -> oldVlaue))
//				.forEach((key, value) -> {
//					System.out.println("city name :" + key + " namae: " + value);
//				});

		// System.out.println(collect);
		people.stream()
				.collect(Collectors.groupingBy(Person::getCity,
						Collectors.summingInt(sal -> Integer.parseInt(sal.getSalary()))))
				.entrySet().stream().forEach(list -> {

					System.out.println("key: " + list.getKey() + " value: " + list.getValue());
				});

	}

}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Person {
	private String name;
	private String city;
	private String salary;

}

@Data
class Address {
	private String city;
	private String state;

}