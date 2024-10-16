package com.vti.frontend;

import java.time.LocalDate;

import com.vti.ultis.ScannerUltis;

public class Demo2 {
	public static void main(String[] args) {
		System.out.println("Nhập ngày tháng:");
		LocalDate myBirthday = ScannerUltis.inputLocalDate();
		System.out.println("Ngày sinh bạn vừa nhập là: " + myBirthday);
	}
}
