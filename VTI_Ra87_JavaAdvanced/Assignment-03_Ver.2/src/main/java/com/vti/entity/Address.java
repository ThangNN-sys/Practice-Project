package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Class quản lý các Annotation
 * Dùng để khai báo các ánh xạ tới bảng Address của DB
 */

@Entity
@Table(name = "Address", catalog = "TestingSystem")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "AddressID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short addressId; // Maps to TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY

	@Column(name = "AddressName", length = 100, nullable = false, unique = true)
	private String addressName; // Maps to VARCHAR(100) NOT NULL UNIQUE KEY

//	@OneToOne(mappedBy = "address")
//	private DetailDepartment department;

	public Address() {
	}

	public Address(String name) {
		this.addressName = name;
	}

	public short getAddressId() {
		return addressId;
	}

	public void setAddressId(short id) {
		this.addressId = id;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String name) {
		this.addressName = name;
	}

	@Override
	public String toString() {
		return "Address [id=" + addressId + ", name=" + addressName + "]";
	}

}
