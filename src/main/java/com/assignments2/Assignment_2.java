package com.assignments2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assignment_2 {

	static final Logger LOGGER = LoggerFactory.getLogger(Assignment_2.class);

	public static void main(String[] args) {
		List<Employee> employees = getEmployees();
		LOGGER.info("Employee size : {}", employees.size());
		Map<Integer, Employee> employeesMap = employees.stream().peek(System.out::println).map((e) -> {
			e.setSalary(e.getSalary() + ((e.salary / 100) * 20));
			return e;
		}).sorted(Comparator.<Employee>comparingDouble(Employee::getSalary).reversed())
				.collect(Collectors.toMap(Employee::getId, e -> e));
		employeesMap.entrySet().forEach(e -> System.out.println(e.getKey() + " : " + e.getValue().getSalary()));
	}

	public static List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		Random random = new Random();
		for (int i = 1; i <= 1000; i++) {
			int salary = random.ints(10000, 80000).findAny().getAsInt();
			employees.add(new Employee(i, ("name" + i), salary));
		}
		//employees.stream().forEach(e -> System.out.println(e.getId() + " : " + e.getSalary()));
		return employees;
	}

}
