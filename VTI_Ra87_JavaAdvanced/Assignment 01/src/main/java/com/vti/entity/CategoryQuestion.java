package com.vti.entity;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "categoryquestion")
public class CategoryQuestion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CategoryID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "CategoryName", length = 50, nullable = false, unique = true, updatable = false)
	private String categoryName;

	public CategoryQuestion() {
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "CategoryQuestion{" +
				"id=" + id +
				", categoryName='" + categoryName + '\'' +
				'}';
	}
}
