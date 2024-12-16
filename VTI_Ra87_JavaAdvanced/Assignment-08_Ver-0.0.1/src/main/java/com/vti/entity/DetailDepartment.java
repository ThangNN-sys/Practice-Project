package com.vti.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * Class quản lý các Annotation
 * Khai báo các ánh xạ tới bảng DetailDepartment của DB
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "DetailDepartment")
@PrimaryKeyJoinColumn(name = "DepartmentID")
public class DetailDepartment extends Department implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AddressID", referencedColumnName = "AddressID")
    private Address address;

    @Column(name = "EmulationPoint")
    private short emulationPoint; // TINYINT UNSIGNED

}
