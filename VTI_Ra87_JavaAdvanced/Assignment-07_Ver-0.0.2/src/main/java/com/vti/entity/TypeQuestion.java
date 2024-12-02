package com.vti.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vti.entity.enumerate.TypeQuestionName;
import com.vti.entity.enumerate.TypeQuestionNameConvert;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * Class quản lý các Annotation
 * Khai báo các ánh xạ tới bảng TypeQuestion của DB
 */

@Entity
@Table(name = "TypeQuestion")
public class TypeQuestion implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "TypeID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id; // maps to TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY

    @Column(name = "TypeName", nullable = false, unique = true)
    @Convert(converter = TypeQuestionNameConvert.class)
    private TypeQuestionName name; // maps to ENUM('0','1') NOT NULL UNIQUE KEY

    @OneToMany(mappedBy = "type")
    @JsonIgnoreProperties("type")
    private List<Question> questionList;

    public TypeQuestion() {
    }

    public short getId() {
        return id;
    }

    public void setId(short typeId) {
        this.id = typeId;
    }

    public TypeQuestionName getName() {
        return name;
    }

    public void setName(TypeQuestionName typeName) {
        this.name = typeName;
    }

    @Override
    public String toString() {
        return "TypeQuestion{" +
                "typeId=" + id +
                ", typeName=" + name +
                '}';
    }
}
