package com.assignments3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assignment_3 {
	
	static final Logger LOGGER = LoggerFactory.getLogger(Assignment_3.class);

	public static void main(String[] args) {
		List<Employee> employeesWithDeptNo = getEmployeesWithDept();
		// employeesWithDeptNo.stream().collect(Collectors.groupingBy(e -> e.getDeptNo()));
		Map<Integer, Double> collect = employeesWithDeptNo.stream().parallel().collect(Collectors.groupingBy(e -> e.getDeptNo(),
                Collectors.summingDouble(e->e.getSalary())));
		LOGGER.info("Salary summation for each deptNo :{} ", collect);
		 Map<Integer, Optional<Employee>> collect2 = employeesWithDeptNo.stream().parallel().collect(Collectors.groupingBy(e -> e.getDeptNo(),
                Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
		 Map<Integer, Double> collect3 = collect2.entrySet().stream().collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue().get().getSalary()));
		 LOGGER.info("Max Salary for each deptNo: {}", collect3);
	}
	
	public static List<Employee> getEmployeesWithDept() {
		List<Employee> employees = new ArrayList<Employee>();
		Random random = new Random();
		for (int i = 1; i <= 1000; i++) {
			int salary = random.ints(1000, 2001).findAny().getAsInt();
			int deptNo = random.ints(1, 5).findAny().getAsInt();
			employees.add(new Employee(i, ("name" + i), salary, deptNo));
		}
		employees.stream().forEach(e -> System.out.println(e.getId() + " : " + e.getSalary() +" : " + e.getDeptNo()));
		return employees;
	}

}
