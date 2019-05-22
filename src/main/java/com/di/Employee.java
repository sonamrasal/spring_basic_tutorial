package com.di;

import java.io.PrintStream;

public class Employee {
	private static final PrintStream CONSOLE = System.out;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void init() {
		CONSOLE.println("init() called on Employee immediately after instantiation");
	}

	public void destroy() {
		CONSOLE.println("destroy() called on Employee when bean is being removed from container");
	}
}
