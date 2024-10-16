package com.vti.backend.presentationlayer;

import java.util.regex.Pattern;

import com.vti.backend.businesslayer.IUserService;
import com.vti.backend.businesslayer.UserServiceImpl;

//Layer-1 (Presentation Layer): kiểm tra tính đúng đắn của dữ liệu nhận được từ frontend (App class) và quyết định có đưa dữ liệu xuống tầng tiếp theo hay không
//Kết quả đánh giá là true, Layer-1 sẽ gửi lệnh gọi tới Layer-2 để tiếp tục xử lý qua hàm UserServiceImpl()
//Kêt quả được trả về từ Layer-2 sẽ được tiếp nhận tại đây, gửi tới App class để thực thi các hàm tiếp theo tại App class

public class UserController {

	public IUserService iuserservice;

	public UserController() {
		iuserservice = new UserServiceImpl();
	}

	public boolean checkLogin(String email, String password) {
		final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		if (email == null || !Pattern.matches(EMAIL_REGEX, email)) {
			System.out.println("Đề nghị nhập đúng định dạng *@*:");
			return false;
		}
		if (password == null || password.length() < 6 || password.length() > 12) {
			System.out.println("Đề nghị nhập password có độ dài từ 6 đến 12 ký tự:");
			return false;
		}
		return iuserservice.checkLogin(email, password);
	}

}
