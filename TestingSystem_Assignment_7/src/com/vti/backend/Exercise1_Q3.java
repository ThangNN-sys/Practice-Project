package com.vti.backend;

import com.vti.entity.MyMath;
import com.vti.utils.ScannerUltis;

public class Exercise1_Q3 {
	public void question3() {
		System.out.println("Nhập vào số int 1:");
		int a = ScannerUltis.inputInt();
		System.out.println("Nhập vào số int 2:");
		int b = ScannerUltis.inputInt();
		System.out.println("Max của " + a + " và " + b + "là:" + MyMath.max(a, b));
		System.out.println("Min của " + a + " và " + b + "là:" + MyMath.min(a, b));
		System.out.println("Sum của " + a + " và " + b + "là:" + MyMath.sum(a, b));
	}
}
