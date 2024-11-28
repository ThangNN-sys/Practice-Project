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
    private short typeId; // maps to TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY

    @Column(name = "TypeName", nullable = false, unique = true)
    @Convert(converter = TypeQuestionNameConvert.class)
    private TypeQuestionName typeName; // maps to ENUM('0','1') NOT NULL UNIQUE KEY

    @OneToMany(mappedBy = "type")
    @JsonIgnoreProperties("type")
    private List<Question> questionList;

    public TypeQuestion() {
    }

    public short getTypeId() {
        return typeId;
    }

    public void setTypeId(short typeId) {
        this.typeId = typeId;
    }

    public TypeQuestionName getTypeName() {
        return typeName;
    }

    public void setTypeName(TypeQuestionName typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "TypeQuestion{" +
                "typeId=" + typeId +
                ", typeName=" + typeName +
                '}';
    }
}
