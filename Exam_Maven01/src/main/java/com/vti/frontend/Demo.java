package com.vti.frontend;

import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.Exercise1;

public class Demo {
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		Exercise1 exercise = new Exercise1();
		exercise.question1();
		exercise.question2();
	}
}
