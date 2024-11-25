package com.vti.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Setter
@Getter
public class GroupAccountKey implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "GroupID", nullable = false)
    private short groupId;

    @Column(name = "AccountID")
    private short accountId;

//	/**
//	 * @return the groupId
//	 */
//	public short getGroupId() {
//		return groupId;
//	}
//
//	/**
//	 * @param groupId the groupId to set
//	 */
//	public void setGroupId(short groupId) {
//		this.groupId = groupId;
//	}
//
//	/**
//	 * @return the accountId
//	 */
//	public short getAccountId() {
//		return accountId;
//	}
//
//	/**
//	 * @param accountId the accountId to set
//	 */
//	public void setAccountId(short accountId) {
//		this.accountId = accountId;
//	}	
}
