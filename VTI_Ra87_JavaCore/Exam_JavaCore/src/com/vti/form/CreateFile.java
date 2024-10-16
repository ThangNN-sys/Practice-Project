package com.vti.form;

import java.io.File;
import java.io.IOException;

public class CreateFile {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\test.txt");
		if (file.createNewFile()) {
			System.out.println("Tạo file thành công!");
		} else {
			System.out.println("Tạo file không thành công!");
		}
	}
}
