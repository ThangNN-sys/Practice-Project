package com.vti.entity;

// Khởi tạo lớp Manager mở rộng từ lớp User, bao gồm 4 thuộc tính chính và 2 thuộc tính riêng là expInYear và projectId
public class Manager extends User {
	private int expInYear;
	private String projectId;

	public Manager(int id, String fullName, String email, String password, int expInYear, String projectId) {
		super(id, fullName, email, password);
		this.expInYear = expInYear;
		this.projectId = projectId;
	}

	public int getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "Manager [id= " + id + ", fullName= " + fullName + ", email= " + email + ", password= " + password
				+ ", expInYear= " + expInYear + ", projectId= " + projectId + "]";
	}
}
