package com.vti.repository;

import com.vti.entity.CategoryQuestion;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Class quản lý các phương thức
 * Dùng để khai báo phương thức xử lý thông tin bảng CategoryQuestion trên DB
 */

public class CategoryQuestionRepository {

	private HibernateUtils hibernateUtils;

	public CategoryQuestionRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	/**
	 * 1. Phương thức để tạo mới 1 đối tượng vào bảng CategoryQuestion
	 */
	public void createCategoryQuestion(CategoryQuestion categoryQuestion) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(categoryQuestion);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 2. Phương thức để lấy thông tin toàn bộ đối tượng thuộc bảng CategoryQuestion
	 */
	public List<CategoryQuestion> getAllCategoryQuestions() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<CategoryQuestion> query = session.createQuery("FROM CategoryQuestion");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 3. Phương thức để lấy thông tin đối tượng thuộc bảng CategoryQuestion theo ID
	 */
	public CategoryQuestion getCategoryQuestionByID(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// get by id
			CategoryQuestion categoryQuestion = session.get(CategoryQuestion.class, id);
			return categoryQuestion;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 4. Phương thức để update thông tin đối tượng thuộc bảng CategoryQuestion
	 */
	public void updateCategoryQuestion(short id, String categoryQuestionName) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// get CategoryQuestion
			CategoryQuestion categoryQuestion = session.load(CategoryQuestion.class, id);
			// update
			categoryQuestion.setCategoryName(categoryQuestionName);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 5. Phương thức để delete thông tin đối tượng thuộc bảng CategoryQuestion, tìm theo ID
	 */
	public void deleteCategoryQuestion(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// get CategoryQuestion
			CategoryQuestion categoryQuestion = session.load(CategoryQuestion.class, id);
			// delete
			session.delete(categoryQuestion);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
