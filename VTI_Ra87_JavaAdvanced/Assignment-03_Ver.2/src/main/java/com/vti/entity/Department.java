package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Department", catalog = "TestingSystem")
@Inheritance(strategy = InheritanceType.JOINED)
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "DepartmentID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short depId;

	@Column(name = "DepartmentName", length = 30, nullable = false, unique = true)
	private String depName;

	@OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
	private List<Account> accounts;

	public Department() {
	}

	public short getDepId() {
		return depId;
	}

	public void setDepId(short id) {
		this.depId = id;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String name) {
		this.depName = name;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Department { " + "ID = " + depId + ", Name = '" + depName + '\'' + '}';
	}

}
