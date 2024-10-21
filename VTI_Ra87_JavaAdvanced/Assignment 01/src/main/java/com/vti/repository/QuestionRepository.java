package com.vti.repository;

import com.vti.entity.Department;
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

	// method để tạo mới 1 đối tượng vào bảng Question
	public void createQuestion(Question question) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// create
			session.save(question);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// method để lấy thông tin toàn bộ đối tượng thuộc bảng Question
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

	// method để lấy thông tin đối tượng thuộc bảng Question theo ID
	public Question getQuestionByID(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// get department by id
			Question question = session.get(Question.class, id);
			return question;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// method để lấy thông tin toàn đối tượng thuộc bảng Question theo Name
	public Question getQuestionByName(String name) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// create hql query
			Query<Question> query = session.createQuery("FROM Question WHERE name = :nameParameter");
			// set parameter
			query.setParameter("nameParameter", name);
			// get result
			Question question = query.uniqueResult();
			return question;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// method để update thông tin đối tượng thuộc bảng Question - Cách 1
	public void updateQuestion(short id, String newName) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// get department
			Question question = (Question) session.load(Question.class, id);
			// update
			question.setContent(newName);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// method để update thông tin đối tượng thuộc bảng Question - Cách 2
	public void updateQuestion(Question question) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// update
			session.update(question);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// method để delete thông tin đối tượng thuộc bảng Question, tìm theo ID
	public void deleteQuestion(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// get Question
			Question question = (Question) session.load(Question.class, id);
			// delete
			session.delete(question);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// method để kiểm tra và lấy thông tin đối tượng thuộc bảng Question, tìm theo ID
	public boolean isQuestionExistsByID(short id) {
		// get Question
		Question question = getQuestionByID(id);
		// return result
		if (question == null) {
			return false;
		}
		return true;
	}

	// method để kiểm tra và lấy thông tin đối tượng thuộc bảng Question, tìm theo Name
//	public boolean isQuestionExistsByName(String name) {
//		Department department = getDepartmentByName(name);
//		if (department == null) {
//			return false;
//		}
//		return true;
//	}

}
