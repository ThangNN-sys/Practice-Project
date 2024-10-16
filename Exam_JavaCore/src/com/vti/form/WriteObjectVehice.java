package com.vti.form;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.vti.entity.WriteObjectVehice;

public class WriteObjectVehice {
	public static void main(String[] args) throws IOException {
		WriteObjectVehice writeObjectVehice = new WriteObjectVehice("CRV", "Red", "Honda");
		FileOutputStream fileOutputStream = new FileOutputStream("C:\\User\\test.ser");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(writeObjectVehice);
		objectOutputStream.close();
	}
}
