package com.vti.dto;

/**
 * ClassDTO là một đối tượng dạng Data Transfer Object (DTO). DTO là một mẫu thiết kế dùng để
 * truyền dữ liệu giữa các lớp, tầng (layer) trong một ứng dụng, đặc biệt là trong các
 * hệ thống phân tán hoặc ứng dụng nhiều tầng như kiến trúc MVC.
 * ---
 * DepartmentDTO có vai trò chứa đựng thông tin cơ bản của một department, thường bao
 * gồm các trường (field) cần thiết để phục vụ một mục đích cụ thể, mà trong trường hợp này
 * là ba thuộc tính: id, name, và address. Nó giúp hạn chế việc truyền dữ liệu không cần thiết
 * giữa các lớp trong ứng dụng, tiết kiệm tài nguyên và cải thiện hiệu suất.
 * ---
 * Lý do sử dụng DTO: Bảo mật dữ liệu, Tăng hiệu năng, Tách biệt các tầng: Giúp tách biệt
 * dữ liệu hiển thị với dữ liệu thực tế trong lớp Department, tránh phụ thuộc trực tiếp
 * vào cấu trúc của Department.
 */
public class DepartmentDTO {
	
	private short departmentId;
	
	private String departmentName;
	
	private String departmentAddress;

	public DepartmentDTO() {
	}

	public DepartmentDTO(short id, String name, String address) {
		this.departmentId = id;
		this.departmentName = name;
		this.departmentAddress = address;
	}

	public short getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(short departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentAddress() {
		return departmentAddress;
	}

	public void setDepartmentAddress(String departmentAddress) {
		this.departmentAddress = departmentAddress;
	}

	@Override
	public String toString() {
		return "DepartmentDTO [departmentId = " + departmentId + ", departmentName = " + departmentName + ", departmentAddress = "
				+ departmentAddress + "]";
	}

}
