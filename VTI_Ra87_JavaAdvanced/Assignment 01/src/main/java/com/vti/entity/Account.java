package com.vti.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "`Account`")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "AccountID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id; // Maps to TINYINT UNSIGNED AUTO_INCREMENT

	@Column(name = "Email", length = 50, nullable = false, unique = true, updatable = false)
	private String email; // Maps to VARCHAR(50) NOT NULL UNIQUE

	@Column(name = "Username", length = 50, nullable = false, unique = true, updatable = false)
	private String username; // Maps to VARCHAR(50) NOT NULL UNIQUE

	@Column(name = "FirstName", length = 50, nullable = false)
	private String firstName; // Maps to NVARCHAR(50)

	@Column(name = "LastName", length = 50, nullable = false)
	private String lastName; // Maps to NVARCHAR(50)

	@Formula(" concat(FirstName, ' ', LastName) ")
	private String fullName;

	@Column(name = "CreateDate")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;

	public Account() {
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Account{" +
				"id=" + id +
				", email='" + email + '\'' +
				", username='" + username + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", createDate=" + createDate +
				'}';
	}
}
