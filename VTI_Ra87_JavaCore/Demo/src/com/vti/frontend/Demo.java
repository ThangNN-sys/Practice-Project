package com.vti.frontend;

import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean tiepTucKhong = true;

		while (tiepTucKhong) {
			System.out.println("Mời nhập số a: ");
			int a = sc.nextInt();
			if (a < 10) {
				System.out.println(a + " là số có 1 chữ số");
			} else {
				System.out.println(a + " là số có nhiều hơn 1 chữ số");
			}
			System.out.println("ban co muon tiep tuc khong? Y/N");
			String bString = sc.next();

			if (bString.equalsIgnoreCase("Y")) {
				tiepTucKhong = true;
			} else {
				tiepTucKhong = false;
			}
		}

		System.out.println("Chuong trinh ket thuc!");
	}
}
