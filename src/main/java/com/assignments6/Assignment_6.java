package com.assignments6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.assignments2.Employee;

public class Assignment_6 {

	static final Logger LOGGER = LoggerFactory.getLogger(Assignment_6.class);

	public static void main(String[] args) {
		List<Employee> employees = getEmployees();
		List<Employee> sortedEmployees = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
				.collect(Collectors.toList());
		LOGGER.info("sortedEmployees ::");
		sortedEmployees.stream().forEach(e -> System.out.println(e));
	}

	public static List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		Random random = new Random();
		for (int i = 1; i <= 1000; i++) {
			int salary = random.ints(10000, 80000).findAny().getAsInt();
			employees.add(new Employee(i, ("name" + i), salary));
		}
		// employees.stream().forEach(e -> System.out.println(e.getId() + " : " + e.getSalary()));
		return employees;
	}

}
