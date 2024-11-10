package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Class quản lý các Annotation
 * Dùng để khai báo các ánh xạ tới bảng Account của DB
 */

@Entity
@Table(name = "`Account`", catalog = "TestingSystem")
@Inheritance(strategy = InheritanceType.JOINED)
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "AccountID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short accountId;

	@Column(name = "Email", length = 50, nullable = false, unique = true, updatable = false)
	private String email;

	@Column(name = "Username", length = 50, nullable = false, unique = true, updatable = false)
	private String username;

	@Column(name = "FirstName", length = 50, nullable = false)
	private String firstName;

	@Column(name = "LastName", length = 50, nullable = false)
	private String lastName;

	@Formula(" concat(FirstName, ' ', LastName) ")
	private String fullName;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "DepartmentID", referencedColumnName = "DepartmentID")
	private Department department;

	@ManyToOne
	@JoinColumn(name = "PositionID", referencedColumnName = "PositionID")
	private Position position;

	@ManyToOne
	@JoinColumn(name = "SalaryID", referencedColumnName = "SalaryID")
	private Salary salary;

	@Column(name = "CreateDate")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;

	@OneToMany(mappedBy = "creator")
	private List<Group> createdGroups;

	@OneToMany(mappedBy = "account")
	private List<GroupAccount> groupAccounts;

	public Account() {
	}

	public Account(String newUser, Department department) {
	}

	public short getAccountId() {
		return accountId;
	}

	public void setAccountId(short id) {
		this.accountId = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public List<Group> getCreatedGroups() {
		return createdGroups;
	}

	public void setCreatedGroups(List<Group> createdGroup) {
		this.createdGroups = createdGroup;
	}

	public List<GroupAccount> getGroupAccounts() {
		return groupAccounts;
	}

	public void setGroupAccounts(List<GroupAccount> groups) {
		this.groupAccounts = groups;
	}

	@Override
	public String toString() {
		return "Account [ id = " + accountId + ", email = " + email + ", username = " + username + ", fullName = " + fullName + ", department = " + department + ", position = "
				+ position + ", salary = " + salary + ", createDate = " + createDate + "]";
	}
}
