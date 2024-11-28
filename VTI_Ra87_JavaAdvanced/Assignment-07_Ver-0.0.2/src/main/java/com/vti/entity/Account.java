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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "accountId")
@Inheritance(strategy = InheritanceType.JOINED)

public class Account implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "AccountID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT PRIMARY KEY
    private short accountId; // TINYINT UNSIGNED

    @Column(name = "Email", length = 50, nullable = false, unique = true, updatable = false)
    private String email; // VARCHAR(50) NOT NULL UNIQUE KEY, -- Cannot update this field

    @Column(name = "Username", length = 50, nullable = false, unique = true, updatable = false)
    private String username; // VARCHAR(50) NOT NULL UNIQUE KEY, -- Cannot update this field

    @Column(name = "FirstName", length = 50, nullable = false)
    private String firstName; // NVARCHAR(50) NOT NULL

    @Column(name = "LastName", length = 50, nullable = false)
    private String lastName; // NVARCHAR(50) NOT NULL

    @Formula(" concat(LastName, ' ', FirstName) ")
    private String fullName;

    @OneToOne(mappedBy = "account") // 1 Account to 1 Employee, Employee is owning side
    private Employee employee;

    @ManyToOne // multiple Accounts to 1 Department
    @JoinColumn(name = "DepartmentID", referencedColumnName = "DepartmentID")
    @JsonIgnoreProperties("accounts") // Avoid infinite loops, ignore accounts field in Department if exists
    private Department department;

    @ManyToOne // multiple Accounts to 1 Position
    @JoinColumn(name = "PositionID", referencedColumnName = "PositionID")
    @JsonIgnoreProperties("accounts")
    private Position position;

    @ManyToOne // multiple Accounts to 1 Salary
    @JoinColumn(name = "SalaryID", referencedColumnName = "SalaryID")
    @JsonIgnoreProperties("accounts")
    private Salary salary;

    @OneToMany(mappedBy = "account") // 1 Account to multiple GroupAccount, GroupAccount is owning side
    @JsonIgnoreProperties("account")
    private List<GroupAccount> groupAccounts;

    @OneToMany(mappedBy = "creator") // 1 Account to multiple Question, Question is owning side
    @JsonIgnoreProperties("creator")
    private List<Question> questions;

    @OneToMany(mappedBy = "creator") // 1 Account to multiple Group, Group is owning side
    @JsonIgnoreProperties("creator")
    private List<Group> createdGroups;

    @Column(name = "CreateDate", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    public Account() {

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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public List<GroupAccount> getGroupAccounts() {
        return groupAccounts;
    }

    public void setGroupAccounts(List<GroupAccount> groupAccounts) {
        this.groupAccounts = groupAccounts;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Group> getCreatedGroups() {
        return createdGroups;
    }

    public void setCreatedGroups(List<Group> createdGroups) {
        this.createdGroups = createdGroups;
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
                "accountId=" + accountId +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", employee=" + employee +
                ", department=" + department +
                ", position=" + position +
                ", salary=" + salary +
                ", groupAccounts=" + groupAccounts +
                ", questions=" + questions +
                ", createdGroups=" + createdGroups +
                ", createDate=" + createDate +
                '}';
    }
}
