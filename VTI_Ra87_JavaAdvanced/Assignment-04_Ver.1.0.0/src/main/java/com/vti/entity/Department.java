package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Class quản lý các Annotation
 * Dùng để khai báo các ánh xạ tới bảng Department của DB
 */

@Entity
@Table(name = "Department", catalog = "TestingSystem")

// @Inheritance(strategy = InheritanceType.JOINED) trong Hibernate dùng để chỉ định chiến lược kế thừa
// cho các lớp con của một entity trong cơ sở dữ liệu, theo chiến lược JOINED. Chiến lược này lưu trữ mỗi lớp con
// trong một bảng riêng, liên kết với bảng của lớp cha thông qua khóa ngoại. Điều này phù hợp khi bạn muốn lưu trữ
// các thuộc tính chung của lớp cha trong một bảng, còn các thuộc tính riêng của từng lớp con trong các bảng con tương ứng.
@Inheritance(strategy = InheritanceType.JOINED)

public class Department implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "DepartmentID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short departmentId; // Maps to TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY

	@Column(name = "DepartmentName", length = 30, nullable = false, unique = true)
	private String departmentName; // Maps to VARCHAR(30) NOT NULL UNIQUE KEY

	// mối quan hệ này đã được ánh xạ bởi trường Department trong class Account
	// Department không sở hữu mối quan hệ này; Account mới là phía sở hữu (owning side).
	// fetch = FetchType.EAGER: Thiết lập chế độ tải dữ liệu EAGER, tức là các đối tượng Account liên quan sẽ được tải
	// ngay lập tức khi một đối tượng Department được truy vấn
	@OneToMany(mappedBy = "department")
	private List<Account> accounts;

	public Department() {
	}

	public short getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(short id) {
		this.departmentId = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String name) {
		this.departmentName = name;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Department { " + "ID = " + departmentId + ", Name = '" + departmentName + '\'' + '}';
	}

}
