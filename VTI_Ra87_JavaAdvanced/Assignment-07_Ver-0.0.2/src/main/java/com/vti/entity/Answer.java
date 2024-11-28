package com.vti.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "Answer")

public class Answer implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "Answers")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT PRIMARY KEY
    private short answerId; //TINYINT UNSIGNED

    @Column(name = "Content", length = 100, nullable = false)
    private String content; // NVARCHAR(100) NOT NULL

    @ManyToOne // multiple Answers to 1 Question
    @JoinColumn(name = "QuestionID", referencedColumnName = "QuestionID")
    @JsonBackReference("answers")
    private Question question;

    @Column(name = "isCorrect")
    private boolean isCorrect; // BIT DEFAULT 1

    public Answer() {
    }

    public short getAnswerId() {
        return answerId;
    }

    public void setAnswerId(short answerId) {
        this.answerId = answerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", content='" + content + '\'' +
                ", question=" + question +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
