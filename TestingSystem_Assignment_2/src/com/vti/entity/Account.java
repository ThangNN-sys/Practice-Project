package com.vti.entity;

import java.time.LocalDate;

public class Account {
	public int accId;
	public String email;
	public String userName;
	public String fullName;
	public Department department;
	public Position position;
	public LocalDate createDate;
	public Group[] groups;
	
}
