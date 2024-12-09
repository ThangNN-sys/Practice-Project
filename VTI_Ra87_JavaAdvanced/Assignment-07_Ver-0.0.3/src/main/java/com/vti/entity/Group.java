package com.vti.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Class quản lý các Annotation
 * Khai báo các ánh xạ tới bảng Group của DB
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "`Group`")
public class Group implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "GroupID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id; // maps to TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY

    @Column(name = "GroupName", length = 50, nullable = false, unique = true)
    private String name; // maps to NVARCHAR(50) NOT NULL UNIQUE KEY

    @ManyToOne
    @JoinColumn(name = "CreatorID", referencedColumnName = "AccountID", updatable = false)
    private Account creator; // maps to TINYINT UNSIGNED NOT NULL cannot update

    @Column(name = "CreateDate", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate; // maps to DATETIME DEFAULT

    @OneToMany(mappedBy = "group")
    private List<GroupAccount> groupAccounts;

}
