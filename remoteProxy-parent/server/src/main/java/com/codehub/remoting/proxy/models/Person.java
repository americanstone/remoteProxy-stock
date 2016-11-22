package com.codehub.remoting.proxy.models;

public class Person implements IPerson{
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
