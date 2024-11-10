package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Class quản lý các Annotation
 * Dùng để khai báo các ánh xạ tới bảng Answer của DB
 */

@Entity
@Table(name = "Answer", catalog = "TestingSystem")
@Inheritance(strategy = InheritanceType.JOINED)
public class Answer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "Answers")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short answerId; // Maps to TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY

	@Column(name = "Content", length = 100, nullable = false)
	private String content; // Maps to NVARCHAR(100) NOT NULL

	@OneToOne
	@JoinColumn(name = "QuestionID", nullable = false)
	private Question question;

	@Column(name = "isCorrect", nullable = false)
	private Boolean isCorrect = true;  // Maps to BIT DEFAULT 1

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

	public Boolean getCorrect() {
		return isCorrect;
	}

	public void setCorrect(Boolean correct) {
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
