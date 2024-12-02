package com.vti.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * Class quản lý các Annotation
 * Khai báo các ánh xạ tới bảng CategoryQuestion của DB
 */

@Entity
@Table(name = "CategoryQuestion")

public class CategoryQuestion implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "CategoryID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT PRIMARY KEY
    private short id; // TINYINT UNSIGNED

    @Column(name = "CategoryName", length = 50, nullable = false, unique = true)
    private String name; // VARCHAR(50) NOT NULL UNIQUE KEY

    @OneToMany(mappedBy = "category") // 1 CategoryQuestion to multiple Question, Question is owning side
    @JsonManagedReference("category")
    private List<Question> questions;

    public CategoryQuestion() {
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryQuestion{" +
                "categoryId=" + id +
                ", categoryName='" + name + '\'' +
                '}';
    }
}
