package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Class quản lý các Annotation
 * Dùng để khai báo các ánh xạ tới bảng Group của DB
 */

@Entity
@Table(name = "`Group`", catalog = "TestingSystem")
public class Group implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "GroupID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short groupId;

	@Column(name = "GroupName", length = 50, nullable = false, unique = true)
	private String groupName;

	@ManyToOne
	@JoinColumn(name = "CreatorID", nullable = false)
	private Account creator;

	@Column(name = "CreateDate")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;

	@OneToMany(mappedBy = "group", fetch = FetchType.EAGER)
	private List<GroupAccount> accounts;

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

	public Account getCreator() {
		return creator;
	}

	public void setCreator(Account creator) {
		this.creator = creator;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public List<GroupAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<GroupAccount> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {

		for (GroupAccount groupAccount : accounts) {
			System.out.println(groupAccount.getAccount().getFullName());
			System.out.println(groupAccount.getJoinDate());
		}

		return "Group [id=" + groupId + ", name=" + groupName + ", creator=" + creator.getFullName() + ", createDate="
				+ createDate + "]";
	}

}
