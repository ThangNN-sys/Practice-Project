package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.ultis.JdbcUtils;

public class Exercise1 {

	private JdbcUtils jdbc;

	public Exercise1() throws IOException {
		super();
		jdbc = new JdbcUtils();
	}

	// kiểm tra kết nối với DB thành công chưa?
	public void question1() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		jdbc.connectForTesting();
	}

	public void question2() {

	}

	public void question3() {

	}

	public void question4() {

	}
}
