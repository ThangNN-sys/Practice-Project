package com.vti.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * Class quản lý các Annotation
 * Khai báo các ánh xạ tới bảng Employee của DB
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "AccountID", nullable = false)
    private short accountId; // TINYINT UNSIGNED

    @Column(name = "WorkingNumberOfYear", nullable = false)
    private short workingNumberOfYear; // TINYINT UNSIGNED

    @OneToOne
    @JoinColumn(name = "AccountID", referencedColumnName = "AccountID", nullable = false)
    private Account account;

}
