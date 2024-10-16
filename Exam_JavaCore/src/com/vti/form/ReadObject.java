package com.vti.form;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.vti.entity.WriteObjectVehice;

public class ReadObject {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream("C:\\User\\test.ser");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		Object obj = objectInputStream.readObject();
		objectInputStream.close();
		WriteObjectVehice writeObjectVehice = (WriteObjectVehice) obj;
		System.out.println(writeObjectVehice.getName());
		System.out.println(writeObjectVehice.getColor());
		System.out.println(writeObjectVehice.getBrand());
	}
}
