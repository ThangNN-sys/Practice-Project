package com.vti.form;

import java.io.File;
import java.io.IOException;

public class GetAllFileOfFolder {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\User");
		for (String fileName : file.list()) {
			System.out.println(fileName);
		}
	}
}
