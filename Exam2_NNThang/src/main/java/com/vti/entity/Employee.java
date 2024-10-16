package com.vti.entity;

//Khởi tạo lớp Employee mở rộng từ lớp User, bao gồm 4 thuộc tính chính và 2 thuộc tính riêng là projectId và proSkill
public class Employee extends User {
	private int projectId;
	private String proSkill;

	public Employee(int id, String fullName, String email, String password, int projectId, String proSkill) {
		super(id, fullName, email, password);
		this.projectId = projectId;
		this.proSkill = proSkill;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}

	@Override
	public String toString() {
		return "Employee [id= " + id + ", fullName= " + fullName + ", email= " + email + ", password= " + password
				+ ", projectId= " + projectId + ", proSkill= " + proSkill + "]";
	}
}
