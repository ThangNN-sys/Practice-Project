package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CategoryQuestion")
public class CategoryQuestion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "CategoryID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "CategoryName", length = 50, nullable = false, unique = true, updatable = false)
    private String name;

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

    public void setName(String categoryName) {
        this.name = categoryName;
    }

    @Override
    public String toString() {
        return "CategoryQuestion{" +
                "id=" + id +
                ", categoryName='" + name + '\'' +
                '}';
    }
}
