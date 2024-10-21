package com.vti.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "answer")
public class Answer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "Answers")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "Content", length = 100, nullable = false)
	private String content;

	@Column(name = "isCorrect", nullable = false)
	private Boolean isCorrect = true;  // Maps to BIT, default value is 1 (true)

	public Answer() {}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
				"id=" + id +
				", content='" + content + '\'' +
				", isCorrect=" + isCorrect +
				'}';
	}
}
