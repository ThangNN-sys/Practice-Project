package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Class quản lý các Annotation
 * Dùng để khai báo các ánh xạ tới bảng Question của DB
 */

@Entity
@Table(name = "Question", catalog = "TestingSystem")
@Inheritance(strategy = InheritanceType.JOINED)
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "QuestionID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short questionId; // Maps to TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY

	@Column(name = "Content", length = 100, nullable = false)
	private String content; // Maps to NVARCHAR(100) NOT NULL

	@ManyToOne
	@JoinColumn(name = "CategoryID", nullable = false)
	private CategoryQuestion categoryQuestion;

	@ManyToOne
	@JoinColumn(name = "TypeID", nullable = false)
	private TypeQuestion typeQuestion;

	@ManyToOne
	@JoinColumn(name = "CreatorID", nullable = false)
	private Account creator;

	@Column(name = "CreateDate")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;

//	@OneToMany(mappedBy = "creator")
//	private List<Group> createdGroup;
//
//	@OneToMany(mappedBy = "account")
//	private List<GroupAccount> groups;

	public Question() {
	}

	public short getQuestionId() {
		return questionId;
	}

	public void setQuestionId(short questionId) {
		this.questionId = questionId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public CategoryQuestion getCategoryQuestion() {
		return categoryQuestion;
	}

	public void setCategoryQuestion(CategoryQuestion categoryQuestion) {
		this.categoryQuestion = categoryQuestion;
	}

	public TypeQuestion getTypeQuestion() {
		return typeQuestion;
	}

	public void setTypeQuestion(TypeQuestion typeQuestion) {
		this.typeQuestion = typeQuestion;
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
				"questionId=" + questionId +
				", content='" + content + '\'' +
				", categoryQuestion=" + categoryQuestion +
				", typeQuestion=" + typeQuestion +
				", creator=" + creator +
				", createDate=" + createDate +
				'}';
	}
}
