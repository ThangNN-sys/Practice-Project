package com.vti.form;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

import com.vti.entity.CompareStudentE;

public class CompareStudent {
	public static void main(String[] args) {
		List<CompareStudentE> students = new ArrayList<>();
		students.add(new CompareStudentE(1, "Nguyễn Văn A", 9f));
		students.add(new CompareStudentE(2, "Nguyễn Văn B", 6f));
		students.add(new CompareStudentE(3, "Nguyễn Văn C", 7f));
		for (CompareStudent student : students) {
			System.out.println(student);
		}
		System.out.println("\n");
		Collections.sort(students);
	}
}
