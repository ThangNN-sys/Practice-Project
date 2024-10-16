package com.vti.backend;

import com.vti.entity.Student;

public class Exercise1_Q1 {
	public void question1() {
		Student[] arrayStudents = new Student[3];
		System.out.println("Khởi tạo 3 SV:");
		for (int i = 0; i < 3; i++) {
			System.out.println("Sinh viên " + (i + 1) + ":");
			Student st = new Student();
			arrayStudents[i] = st;
		}
		System.out.println("Thông tin các SV vừa nhập:");
		for (int i = 0; i < arrayStudents.length; i++) {
			System.out.println(arrayStudents[i]);
		}
		System.out.println("Chuyển các SV sang ĐH Công nghệ:");
		Student.collect = "ĐH Công Nghệ";
		System.out.println("Thông tin SV sau khi chuyển:");
		for (int i = 0; i < arrayStudents.length; i++) {
			System.out.println(arrayStudents[i]);
		}
	}
}
