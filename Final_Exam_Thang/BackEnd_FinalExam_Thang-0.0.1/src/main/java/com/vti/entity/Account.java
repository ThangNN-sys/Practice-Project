package com.vti.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.Serializable;

@Entity
@Table(name = "`Account`")
@Data
@NoArgsConstructor
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", length = 50, nullable = false, unique = true, updatable = false)
    private String username;

    @Column(name = "`password`", length = 50, nullable = false)
    private String password;

    @Column(name = "first_name", length = 50, nullable = false, updatable = false)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false, updatable = false)
    private String lastName;

    @Formula(" concat(first_name, ' ', last_name)")
    private String fullName;

    @Column(name = "`role`")
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @PrePersist
    public void prePersist() {
        if (role == null) {
            role = Role.EMPLOYEE;
        }

        if (password == null) {
            password = new BCryptPasswordEncoder().encode("123456");
        }
    }

    public enum Role {
        ADMIN, EMPLOYEE, MANAGER;
    }

}
