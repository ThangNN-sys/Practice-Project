package com.vti.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serial;
import java.io.Serializable;

/**
 * Class quản lý các Annotation
 * Dùng để khai báo các ánh xạ tới bảng Exam của DB
 */

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
    private short examId;

    @Column(name = "Duration", nullable = false)
    private int duration;

    public short getExamId() {
        return examId;
    }

    public void setExamId(short examId) {
        this.examId = examId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
