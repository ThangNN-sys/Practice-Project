package com.vti.entity;

import com.vti.entity.enumerate.PositionName;
import com.vti.entity.enumerate.PositionNameConvert;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * Class quản lý các Annotation
 * Khai báo các ánh xạ tới bảng Position của DB
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "Position")
public class Position implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "PositionID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id; // maps to TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY

    @Column(name = "PositionName", nullable = false, unique = true)
    @Convert(converter = PositionNameConvert.class)
    private PositionName name; // maps to ENUM('Dev','Test','ScrumMaster','PM') NOT NULL UNIQUE KEY

    @OneToMany(mappedBy = "position")
    private List<Account> accounts;

}
