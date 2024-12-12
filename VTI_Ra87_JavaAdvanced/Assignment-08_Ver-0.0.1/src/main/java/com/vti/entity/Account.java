package com.vti.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "accountId")
@Inheritance(strategy = InheritanceType.JOINED)

public class Account implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "AccountID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT PRIMARY KEY
    private short id; // TINYINT UNSIGNED

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
    private Department department;

    @ManyToOne // multiple Accounts to 1 Position
    @JoinColumn(name = "PositionID", referencedColumnName = "PositionID")
    private Position position;

    @ManyToOne // multiple Accounts to 1 Salary
    @JoinColumn(name = "SalaryID", referencedColumnName = "SalaryID")
    private Salary salary;

    @OneToMany(mappedBy = "account") // 1 Account to multiple GroupAccount, GroupAccount is owning side
    private List<GroupAccount> groupAccounts;

    @OneToMany(mappedBy = "creator") // 1 Account to multiple Question, Question is owning side
    private List<Question> questions;

    @OneToMany(mappedBy = "creator") // 1 Account to multiple Group, Group is owning side
    private List<Group> createdGroups;

    @Column(name = "CreateDate", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

}
