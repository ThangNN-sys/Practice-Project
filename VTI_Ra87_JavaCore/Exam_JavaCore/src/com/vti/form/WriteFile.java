package com.vti.form;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFile {
	public static void main(String[] args) throws IOException {

		// replate content
		String content = "Tên tôi là: Nguyễn Văn A";
		FileOutputStream fileOutputStream = new FileOutputStream("C:\\User\\test.txt", false);
		fileOutputStream.write(content.getBytes());
		fileOutputStream.close();

		// continuing content
		String content = "Tên tôi là: Nguyễn Văn A";
		FileOutputStream fileOutputStream = new FileOutputStream("C:\\User\\test.txt", true);
		fileOutputStream.write(content.getBytes());
		fileOutputStream.close();
	}
}
