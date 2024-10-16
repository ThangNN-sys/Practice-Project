package com.vti.form;

import java.io.File;

public class CheckFileIsExits {
	public static void main(String[] args) {
		File file = new File("C:\\User\\test.txt");
		if (file.exists()) {
			System.out.println("File is exits!");
		} else {
			System.out.println("File is not exits!");
		}
	}
}
