package com.vti.form;

import java.io.File;
import java.io.IOException;

public class CheckPathIsFileOrFolder {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users");
		if (file.isDirectory()) {
			System.out.println("Path là Folder!");
		} else {
			System.out.println("Path là File!");
		}
	}
}
