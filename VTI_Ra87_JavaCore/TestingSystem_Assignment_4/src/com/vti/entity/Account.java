package com.vti.entity;

import java.time.LocalDate;

public class Account {
	private int accId;
	private String email;
	private String userName;
	private String fullName;
	private String position;
	private LocalDate createDate;

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(int accId, String email, String userName, String fullName, String position, LocalDate date) {
		this.accId = accId;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.position = position;
		this.createDate = LocalDate.now();

	}

}
