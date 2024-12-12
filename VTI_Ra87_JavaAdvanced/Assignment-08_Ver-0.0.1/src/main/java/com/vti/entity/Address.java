package com.vti.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * Class quản lý các Annotation
 * Khai báo các ánh xạ tới bảng Address của DB
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "Address")
public class Address implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "AddressID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT PRIMARY KEY
    private short id; // TINYINT UNSIGNED

    @Column(name = "AddressName", length = 100, nullable = false, unique = true)
    private String name; // VARCHAR(100) NOT NULL UNIQUE KEY

    @OneToMany(mappedBy = "address") // 1 Address to multiple DetailDepartment, DetailDepartment is owning side
    private List<DetailDepartment> detailDepartments;

}
