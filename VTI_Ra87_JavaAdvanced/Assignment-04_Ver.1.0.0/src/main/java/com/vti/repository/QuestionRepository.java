package com.vti.repository;

import com.vti.entity.Question;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class QuestionRepository {

	private HibernateUtils hibernateUtils;

	public QuestionRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Question> getAllQuestions() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Question> query = session.createQuery("FROM Question");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createQuestion(Question question) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(question);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
