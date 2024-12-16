package com.vti.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * Class quản lý các Annotation
 * Khai báo các ánh xạ tới bảng Department của DB
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "Department")
@Inheritance(strategy = InheritanceType.JOINED)

public class Department implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "DepartmentID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT PRIMARY KEY
    private short id; // TINYINT UNSIGNED

    @Column(name = "TotalMember")
    private short totalMember; // TINYINT UNSIGNED

    @Column(name = "DepartmentName", length = 30, nullable = false, unique = true)
    private String name; // NVARCHAR(30) NOT NULL UNIQUE KEY

    @OneToMany(mappedBy = "department") // 1 Department to multiple Account, Account is owning side
    private List<Account> accounts;

}
