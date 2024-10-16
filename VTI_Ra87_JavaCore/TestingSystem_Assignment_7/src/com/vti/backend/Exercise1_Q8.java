package com.vti.backend;

import com.vti.entity.HinhChuNhat;
import com.vti.entity.HinhTron;
import com.vti.utils.ScannerUltis;

public class Exercise1_Q8 {
	public void question8() throws Exception {
		System.out.println("Tạo 4 hình chữ nhật");
		HinhChuNhat[] arrHcns = new HinhChuNhat[4];
		for (int i = 0; i < 4; i++) {
			System.out.println("Hình " + (i + 1) + " :");
			System.out.println("Cạnh a:");
			Float a = ScannerUltis.inputFloat();
			System.out.println("Cạnh b:");
			Float b = ScannerUltis.inputFloat();
			HinhChuNhat hcn = new HinhChuNhat(a, b) {
			};
			arrHcns[i] = hcn;

		}
		System.out.println("Tạo hình tròn số 1, nhập vào bán kinh:");
		Float r1 = ScannerUltis.inputFloat();
		HinhTron hinhTron1 = new HinhTron(r1, r1) {
		};
		System.out.println("Tạo hình tròn số 2, nhập vào bán kinh:");
		Float r2 = ScannerUltis.inputFloat();
		HinhTron hinhTron2 = new HinhTron(r2, r2) {
		};
	}
}
