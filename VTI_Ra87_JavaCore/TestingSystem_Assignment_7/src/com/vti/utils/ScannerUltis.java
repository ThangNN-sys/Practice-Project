package com.vti.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class ScannerUltis {
	private static Scanner sc = new Scanner(System.in);

	public static int inputInt() {
		while (true) {
			try {
				return Integer.parseInt(sc.next().trim());
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("Nhập lại.");
			}
		}
	}

	public static int inputIntPositive() {
		while (true) {
			try {
				int intPositive = Integer.parseInt(sc.next());
				if (intPositive >= 0) {
					return intPositive;
				} else {
					System.out.println("Nhập lại");
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Nhập lại");
			}
		}
	}

	public static Float inputFloat() {
		while (true) {
			try {
				return Float.parseFloat(sc.next());
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Nhập lại");
			}
		}
	}

	public static Double inputDouble() {
		while (true) {
			try {
				return Double.parseDouble(sc.next());
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Nhập lại");
			}
		}
	}

	public static String inputString() {
		while (true) {
			String string = sc.nextLine().trim();
			if (!string.isEmpty()) {
				return string;
			} else {
				System.out.println("Nhập lại");
			}
		}
	}

	public static LocalDate inpuLocalDate() {
		System.out.println("Nhập theo định dạng: yyyy-MM-dd");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		while (true) {
			String localDate = sc.next().trim();
			try {
				if (format.parse(localDate) != null) {
					LocalDate lc = LocalDate.parse(localDate);
					return lc;
				}
			} catch (Exception e) {
				System.out.println("Nhập lại");
			}
		}
	}
}
