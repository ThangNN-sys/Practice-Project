package com.vti.entity.primarykey;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
public class GroupAccountKey implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "AccountID")
    private int accountId;

    @Column(name = "GroupID", nullable = false)
    private int groupId;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountID) {
        this.accountId = accountID;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupID) {
        this.groupId = groupID;
    }

}
