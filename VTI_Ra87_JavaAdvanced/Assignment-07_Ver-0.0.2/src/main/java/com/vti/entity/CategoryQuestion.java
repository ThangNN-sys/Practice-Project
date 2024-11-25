package com.vti.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * Class quản lý các Annotation
 * Khai báo các ánh xạ tới bảng CategoryQuestion của DB
 */

@Entity
@Table(name = "CategoryQuestion")

public class CategoryQuestion implements Serializable {

    @Serial
	private static final long serialVersionUID = 1L;

	@Column(name = "CategoryID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short categoryId; // maps to TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY

	@Column(name = "CategoryName", length = 50, nullable = false, unique = true)
	private String categoryName; // maps to VARCHAR(50) NOT NULL UNIQUE KEY

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