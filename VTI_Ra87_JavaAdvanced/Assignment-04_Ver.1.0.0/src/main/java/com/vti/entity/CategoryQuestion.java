package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Class quản lý các Annotation
 * Dùng để khai báo các ánh xạ tới bảng CategoryQuestion của DB
 */

@Entity
@Table(name = "CategoryQuestion", catalog = "TestingSystem")

public class CategoryQuestion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CategoryID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short categoryId; // Maps to TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY

	@Column(name = "CategoryName", length = 50, nullable = false, unique = true)
	private String categoryName; // Maps to VARCHAR(50) NOT NULL UNIQUE KEY

	public CategoryQuestion() {
	}

	public short getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(short id) {
		this.categoryId = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String name) {
		this.categoryName = name;
	}

	@Override
	public String toString() {
		return "CategoryQuestion{" +
				"categoryId=" + categoryId +
				", categoryName='" + categoryName + '\'' +
				'}';
	}
}
