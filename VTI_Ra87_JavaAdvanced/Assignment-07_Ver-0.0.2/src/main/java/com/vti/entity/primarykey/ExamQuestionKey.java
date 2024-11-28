package com.vti.entity.primarykey;

import jakarta.persistence.Column;

import java.io.Serial;
import java.io.Serializable;

public class ExamQuestionKey implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "ExamID")
    private short examID;

    @Column(name = "QuestionID")
    private short questionID;

    public ExamQuestionKey() {
    }

    public short getExamID() {
        return examID;
    }

    public void setExamID(short examID) {
        this.examID = examID;
    }

    public short getQuestionID() {
        return questionID;
    }

    public void setQuestionID(short questionID) {
        this.questionID = questionID;
    }
}
