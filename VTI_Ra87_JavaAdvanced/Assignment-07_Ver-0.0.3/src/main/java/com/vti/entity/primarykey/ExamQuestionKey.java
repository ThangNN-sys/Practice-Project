package com.vti.entity.primarykey;

import jakarta.persistence.Column;

import java.io.Serial;
import java.io.Serializable;

public class ExamQuestionKey implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "ExamID")
    private short examId;

    @Column(name = "QuestionID")
    private short questionId;

    public ExamQuestionKey() {
    }

    public short getExamId() {
        return examId;
    }

    public void setExamId(short examId) {
        this.examId = examId;
    }

    public short getQuestionId() {
        return questionId;
    }

    public void setQuestionId(short questionId) {
        this.questionId = questionId;
    }
}
