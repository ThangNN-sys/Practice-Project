package com.vti.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Question")

public class Question implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "QuestionID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short questionID;

    @Column(name = "Content", length = 100, nullable = false)
    private String content;

    @ManyToOne // multiple questions to 1 category
    @JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID", nullable = false)
    @JsonIgnoreProperties("questions")
    private CategoryQuestion category;

    @ManyToOne // multiple questions to 1 type
    @JoinColumn(name = "TypeID", referencedColumnName = "TypeID", nullable = false)
    @JsonIgnoreProperties("questions")
    private TypeQuestion type;

    @ManyToOne // multiple questions to 1 account
    @JoinColumn(name = "CreatorID", referencedColumnName = "AccountID", nullable = false)
    @JsonIgnoreProperties("questions")
    private Account creator;

    @OneToMany(mappedBy = "question") // 1 Question to multiple Answers, Answer is owning side
    @JsonManagedReference("answers")
    private List<Answer> answers;

    @Column(name = "CreateDate", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    public short getQuestionID() {
        return questionID;
    }

    public void setQuestionID(short questionID) {
        this.questionID = questionID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CategoryQuestion getCategory() {
        return category;
    }

    public void setCategory(CategoryQuestion category) {
        this.category = category;
    }

    public TypeQuestion getType() {
        return type;
    }

    public void setType(TypeQuestion type) {
        this.type = type;
    }

    public Account getCreator() {
        return creator;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionID=" + questionID +
                ", content='" + content + '\'' +
                ", category=" + category +
                ", type=" + type +
                ", creator=" + creator +
                ", createDate=" + createDate +
                '}';
    }
}
