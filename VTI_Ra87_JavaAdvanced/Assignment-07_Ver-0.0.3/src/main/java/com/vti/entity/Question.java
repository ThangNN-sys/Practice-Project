package com.vti.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Class quản lý các Annotation
 * Khai báo các ánh xạ tới bảng Question của DB
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "Question")

public class Question implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "QuestionID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

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

}
