package com.assignments1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonUtils {

	static final Logger LOGGER = LoggerFactory.getLogger(PersonUtils.class);

	public static List<Person> getPersonList() {
		List<Person> persons = new ArrayList<>();
		Random random = new Random();
		for (int i = 1; i <= 1000; i++) {
			int age = random.ints(1, 99).findAny().getAsInt();
			persons.add(new Person(i, ("Person" + i), age, (i % 2 == 0) ? "Male" : "Female"));
		}
		LOGGER.info("List of Persons size : {}", persons.size());
		//persons.stream().forEach(System.out::println);
		return persons;
	}

	public static void main(String[] args) {
		getPersonList();
	}
}
