package com.vti.entity;

import com.vti.entity.primarykey.ExamQuestionKey;

import javax.persistence.*;

/**
 * Class quản lý các Annotation
 * Dùng để khai báo các ánh xạ tới bảng ExamQuestion của DB
 */

@Entity
@Table(name = "ExamQuestion")
public class ExamQuestion {

	@EmbeddedId
	private ExamQuestionKey id;

	@ManyToOne
	@MapsId("ExamID")
	@JoinColumn(name = "ExamID")
	private Exam exam;

	@ManyToOne
	@MapsId("QuestionID")
	@JoinColumn(name = "QuestionID")
	private Question question;

	public ExamQuestion() {
	}

	public ExamQuestionKey getId() {
		return id;
	}

	public void setId(ExamQuestionKey id) {
		this.id = id;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
}
