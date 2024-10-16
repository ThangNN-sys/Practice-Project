package com.vti.entity;

public class CompareStudentE implements Comparable<CompareStudentE> {
	private int id;
	private String name;
	private Float gpa;

	public CompareStudentE(int id, String name, Float gpa) {
		this.id = id;
		this.name = name;
		this.gpa = gpa;
	}

	@Override
	public int compareTo(CompareStudentE student) {
		if (student.gpa > gpa) {
			return 1;
		} else if (student.gpa < gpa) {
			return -1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "id: " + id + " name: " + name + " GPA: " + gpa;
	}
}
