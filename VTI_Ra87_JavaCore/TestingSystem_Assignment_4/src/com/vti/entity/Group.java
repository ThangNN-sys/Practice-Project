package com.vti.entity;

import java.time.LocalDate;

public class Group {
	private int groupId;
	private String groupName;
	private Account creator;
	private Account[] accounts;
	private LocalDate createDate;
	public Group() {
		
	}
	public Group(int groupId, String groupName, Account creator, LocalDate createDate, Account[] accounts) {
		this.groupId = groupId;
		this.groupName = groupName;
		this.creator = creator;
		this.createDate = createDate;
		this.accounts = accounts;
	}
}
