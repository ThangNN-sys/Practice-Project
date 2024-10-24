package com.vti.entity.exercise1;

import com.vti.ultis.ScannerUtils;

public class Position {

	private int id;
	private String name;

	public Position() {
		input();
	}

	public Position(int id, String name) {
		this.id = id;
		this.name = name;
	}

	private void input() {
		System.out.println("Nhập id : ");
		id = ScannerUtils.inputInt("Please input a id as int, please input again.");

		System.out.println("Nhập tên : ");
		name = ScannerUtils.inputString("Please input a name, please input again.");
	}

	@Override
	public String toString() {
		return "Position{" + "id=" + id + ", name='" + name + '\'' + '}';
	}
}
