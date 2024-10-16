package com.vti.entity;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

// BẢN CHUẨN - NGUYỄN NGỌC THẮNG

public class ScannerUltis {
	static Scanner scanner = new Scanner(System.in);

//  HỖ TRỢ NHẬP VÀO MỘT SỐ NGUYÊN ---------------------------------------------------------------------------------------
//  Hàm inputInt viết đầy đủ
//	public static int inputInt() {
//		while (true) {
//			try {
//				String inputInt = scanner.next().trim(); // yêu cầu dữ liệu nhập vào là 1 chuỗi, trim() để loại bỏ ký tự trắng
//				int resultInt = Integer.parseInt(inputInt); // chuyển dữ liệu đã nhập ở trên sang dạng Integer, gán kết quả
//															// vào biến resultInt
//				return resultInt;
//			} catch (Exception e) { // dữ liệu không phải số nguyên thì lệnh catch chuyển sang câu lệnh dưới
//				System.err.println("Mời nhập lại một số nguyên:"); //err: ra chữ màu đỏ
//			}
//		}
//	}
//  Hàm inputInt viết ngắn gọn
	public static int inputInt() {
		while (true) {
			try {
				return Integer.parseInt(scanner.next().trim());
			} catch (Exception e) {
				System.err.println("Mời nhập lại một số nguyên:");
			}
		}
	}

// HỖ TRỢ NHẬP VÀO MỘT SỐ NGUYÊN DƯƠNG ----------------------------------------------------------------------------------
	public static int inputIntPositive() {
		while (true) {
//			try {
			int intPositive = Integer.parseInt(scanner.next().trim());
			if (intPositive >= 0) {
				return intPositive;
			} else {
				System.err.println("Mời nhập lại một số nguyên dương:");
			}
//			} catch (Exception e) {
//				System.err.println("Mời nhập lại một số nguyên dương:");
//			}

		}
	}

// HỖ TRỢ NHẬP VÀO MỘT SỐ THỰC FLOAT (dạng rút gọn) -------------------------------------------------------------------------------------------
	public static float inputFloat() {
		while (true) {
			try {
				return Float.parseFloat(scanner.next().trim());
			} catch (Exception e) {
				System.err.println("Mời nhập lại một số thực (Float):");
			}
		}
	}

// HỖ TRỢ NHẬP VÀO MỘT SỐ THỰC DOUBLE (dạng rút gọn) -------------------------------------------------------------------------------------------
	public static double inputDouble() {
		while (true) {
			try {
				return Double.parseDouble(scanner.next().trim());
			} catch (Exception e) {
				System.err.println("Mời nhập lại một số thực (Double):");
			}
		}
	}

// HỖ TRỢ NHẬP VÀO MỘT CHUỖI KHÔNG RỖNG -------------------------------------------------------------------------------------------
	public static String inputString() {
		while (true) {
			String string = scanner.nextLine().trim();
			if (!string.isEmpty()) { // yêu cầu chuỗi không rỗng
				return string;
			} else {
				System.err.println("Mời nhập lại một chuỗi:");
			}
		}
	}

// HỖ TRỢ NHẬP VÀO NGÀY THÁNG -------------------------------------------------------------------------------------------
	public static LocalDate inputLocalDate() {
		System.out.println("Nhập theo định dạng: yyyy-MM-dd");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // yêu cầu về định dạng ngày tháng
		while (true) {
			String localdate = scanner.next().trim();
			try {
				if (format.parse(localdate) != null) {
					LocalDate lc = LocalDate.parse(localdate);
					return lc;
				}
			} catch (Exception e) {
				System.err.println("Mời nhập lại ngày tháng đúng định dạng:");
			}
		}
	}

}
