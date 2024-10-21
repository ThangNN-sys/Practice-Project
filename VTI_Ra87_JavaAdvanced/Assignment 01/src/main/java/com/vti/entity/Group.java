package com.vti.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "`Group`", uniqueConstraints = @UniqueConstraint(columnNames = {"GroupName"}))
public class Group implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "GroupID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "GroupName", length = 50, nullable = false, unique = true)
	private String name;

	public Group() {
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Group { " + "ID = " + id + ", Name = '" + name + '\'' + '}';
	}

}
