package com.vti.repository;

import com.vti.entity.Answer;
import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AnswerRepository {

	private HibernateUtils hibernateUtils;

	public AnswerRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	// method để tạo mới 1 đối tượng vào bảng Answer
	public void createAnswer(Answer answer) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// create
			session.save(answer);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// method để lấy thông tin toàn bộ đối tượng thuộc bảng Answer
	public List<Answer> getAllAnswers() {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// create hql query
			Query<Answer> query = session.createQuery("FROM Answer");
			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// method để lấy thông tin đối tượng thuộc bảng Answer theo ID
	public Answer getAnswerByID(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// get department by id
			Answer answer = session.get(Answer.class, id);
			return answer;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
