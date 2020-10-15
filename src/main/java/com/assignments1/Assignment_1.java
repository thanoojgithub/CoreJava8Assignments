package com.assignments1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assignment_1 {

	static final Logger LOGGER = LoggerFactory.getLogger(Assignment_1.class);

	public static void main(String[] args) {
		List<Person> personList = getPersonList();
		approach1(personList, args);
		CheckPerson tester = new CheckPerson(2, 22);
		approach2(personList, tester);
		approach3(personList);
		approach4(personList);
		// using predicate
		Predicate<Person> personPredicate = (p) -> (p.getAge() >= 2 && p.getAge() <= 22);
		approach5(personList, personPredicate);

	}

	private static void approach1(List<Person> personList, String[] args) {
		List<Person> processedPersonsList = processPersons(personList, Integer.parseInt(args[0]),
				Integer.parseInt(args[1]));
		LOGGER.info("approach1 - Processed Persons List : {}", processedPersonsList);
	}

	private static void approach2(List<Person> personList, CheckPerson tester) {
		List<Person> processedPersonsList = processPersons(personList, tester);
		LOGGER.info("approach2 - Processed Persons List : {}", processedPersonsList);
	}

	private static void approach3(List<Person> personList) {
		// Anonymous CheckPerson tester
		List<Person> processedPersonsList = processPersons(personList);
		LOGGER.info("approach3 - Processed Persons List : {}", processedPersonsList);
	}

	private static void approach4(List<Person> personList) {
		// Anonymous CheckPerson tester
		List<Person> processedPersonsList = processPersons(personList);
		LOGGER.info("approach4 - Processed Persons List : {}", processedPersonsList);
	}

	private static void approach5(List<Person> personList, Predicate<Person> personPredicate) {
		// Anonymous CheckPerson tester
		List<Person> processedPersonsList = processPersons(personList);
		LOGGER.info("approach5 - Processed Persons List : {}", processedPersonsList);
	}

	public static List<Person> processPersons(List<Person> persons, int low, int high) {
		return persons.stream().filter(p -> (p.getAge() >= low && p.getAge() <= high)).collect(Collectors.toList());
	}

	public static List<Person> processPersons(List<Person> persons, CheckPerson tester) {
		return persons.stream().filter(p -> (p.getAge() >= tester.getMinAge() && p.getAge() <= tester.getMaxAge()))
				.collect(Collectors.toList());
	}

	interface ICheckPerson {
		int getMinAge();

		int getMaxAge();
	}

	public static List<Person> processPersons(List<Person> persons) {
		// Anonymous
		ICheckPerson tester = new ICheckPerson() {

			@Override
			public int getMinAge() {
				return 2;
			}

			@Override
			public int getMaxAge() {
				return 22;
			}
		};
		return persons.stream().filter(p -> (p.getAge() >= tester.getMinAge() && p.getAge() <= tester.getMaxAge()))
				.collect(Collectors.toList());
	}

	public static List<Person> printPersonsWithPredicate(List<Person> persons, Predicate<Person> tester) {
		return persons.stream().filter(p -> tester.test(p)).collect(Collectors.toList());
	}

	public static List<Person> getPersonList() {
		List<Person> persons = new ArrayList<>();
		Random random = new Random();
		for (int i = 1; i <= 1000; i++) {
			int age = random.ints(1, 99).findAny().getAsInt();
			persons.add(new Person(i, ("Person" + i), age, (i % 2 == 0) ? "Male" : "Female"));
		}
		LOGGER.info("List of Persons size : {}", persons.size());
		// persons.stream().forEach(System.out::println);
		return persons;
	}

}
