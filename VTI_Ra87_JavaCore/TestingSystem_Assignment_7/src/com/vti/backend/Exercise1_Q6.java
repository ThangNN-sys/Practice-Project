package com.vti.backend;

import com.vti.entity.PrimaryStudent;
import com.vti.entity.SecondaryStudent;
import com.vti.entity.Student;

public class Exercise1_Q6 {
	public void question6() {
		System.out.println("Tạo 2 primary student:");
		PrimaryStudent pSd1 = new PrimaryStudent();
		PrimaryStudent pSd2 = new PrimaryStudent();
		System.out.println("Tạo 6 secondary student:");
		SecondaryStudent sSd1 = new SecondaryStudent();
		SecondaryStudent sSd2 = new SecondaryStudent();
		SecondaryStudent sSd3 = new SecondaryStudent();
		SecondaryStudent sSd4 = new SecondaryStudent();
		SecondaryStudent sSd5 = new SecondaryStudent();
		SecondaryStudent sSd6 = new SecondaryStudent();
		System.out.println("Thông tin số lượng sinh viên:");
		String leftAlingFormat = "| %-18s | %-4d |%n";
		System.out.format("+------------+------+%n");
		System.out.format("| Category   |  SL  +%n");
		System.out.format("+------------+------+%n");
		System.out.format(leftAlingFormat, "Student ", Student.getCOUNT());
		System.out.format(leftAlingFormat, "Primary Student ", PrimaryStudent.COUNTPri);
		System.out.format(leftAlingFormat, "Secondary Student ", SecondaryStudent.COUNTSecond);
		System.out.format("+------------+------+%n");
	}
}
