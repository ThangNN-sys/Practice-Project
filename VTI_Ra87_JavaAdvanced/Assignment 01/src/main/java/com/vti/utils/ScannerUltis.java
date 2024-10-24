package com.vti.utils;

import java.util.Scanner;

public class ScannerUltis {

	private static Scanner scanner = new Scanner(System.in);

	public static int inputId() {
		while (true) {
			System.out.println();
			int id = inputInt();
			if (id > 0) {
				return id;
			}
			// else
			System.out.println("Please input a id as int which must be greater than > 0, please input again.");
		}
	}

	public static String inputEmail() {
		System.out.println();
		return inputString();
	}

	public static String inputPassword(String msg) {
		System.out.println(msg);
		return inputString();
	}

	public static int inputIntChoice(String msg) {
		System.out.println(msg);
		return inputInt();
	}

	public static int inputInt() {
		while (true) {
			try {
				return Integer.parseInt(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.println();
			}
		}
	}

	public static float inputFloat(String errorMessage) {
		while (true) {
			try {
				return Float.parseFloat(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}

	public static double inputDouble(String errorMessage) {
		while (true) {
			try {
				return Double.parseDouble(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}

	public static String inputString() {
		while (true) {
			String input = scanner.nextLine().trim();
			if (!input.isEmpty()) {
				return input;
			} else {
				System.err.println();
			}
		}
	}

	public static int inputAge() {
		while (true) {
			int age = inputInt();

			if (age <= 0) {
				System.err.println("Wrong inputing! The age must be greater than 0, please input again.");

			} else {
				return age;
			}
		}
	}

	public static int inputAgeGreaterThan18() {
		while (true) {
			int age = inputAge();

			if (age >= 18) {
				return age;

			} else {
				System.out.println("Wrong inputing! The age must be greater than 18, please input again.");
			}
		}
	}

}
