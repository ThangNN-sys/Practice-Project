package com.vti.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.Formula;

import java.io.Serializable;

@Entity
@Table(name = "`Account`")

public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "AccountID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id; // maps to TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY

    @Column(name = "Email", length = 50, nullable = false, unique = true, updatable = false)
    private String email; // maps to VARCHAR(50) NOT NULL UNIQUE KEY (Cannot update)

    @Column(name = "Username", length = 50, nullable = false, unique = true, updatable = false)
    private String username; // maps to VARCHAR(50) NOT NULL UNIQUE KEY (Cannot update)

    @Column(name = "FirstName", length = 50, nullable = false)
    private String firstName; // maps to NVARCHAR(50) NOT NULL

    @Column(name = "LastName", length = 50, nullable = false)
    private String lastName; // NVARCHAR(50) NOT NULL

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

}
