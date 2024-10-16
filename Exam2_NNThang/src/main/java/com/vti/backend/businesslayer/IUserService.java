package com.vti.backend.businesslayer;

//Layer-2 (Business Layer): xử lý nghiệp vụ và logic
//Kết quả là true, Layer-2 sẽ gửi lệnh gọi tới Layer-3 để tiếp tục xử lý qua hàm UserReponsitoryImpl()
//Kết quả được trả về từ Layre03 sẽ được gửi tới Layer-1

public interface IUserService {
	public abstract boolean checkLogin(String email, String password);
}
