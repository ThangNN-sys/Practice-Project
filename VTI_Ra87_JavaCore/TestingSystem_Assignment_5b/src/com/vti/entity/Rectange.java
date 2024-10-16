package com.vti.entity;

public class Rectange {
	private Float a;
	private Float b;

	public Float tinhChuVi() {
		return (a + b) * 2;
	}

	public Float tinhDienTich() {
		return a * b;
	}

	public Rectange(Float a, Float b) {
		super();
		this.a = a;
		this.b = b;
	}
}
