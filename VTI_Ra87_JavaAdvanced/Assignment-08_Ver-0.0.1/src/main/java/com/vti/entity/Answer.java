package com.vti.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * Class quản lý các Annotation
 * Khai báo các ánh xạ tới bảng Answer của DB
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "Answer")

public class Answer implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "Answers")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT PRIMARY KEY
    private short id; //TINYINT UNSIGNED

    @Column(name = "Content", length = 100, nullable = false)
    private String content; // NVARCHAR(100) NOT NULL

    @ManyToOne // multiple Answers to 1 Question
    @JoinColumn(name = "QuestionID", referencedColumnName = "QuestionID")
    @JsonBackReference("answers")
    private Question question;

    @Column(name = "isCorrect")
    private boolean isCorrect; // BIT DEFAULT 1

}
