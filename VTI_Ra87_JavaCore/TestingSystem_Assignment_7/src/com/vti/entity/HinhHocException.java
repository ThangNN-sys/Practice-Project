package com.vti.entity;

public class HinhHocException extends Exception {
	public HinhHocException() {
		super("Số lượng hình đã tạo vượt quá số lượng cho phép là: " + Config.So_luong_hinh_toi_da
				+ " hãy kiểm tra lại.");
	}
}
