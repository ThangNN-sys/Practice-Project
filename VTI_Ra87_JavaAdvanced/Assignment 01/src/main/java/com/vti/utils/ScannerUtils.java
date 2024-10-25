package com.vti.utils;

import java.util.Scanner;

public class ScannerUtils {

	// Phương thức kiểm tra giá trị được nhập có phải là kiểu short không

	public static short getShortInput() {
		Scanner scanner = new Scanner(System.in);
		short result;

		while (true) {
			if (scanner.hasNextShort()) {
				result = scanner.nextShort();
				break;
			} else {
				System.out.println("Vui lòng nhập một số kiểu short hợp lệ.");
				scanner.next(); // Xóa bỏ giá trị không hợp lệ khỏi bộ đệm
			}
		}

		return result;
	}

	// Phương thức kiểm tra giá trị được nhập có phải là kiểu số nguyên không

	public static int getIntegerInput() {
		Scanner scanner = new Scanner(System.in);
		int result;

		while (true) {
			if (scanner.hasNextInt()) {
				result = scanner.nextInt();
				break;  // Thoát khỏi vòng lặp nếu là số nguyên
			} else {
				System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
				scanner.next(); // Xóa bỏ giá trị không hợp lệ khỏi bộ đệm
			}
		}
		return result;
	}

	// Phương thức kiểm tra giá trị được nhập có phải là kiểu số nguyên dương không

	public static int getPosIntegerInput() {
		Scanner scanner = new Scanner(System.in);
		int result;

		while (true) {
			if (scanner.hasNextInt()) {
				result = scanner.nextInt();
				if (result > 0) {
					break;  // Thoát khỏi vòng lặp nếu là số nguyên dương
				} else {
					System.out.println("Vui lòng nhập một số nguyên dương.");
				}
			} else {
				System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
				scanner.next(); // Xóa bỏ giá trị không hợp lệ khỏi bộ đệm
			}
		}
		return result;
	}

	// Phương thức kiểm tra giá trị được nhập có phải là kiểu số thực (float) không

	public static float getFloatInput() {
		Scanner scanner = new Scanner(System.in);
		float result;

		while (true) {
			if (scanner.hasNextFloat()) {
				result = scanner.nextFloat();
				break;  // Thoát khỏi vòng lặp nếu giá trị là float hợp lệ
			} else {
				System.out.println("Vui lòng nhập một số thực (float) hợp lệ.");
				scanner.next(); // Xóa bỏ giá trị không hợp lệ khỏi bộ đệm
			}
		}
		return result;
	}

	// Phương thức kiểm tra giá trị được nhập có phải là kiểu số thực (double) không

	public static double getDoubleInput() {
		Scanner scanner = new Scanner(System.in);
		double result;

		while (true) {
			if (scanner.hasNextDouble()) {
				result = scanner.nextDouble();
				break;  // Thoát khỏi vòng lặp nếu giá trị là double hợp lệ
			} else {
				System.out.println("Vui lòng nhập một số thực (double) hợp lệ.");
				scanner.next(); // Xóa bỏ giá trị không hợp lệ khỏi bộ đệm
			}
		}
		return result;
	}

	// Phương thức kiểm tra giá trị được nhập có phải là kiểu chuỗi không

	public static String getStringInput() {
		Scanner scanner = new Scanner(System.in);
		String result;

		while (true) {
			result = scanner.nextLine().trim(); // Lấy chuỗi và loại bỏ khoảng trắng ở đầu và cuối
			if (!result.isEmpty()) {
				break;  // Thoát khỏi vòng lặp nếu chuỗi không rỗng
			} else {
				System.out.println("Vui lòng nhập một chuỗi ký tự không rỗng.");
			}
		}
		return result;
	}

	// Phương thức kiểm tra giá trị được nhập có phải là kiểu chuỗi theo định dạng *@* không

	public static String getEmailInput() {
		Scanner scanner = new Scanner(System.in);
		String email;

		while (true) {
			email = scanner.nextLine().trim(); // Đọc chuỗi và loại bỏ khoảng trắng ở đầu và cuối

			// Kiểm tra xem chuỗi có chứa ký tự '@' không
			if (email.contains("@")) {
				break;  // Thoát khỏi vòng lặp nếu chuỗi có chứa '@'
			} else {
				System.out.println("Vui lòng nhập địa chỉ email đúng định dạng (có ký tự '@').");
			}
		}
		return email;
	}

	// Phương thức kiểm tra giá trị được nhập có phải là kiểu chuỗi không chứa ký tự trống (khoảng trắng) không

	public static String getPasswordInput() {
		Scanner scanner = new Scanner(System.in);
		String password;

		while (true) {
			password = scanner.nextLine().trim(); // Đọc chuỗi và loại bỏ khoảng trắng ở đầu và cuối

			// Kiểm tra xem mật khẩu có ký tự trống không
			if (!password.isEmpty() && !password.contains(" ")) {
				break;  // Thoát khỏi vòng lặp nếu mật khẩu không rỗng và không chứa ký tự trống
			} else {
				System.out.println("Vui lòng nhập mật khẩu không có ký tự trống.");
			}
		}
		return password;
	}

	// Phương thức kiểm tra giá trị được nhập có phải là kiểu boolean (true/false) không

	public static boolean getBooleanInput() {
		Scanner scanner = new Scanner(System.in);
		boolean result;

		while (true) {
			System.out.print(" (nhập 'true' hoặc 'false'): ");
			String input = scanner.nextLine().trim().toLowerCase(); // Đọc chuỗi và chuẩn hóa về chữ thường

			if (input.equals("true")) {
				result = true;
				break;
			} else if (input.equals("false")) {
				result = false;
				break;
			} else {
				System.out.println("Vui lòng nhập 'true' hoặc 'false'.");
			}
		}

		return result;
	}
}
