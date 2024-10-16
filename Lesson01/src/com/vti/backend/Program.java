package com.vti.backend;

import java.util.Date;

import com.vti.entity.Department;
import com.vti.entity.Gender;
import com.vti.entity.Position;
import com.vti.entity.User;

public class Program {

	public static void main(String[] args) {
		// khởi tạo giá trị đối tượng department-1
		Department department1 = new Department();
		department1.id = 1;
		department1.departmentName = "Phòng HR";

		// khởi tạo giá trị đối tượng department-2
		Department department2 = new Department();
		department2.id = 2;
		department2.departmentName = "Phòng R&D";

		// khởi tạo giá trị đối tượng position-1
		Position position1 = new Position();
		position1.id = 1;
		position1.positionName = "Trưởng phòng";

		// khởi tạo giá trị đối tượng position-2
		Position position2 = new Position();
		position2.id = 2;
		position2.positionName = "Phó phòng";

		// khởi tạo giá trị đối tượng user-1
		User user1 = new User();
		user1.id = 1;
		user1.userName = "Người sử dụng 1";
		user1.passWord = "";
		user1.gender = Gender.MALE;
		// liên kết khoá ngoại với object dateofBirth
		user1.dateofBirth = new Date("2024/07/19");
		// liên kết khoá ngoại với object department
		user1.department = department1;

		// khởi tạo giá trị đối tượng user-2
		User user2 = new User();
		user2.id = 2;
		user2.userName = "Người sử dụng 2";
		user2.passWord = "";
		user2.gender = Gender.FEMALE;
		// liên kết khoá ngoại với object dateofBirth
		user2.dateofBirth = new Date("2024/07/18");
		// liên kết khoá ngoại với object department
		user2.department = department2;

		// in ra thông tin department-1
		// System.out.println("Thông tin của department1");
		// System.out.println("ID: " + department1.id);

		// in ra thông tin user-1
		System.out.println("Thông tin user1");
		System.out.println("ID: " + user1.id);
		System.out.println("UserName: " + user1.userName);
		System.out.println("Password: " + user1.passWord);
		System.out.println("Gender: " + user1.gender);
		System.out.println("dateofBirth: " + user1.dateofBirth);

		// in ra thông tin user-2
		System.out.println("Thông tin user2");
		System.out.println("ID: " + user2.id);
		System.out.println("UserName: " + user2.userName);
		System.out.println("Password: " + user2.passWord);
		System.out.println("Gender: " + user2.gender);
		System.out.println("dateofBirth: " + user2.dateofBirth);
	}
}
