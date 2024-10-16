package com.vti.entity;

import java.io.Serializable;

public class WriteObjectVehice implements Serializable {
	private final String name;
	private String color;
	private final String brand;

	public WriteObjectVehice(String name, String color, String brand) {
		this.name = name;
		this.color = color;
		this.brand = brand;
	}

	public final void di() {

	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public String getBrand() {
		return brand;
	}
}
