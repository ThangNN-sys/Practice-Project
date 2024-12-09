package com.vti.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serial;
import java.io.Serializable;

/**
 * Class quản lý các Annotation
 * Dùng để khai báo các ánh xạ tới bảng Exam của DB
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "Exam")

public class Exam implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "ExamID")
    @Id
    @GeneratedValue(generator = "exam-code-generator")
    @GenericGenerator(
            name = "exam-code-generator",
            strategy = "com.vti.entity.generator.ExamCodeGenerator"
    )
    private short id;

    @Column(name = "Duration", nullable = false)
    private int duration;

}
