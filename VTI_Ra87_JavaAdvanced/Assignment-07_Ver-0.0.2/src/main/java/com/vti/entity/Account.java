package com.vti.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Class quản lý các Annotation
 * Khai báo các ánh xạ tới bảng Account của DB
 */

@Entity
@Table(name = "`Account`")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "AccountId")
@Inheritance(strategy = InheritanceType.JOINED)

public class Account implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "createdAcc")
    @JsonIgnoreProperties("createdAcc")
    List<Group> createdGroups;

    @Column(name = "AccountID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short accountId;

    @Column(name = "Email", length = 50, nullable = false, unique = true, updatable = false)
    private String email;

    @Column(name = "Username", length = 50, nullable = false, unique = true, updatable = false)
    private String username;

    @Column(name = "FirstName", length = 50, nullable = false, updatable = false)
    private String firstName;

    @Column(name = "LastName", length = 50, nullable = false, updatable = false)
    private String lastName;

    @Formula(" concat(LastName, ' ', FirstName) ")
    private String fullName;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "DepartmentID", referencedColumnName = "DepartmentID")
    @JsonIgnoreProperties("accounts")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "PositionID", referencedColumnName = "PositionID")
    @JsonIgnoreProperties("accounts")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "SalaryID", referencedColumnName = "SalaryID")
    @JsonIgnoreProperties("accounts")
    private Salary salary;

    @OneToMany(mappedBy = "account")
    @JsonIgnoreProperties("account")
    private List<GroupAccount> groupAccountList;

    @Column(name = "CreateDate", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    public Account() {

    }

    public List<Group> getCreatedGroups() {
        return createdGroups;
    }

    public void setCreatedGroups(List<Group> createdGroups) {
        this.createdGroups = createdGroups;
    }

    public short getAccountId() {
        return accountId;
    }

    public void setAccountId(short accountId) {
        this.accountId = accountId;
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

    public List<GroupAccount> getGroupAccountList() {
        return groupAccountList;
    }

    public void setGroupAccountList(List<GroupAccount> groupAccountList) {
        this.groupAccountList = groupAccountList;
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
                "createdGroups=" + createdGroups +
                ", accountId=" + accountId +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", department=" + department +
                ", position=" + position +
                ", salary=" + salary +
                ", groupAccountList=" + groupAccountList +
                ", createDate=" + createDate +
                '}';
    }
}
