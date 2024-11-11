package com.vti.entity;

import com.vti.entity.primarykey.GroupAccountKey;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Class quản lý các Annotation
 * Dùng để khai báo các ánh xạ tới bảng GroupAccount của DB
 */

@Entity
@Table(name = "GroupAccount")
public class GroupAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GroupAccountKey groupAccountId;

	@ManyToOne
	@MapsId("AccountID")
	@JoinColumn(name = "AccountID")
	private Account account;

	@ManyToOne
	@MapsId("GroupID")
	@JoinColumn(name = "GroupID")
	private Group group;

	@Column(name = "JoinDate", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date joinDate;

	public GroupAccount() {
	}

	public GroupAccountKey getGroupAccountId() {
		return groupAccountId;
	}

	public void setGroupAccountId(GroupAccountKey id) {
		this.groupAccountId = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "GroupAccount{" +
				"groupAccountId=" + groupAccountId +
				", account=" + account +
				", group=" + group +
				", joinDate=" + joinDate +
				'}';
	}
}
