package io_example.Object_test;

import java.io.Serializable;

public class Employee implements Serializable{

	private String name;
	private String salary;
	private int age;

	public Employee(String name,String salary,int age){
		this.name=name;
		this.salary=salary;
		this.age=age;
	}
	public Employee(){}

	@Override
	public String toString() {
		return "Employee{" +
				"name='" + name + '\'' +
				", salary='" + salary + '\'' +
				", age=" + age +
				'}';
	}
}
