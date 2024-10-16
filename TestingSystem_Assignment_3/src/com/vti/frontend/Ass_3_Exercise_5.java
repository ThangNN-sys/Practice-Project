package com.vti.frontend;

import com.vti.entity.Department;

public class Ass_3_Exercise_5 {
	public static void main(String[] args) {
// Tạo 5 phòng ban, sau đó cho các phòng ban vào mảng 5 phần tử
		Department[] departments = new Department[5];
		Department department1 = new Department();
		department1.depId = 1;
		department1.depName = "Sale";
		Department department2 = new Department();
		department2.depId = 2;
		department2.depName = "Marketing";
		Department department3 = new Department();
		department3.depId = 3;
		department3.depName = "Hành Chính";
		Department department4 = new Department();
		department4.depId = 4;
		department4.depName = "Bảo Vệ";
		Department department5 = new Department();
		department5.depId = 5;
		department5.depName = "Kỹ Thuật";
		departments[0] = department1;
		departments[1] = department2;
		departments[2] = department3;
		departments[3] = department4;
		departments[4] = department5;
// Q1: In ra thông tin của phòng ban thứ 1 (sử dụng toString())
		System.out.println(department1.toString());
// Q2: In ra thông tin của tất cả phòng ban (sử dụng toString()) 
		for (Department department : departments) {
			System.out.println(department.toString());
		}
// Q3: In ra địa chỉ của phòng ban thứ 1 
		System.out.println(department1.hashCode());
//Q4: Kiểm tra xem phòng ban thứ 1 có tên là "Phòng A" không?
		if (department1.depName.equals("Phòng A")) {
			System.out.println("Có tên là phòng A");
		} else {
			System.out.println("Không tên là phòng A");
		}
// Q5: So sánh 2 phòng ban thứ 1 và phòng ban thứ 2 xem có bằng nhau không (bằng nhau khi tên của 2 phòng ban đó bằng nhau) 
		if (department1.equals(department2)) {
			System.out.println("Hai phòng bằng nhau");
		} else {
			System.out.println("Hai phòng không bằng nhau");
		}
// Q6: Khởi tạo 1 array phòng ban gồm 5 phòng ban, sau đó in ra danh sách phòng ban theo thứ tự tăng dần theo tên (sắp xếp theo vần ABCD) 
		for (int i = 0; i < departments.length; i++) {
			for (int j = 0; j < departments.length - 1; j++) {
				if (departments[i].depName.compareToIgnoreCase(departments[j].depName) < 0) {
					Department temp = departments[i];
					departments[i] = departments[j];
					departments[j] = temp;
				}
			}
		}
		for (Department department : departments) {
			System.out.println(department);
		}
// Q7: bỏ qua
// Q8: Khởi tạo 1 array học sinh gồm 5 học sinh, sau đó in ra danh sách học sinh được sắp xếp theo tên

	}
}
