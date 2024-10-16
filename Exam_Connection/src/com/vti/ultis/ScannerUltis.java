package com.vti.ultis;

import java.util.Scanner;

public class ScannerUltis {
	// Question78
	private static void printErrString(String errString) {
		System.err.println(errString);
	}

	public static int inputInt(Scanner scanner, String errString) {
		while (true) {
			try {
				return Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
				printErrString(errString);
			}
		}
	}

	public static float inputFloat(Scanner scanner, String errString) {
		while (true) {
			try {
				return Float.parseFloat(scanner.nextLine());
			} catch (Exception e) {
				printErrString(errString);
			}
		}
	}

	public static double inputDouble(Scanner scanner, String errString) {
		while (true) {
			try {
				return Double.parseDouble(scanner.nextLine());
			} catch (Exception e) {
				printErrString(errString);
			}
		}
	}

	public static String inputString(Scanner scanner, String errString) {
		while (true) {
			String input = scanner.nextLine().trim();
			if (!input.isEmpty()) {
				return input;
			} else {
				printErrString(errString);
			}
		}
	}

	public static int inputIntWithString(Scanner scanner) {
		return inputInt(scanner, "Please input a number as int");
	}

	public static String inputStringWithString(Scanner scanner) {
		return inputString(scanner, "Please input a string");
	}

	private static Scanner scanner = new Scanner(System.in);

	public static int inputInt1(String errorMessage) {
		while (true) {
			try {
				return Integer.parseInt(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}

	public static int inputAge() {
		while (true) {
			int age = inputInt1("Wrong inputing! Please input an age as int, input again.");

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
