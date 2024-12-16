package com.vti.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.TypeConverter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Department")
@Data
@NoArgsConstructor
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "`name`", length = 50, nullable = false, unique = true, updatable = false)
    private String name;

    @Column(name = "total_member")
    private int totalMember;

    @Column(name = "`type`", nullable = false)
    @Convert(converter = TypeConverter.class)
    private Type type;

    @Column(name = "created_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdDate;

    @OneToMany(mappedBy = "department")
    private List<Account> accounts;

    @Getter
    public enum Type {
        DEV("Dev"), TEST("Test"), SCRUM_MASTER("ScrumMaster"), PM("PM");

        private String value;

        private Type(String value) {
            this.value = value;
        }

        public static Type toEnum(String sqlValue) {
            for (Type type : Type.values()) {
                if (type.getValue().equals(sqlValue)) {
                    return type;
                }
            }
            return null;
        }

    }
}
