package com.vti.backend;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.vti.entity.Student;

public class Exercise2_Q1 {
	private ArrayList<Student> listStudents;
	private Random random;
	private Scanner sc;

	public Exercise2_Q1() {
		listStudents = new ArrayList<Student>();
		random = new Random();
		sc = new Scanner(System.in);
	}

	public void question1() {
		while (true) {
			System.out.println("=========");
			System.out.println("===Lựa chọn chức năng bạn muốn sử dụng===");
			System.out.println("===1. Tạo danh sách sinh viên.");
			System.out.println("===2. Hiển thị danh sách sinh viên trong lớp.");
			System.out.println("===3. Điểm danh lớp.");
			System.out.println("===4. Gọi nhóm 1 đi học bài.");
			System.out.println("===5. Gọi nhóm 2 đi dọn vệ sinh.");
			System.out.println("===6. Exit.");
			System.out.println("=========");
			int menuChoose = sc.nextInt();
			switch (menuChoose) {
			case 1:
				initStudent();
				System.out.println("Tạo thành công 10 sinh viên");
				break;
			case 2:
				for (Student student : listStudents) {
					System.out.println(student);
				}
				break;
			case 3: // b) Kêu gọi cả lớp điểm danh.
				System.out.println("Cả lớp điểm danh");
				for (Student student : listStudents) {
					student.diemDanh();
				}
				break;
			case 4: // c) Gọi nhóm 1 đi học bài
				System.out.println("Nhóm 1 đi học bài:");
				for (Student student : listStudents) {
					if (student.getGroup() == 2) {
						student.hocBai();
					}
				}
				break;
			case 5: // d) Gọi nhóm 2 đi dọn vệ sinh
				System.out.println("Nhóm 2 đi dọn vệ sinh:");
				for (Student student : listStudents) {
					if (student.getGroup() == 2) {
						student.donVeSinh();
					}
				}
				break;
			case 6:
				return;
			default:
				System.out.println("Lựa chọn đúng số ở trên.");
				break;
			}

		}
	}

//	a) Tạo 10 học sinh, chia thành 3 nhóm 
	private void initStudent() {
		for (int i = 0; i < 10; i++) {
			Student st = new Student("Student " + (i + 1), random.nextInt(3) + 1);
			listStudents.add(st);
		}
	}
}
