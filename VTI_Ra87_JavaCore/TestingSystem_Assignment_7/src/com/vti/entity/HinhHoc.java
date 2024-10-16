package com.vti.entity;

public abstract class HinhHoc {
	private Float a;
	private Float b;
	public static int COUNT = 0;

	public abstract Float tinhChuVi(Float a, Float b);

	public abstract Float tinhDienTich(Float a, Float b);

	public HinhHoc(Float a, Float b) throws Exception {
		super();
		COUNT++;
		if (COUNT <= Config.So_luong_hinh_toi_da) {
			this.a = a;
			this.b = b;
		} else {
			throw new HinhHocException();
		}
	}
}
