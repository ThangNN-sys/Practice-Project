package com.vti.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

/**
 * Class quản lý các Annotation
 * Dùng để khai báo các ánh xạ tới bảng Group của DB
 */

@Entity
@Table(name = "`Group`")
public class Group implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "GroupID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short groupId; // maps to TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY

	@Column(name = "GroupName", length = 50, nullable = false, unique = true)
	private String groupName; // maps to NVARCHAR(50) NOT NULL UNIQUE KEY

//	@ManyToOne
//	@JoinColumn(name = "CreatorID", referencedColumnName = "AccountID", updatable = false)
//	private Account creator; // maps to TINYINT UNSIGNED NOT NULL cannot update

	@Column(name = "CreateDate", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate; // maps to DATETIME DEFAULT

//	@OneToMany(mappedBy = "group")
//	private List<GroupAccount> groupAccounts;

	public Group() {
	}

	public short getGroupId() {
		return groupId;
	}

	public void setGroupId(short id) {
		this.groupId = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String name) {
		this.groupName = name;
	}

//	public Account getCreator() {
//		return creator;
//	}
//
//	public void setCreator(Account creator) {
//		this.creator = creator;
//	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

//	public List<GroupAccount> getGroupAccounts() {
//		return groupAccounts;
//	}
//
//	public void setGroupAccounts(List<GroupAccount> accounts) {
//		this.groupAccounts = accounts;
//	}

//	@Override
//	public String toString() {
//
//		for (GroupAccount groupAccount : groupAccounts) {
//			System.out.println(groupAccount.getAccount().getFullName());
//			System.out.println(groupAccount.getJoinDate());
//		}
//
//		return "Group [id=" + groupId + ", name=" + groupName + ", creator=" + creator.getFullName() + ", createDate="
//				+ createDate + "]";
//	}

}
