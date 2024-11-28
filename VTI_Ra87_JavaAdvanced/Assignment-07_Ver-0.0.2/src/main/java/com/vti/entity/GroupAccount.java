package com.vti.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vti.entity.primarykey.GroupAccountKey;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * Class quản lý các Annotation
 * Khai báo các ánh xạ tới bảng GroupAccount của DB
 */

@Entity
@Table(name = "GroupAccount")
public class GroupAccount implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private GroupAccountKey groupAccountKey;

    @ManyToOne
    @MapsId("groupId")
    @JoinColumn(name = "groupId")
    @JsonIgnoreProperties("groupAccounts")
    private Group group;

    @ManyToOne
    @MapsId("accountId")
    @JoinColumn(name = "accountId")
    @JsonIgnoreProperties("groupAccounts")
    private Account account;

    @Column(name = "JoinDate", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date joinDate;

    public GroupAccountKey getGroupAccountKey() {
        return groupAccountKey;
    }

    public void setGroupAccountKey(GroupAccountKey groupAccountKey) {
        this.groupAccountKey = groupAccountKey;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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
                "groupAccountKey=" + groupAccountKey +
                ", group=" + group +
                ", account=" + account +
                ", joinDate=" + joinDate +
                '}';
    }
}
