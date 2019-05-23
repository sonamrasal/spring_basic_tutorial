package com.di;

import java.io.PrintStream;

public class Employee {
	private static final PrintStream CONSOLE = System.out;

	private String fName;

	public Employee() {
		System.out.println("In Employee constructor");
	}

	public String getFName() {
		return fName;
	}

	public void setFName(String name) {
		this.fName = name;
	}

	public void init() {
		CONSOLE.println("init() called on Employee immediately after instantiation");
	}

	public void destroy() {
		CONSOLE.println("destroy() called on Employee when bean is being removed from container");
	}
}
