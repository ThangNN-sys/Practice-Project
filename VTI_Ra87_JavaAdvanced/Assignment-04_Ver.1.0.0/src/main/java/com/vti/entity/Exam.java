package com.vti.entity;

import com.vti.repository.ExamRepository;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Class quản lý các Annotation
 * Dùng để khai báo các ánh xạ tới bảng Exam của DB
 */

@Entity
@Table(name = "Exam", catalog = "TestingSystem")
public class Exam implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "ExamID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "`Code`", length = 10)
	private String code; // Maps to CHAR(10) NOT NULL

	@Column(name = "Title", length = 50, nullable = false)
	private String title;

	@Column(name = "Duration", nullable = false, columnDefinition = "tinyint default 45")
	private short duration;

	@Column(name = "CreateDate")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;

	@PrePersist
	public void beforeSaveToDatabase() {

		if (code == null) {
			ExamRepository repository = new ExamRepository();

			String prefix;

			if (duration >= 180) {
				prefix = "L";
			} else if (duration >= 90) {
				prefix = "M";
			} else {
				prefix = "S";
			}

			int count = repository.getCountOfExamCode(duration);

			code = prefix + "-" + (count + 1);
		}
	}

	public Exam() {
	}

//	public short getId() {
//		return id;
//	}
//
//	public void setId(short id) {
//		this.id = id;
//	}


	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public short getDuration() {
		return duration;
	}

	public void setDuration(short duration) {
		this.duration = duration;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Exam{" +
				"id=" + id +
				", code='" + code + '\'' +
				", title='" + title + '\'' +
				", duration=" + duration +
				", createDate=" + createDate +
				'}';
	}
}
