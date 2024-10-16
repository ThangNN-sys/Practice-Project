package com.vti.entity;

//Question 2 (Optional): 
//Các thí sinh dự thi đại học bao gồm các thí sinh thi khối A, B, và khối C. Các thí sinh cần quản lý các thông tin sau: Số báo danh, họ tên, địa chỉ, mức ưu tiên. 
//Thí sinh thi khối A thi các môn: Toán, Lý, Hoá. 
//Thí sinh thi khối B thi các môn: Toán, Hoá, Sinh. 
//Thí sinh thi khối C thi các môn: Văn, Sử, Địa. 
//a) Xây dựng các class để quản lý các thi sinh dự thi đại học. 
//Tạo Class Block khối thi: 
public class Block {
	private String name;
	private String subject;

	public Block(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getSubject() {
		switch (name) {
		case "A":
			this.subject = "Toán, Lý, Hoá";
			break;
		case "B":
			this.subject = "Toán, Hoá, Sinh";
			break;
		case "C":
			this.subject = "Văn, Sử, Địa";
			break;
		}
		return this.subject;
	}
}
