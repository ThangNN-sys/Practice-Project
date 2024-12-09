package com.vti.entity;

import com.vti.entity.primarykey.ExamQuestionKey;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * Class quản lý các Annotation
 * Dùng để khai báo các ánh xạ tới bảng ExamQuestion của DB
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "ExamQuestion")
public class ExamQuestion implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ExamQuestionKey id;

    @ManyToOne
    @MapsId("examId")
    @JoinColumn(name = "ExamID")
    private Exam exam;

    @ManyToOne
    @MapsId("questionId")
    @JoinColumn(name = "QuestionID")
    private Question question;

}
