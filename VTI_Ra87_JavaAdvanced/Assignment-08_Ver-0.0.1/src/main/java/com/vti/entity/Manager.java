package com.vti.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Manager")
public class Manager implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "AccountID", nullable = false)
    private short id; // TINYINT UNSIGNED

    @Column(name = "ManagementNumberOfYear", nullable = false)
    private short managementNumberOfYear; // TINYINT UNSIGNED

    @OneToOne
    @JoinColumn(name = "AccountID", referencedColumnName = "AccountID", nullable = false)
    private Account account;

}
