package com.vti.entity;

public class Student implements IStudent {
	public static int COUNT;
	private int id;
	private String name;
	private int group;

	@Override
	public String toString() {
		return "Student [id= " + id + ", name= " + name + ", group= " + group + "]";
	}

	public int getGroup() {
		return group;
	}

	@Override
	public void diemDanh() {
		System.out.println(name + " điểm danh.");
	}

	@Override
	public void hocBai() {
		System.out.println(name + " đang học bài.");
	}

	@Override
	public void donVeSinh() {
		System.out.println(name + " đi dọn vệ sinh.");
	}

	public Student(String name, int group) {
		COUNT++;
		this.id = COUNT;
		this.name = name;
		this.group = group;
	}
}
