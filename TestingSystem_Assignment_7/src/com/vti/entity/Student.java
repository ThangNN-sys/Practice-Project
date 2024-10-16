package com.vti.entity;

import com.vti.utils.ScannerUltis;

public class Student {
	private int id;
	private String name;
	public static String collect = "ĐH Bách Khoa";
	private static int COUNT = 0;

	public Student() {
		super();
		this.id = setCOUNT(getCOUNT() + 1);
		System.out.println("Nhập vào tên SV:");
		this.name = ScannerUltis.inputString();
	}

	@Override
	public String toString() {
		return "Studen [id= " + id + ", name= " + name + ", Collect= " + collect + "]";
	}

	public static int getCOUNT() {
		return COUNT;
	}

	public static int setCOUNT(int COUNT) {
		COUNT = COUNT;
		return COUNT;
	}

}
