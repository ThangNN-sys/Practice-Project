package com.vti.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TypeQuestion")
public class TypeQuestion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "TypeID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "TypeName", length = 50, nullable = false, unique = true, updatable = false)
    private String typeName;

    public TypeQuestion() {
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "TypeQuestion{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
