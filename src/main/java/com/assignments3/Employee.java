package com.assignments3;

public class Employee {

	int id;
	String name;
	double salary;
	int deptNo;

	public Employee() {
	}

	public Employee(int id, String name, double salary, int deptNo) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.deptNo = deptNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", deptNo=" + deptNo + "]";
	}

}
