package com.vti.entity;

import com.vti.entity.enumerate.SalaryName;
import com.vti.entity.enumerate.SalaryNameConvert;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * Class quản lý các Annotation
 * Khai báo các ánh xạ tới bảng Salary của DB
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "Salary")
public class Salary implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "SalaryID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id; // maps to TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY

    @Column(name = "SalaryName", nullable = false, unique = true)
    @Convert(converter = SalaryNameConvert.class)
    private SalaryName name; // maps to ENUM('600','700','1500','2000') NOT NULL UNIQUE KEY

    @OneToMany(mappedBy = "salary")
    private List<Account> accounts;

}
