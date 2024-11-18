package com.vti.repository;

import com.vti.entity.Exam;
import com.vti.entity.ExamQuestion;
import com.vti.entity.Question;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ExamQuestionRepository {

    private final HibernateUtils hibernateUtils;

    public ExamQuestionRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    /**
     * 1. Phương thức để tạo mới 1 đối tượng vào bảng ExamQuestion
     */
    public void createExamQuestion(ExamQuestion examQuestion) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // create
            session.save(examQuestion);

            session.getTransaction().commit();

        } catch (Exception e) {

            // check if any session are open, abort transaction to ensure data consistency
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

	// Phương thức để tìm Exam theo ID
	public Exam findExamById(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query get Department by id
			Query<Exam> query = session.createQuery("FROM Exam WHERE ExamID = :id", Exam.class);
			query.setParameter("id", id);

			// get result (same with inline variable: return query.uniqueResult();)
			Exam exam = session.get(Exam.class, id);
			return exam;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// Phương thức để tìm Question theo ID
	public Question findQuestionById(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query get Department by id
			Query<Question> query = session.createQuery("FROM Question WHERE QuestionID = :id", Question.class);
			query.setParameter("id", id);

			// get result (same with inline variable: return query.uniqueResult();)
			Question question = session.get(Question.class, id);
			return question;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 2. Phương thức để lấy thông tin toàn bộ đối tượng từ bảng ExamQuestion
	 */
    public List<ExamQuestion> getAllExamQuestions() {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<ExamQuestion> query = session.createQuery("FROM ExamQuestion");

            return query.list();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

	/**
	 * 3. Phương thức để lấy thông tin đối tượng thuộc bảng ExamQuestion theo ExamID
	 */
	public Exam getExamQuestionByExamID(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// get ExamQuestion by id
			Exam exam = session.get(Exam.class, id);
			return exam;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
