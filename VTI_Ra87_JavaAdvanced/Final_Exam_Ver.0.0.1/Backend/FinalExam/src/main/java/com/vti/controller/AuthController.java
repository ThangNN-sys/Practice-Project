package com.vti.controller;

import com.vti.dto.auth.LoginInfoDto;
import com.vti.entity.Account;
import com.vti.service.IAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * AuthController is a REST controller that provides an endpoint
 * for user authentication functionalities.
 * (xử lý logic xác thực và đăng nhập của người dùng)
 */
@RestController
@RequestMapping(value = "api/v1/auth") // Gắn URL gốc cho các endpoint
public class AuthController {

	// @Autowired: Spring sẽ tự động inject (tiêm) các dependency:
	// ModelMapper: Công cụ chuyển đổi entity sang DTO và ngược lại.
	// IAccountService: Service cung cấp logic xử lý liên quan đến Account.
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private IAccountService service;

	// @GetMapping("/login"): Endpoint trả về thông tin người dùng hiện tại dựa trên thông tin xác thực.
	// Principal principal: Đối tượng chứa thông tin xác thực của người dùng hiện tại,
	// được Spring Security tự động cung cấp.
	// Logic xử lý:
	// Lấy tên đăng nhập của người dùng hiện tại từ principal.getName().
	// Dùng service.getAccountByUsername(username) để lấy thông tin tài khoản từ cơ sở dữ liệu (trả về entity Account).
	// Dùng ModelMapper để chuyển đổi từ entity Account sang DTO LoginInfoDto.
	// Trả về đối tượng DTO cho client (định dạng JSON).
	@GetMapping("/login") // Định nghĩa các endpoint với HTTP GET
	public LoginInfoDto login(Principal principal) {

		String username = principal.getName();
		Account entity = service.getAccountByUsername(username);

		// convert entity --> dto
		LoginInfoDto dto = modelMapper.map(entity, LoginInfoDto.class);

		return dto;
	}
}
