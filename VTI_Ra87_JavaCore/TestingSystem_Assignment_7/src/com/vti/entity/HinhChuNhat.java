package com.vti.entity;

public abstract class HinhChuNhat extends HinhHoc {
	public HinhChuNhat(Float a, Float b) throws Exception {
		super(a, b);
	}

	@Override
	public Float tinhChuVi(Float a, Float b) {
		return 2 * (a + b);
	}

	@Override
	public Float tinhDienTich(Float a, Float b) {
		return a * b;
	}
}
