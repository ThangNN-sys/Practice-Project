package com.vti.entity;

import com.vti.entity.primarykey.GroupAccountKey;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * Class quản lý các Annotation
 * Khai báo các ánh xạ tới bảng GroupAccount của DB
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "GroupAccount")
public class GroupAccount implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private GroupAccountKey id;

    @ManyToOne
    @MapsId("groupId")
    @JoinColumn(name = "groupId")
    private Group group;

    @ManyToOne
    @MapsId("accountId")
    @JoinColumn(name = "accountId")
    private Account account;

    @Column(name = "JoinDate", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date joinDate;

}
