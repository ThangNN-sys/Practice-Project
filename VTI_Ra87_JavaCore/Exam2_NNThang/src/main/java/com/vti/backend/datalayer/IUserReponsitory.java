package com.vti.backend.datalayer;

//Layer-3 (Data layer): Thao tác với DB, có vai trò gửi yêu cầu tới DB và là kho chứa dữ liệu nạp từ DB lên
//Dữ liệu trả về từ DB được Layer-3 chuyển tới Layer-2 tiếp tục xử lý

public interface IUserReponsitory {
	public abstract boolean checkLogin(String email, String password);
}
