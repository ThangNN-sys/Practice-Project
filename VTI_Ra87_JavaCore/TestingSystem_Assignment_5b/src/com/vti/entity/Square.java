package com.vti.entity;

public class Square extends Rectange {
	public Square(Float a) {
		super(a, a);
	}
}

//Chú ý: 
//Không implement method trong class HinhVuong theo công 
//thức tính diện tích, chu vi hình vuông mà sẽ gọi theo 
//HinhChuNhat.tinhChuVi(), HinhChuNhat.tinhDienTich() ) 
//Và trong mỗi method print thêm dòng "Tính diện tích/ chu vi 
//theo Hình Vuông/ Hình Chữ Nhật"