package com.vti.entity;

import com.vti.entity.primarykey.GroupAccountKey;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Class quản lý các Annotation
 * Dùng để khai báo các ánh xạ tới bảng GroupAccount của DB
 */

@Entity
@Table(name = "GroupAccount")
public class GroupAccount {

	@EmbeddedId
	private GroupAccountKey id;

	@ManyToOne
	@MapsId("accountId")
	@JoinColumn(name = "AccountID")
	private Account account;

	@ManyToOne
	@MapsId("groupId")
	@JoinColumn(name = "GroupID")
	private Group group;

	@Column(name = "JoinDate")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date joinDate;

	public GroupAccount() {
	}

	public GroupAccountKey getId() {
		return id;
	}

	public void setId(GroupAccountKey id) {
		this.id = id;
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

}
