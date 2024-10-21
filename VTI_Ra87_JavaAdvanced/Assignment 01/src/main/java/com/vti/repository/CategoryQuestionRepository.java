package com.vti.repository;

import com.vti.entity.CategoryQuestion;
import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryQuestionRepository {

	private HibernateUtils hibernateUtils;

	public CategoryQuestionRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	// method để lấy thông tin toàn bộ đối tượng thuộc bảng CategoryQuestion
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

	// method để tạo mới 1 đối tượng vào bảng CategoryQuestion
	public void createCategoryQuestion(CategoryQuestion CategoryQuestion) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// create
			session.save(CategoryQuestion);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// method để lấy thông tin đối tượng thuộc bảng CategoryQuestion theo ID
	public CategoryQuestion getCategoryQuestionByID(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// get department by id
			CategoryQuestion categoryQuestion = session.get(CategoryQuestion.class, id);
			return categoryQuestion;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// method để lấy thông tin đối tượng thuộc bảng CategoryQuestion theo Name
	public CategoryQuestion getCategoryQuestionByName(String name) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// create hql query
			Query<CategoryQuestion> query = session.createQuery("FROM CategoryQuestion WHERE name = :nameParameter");
			// set parameter
			query.setParameter("nameParameter", name);
			// get result
			CategoryQuestion categoryQuestion = query.uniqueResult();
			return categoryQuestion;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// method để update thông tin đối tượng thuộc bảng CategoryQuestion - Cách 1
	public void updateCategoryQuestion(short id, String newName) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// get department
			CategoryQuestion categoryQuestion = (CategoryQuestion) session.load(CategoryQuestion.class, id);
			// update
			categoryQuestion.setCategoryName(newName);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// method để update thông tin đối tượng thuộc bảng CategoryQuestion - Cách 2
	public void updateCategoryQuestion(CategoryQuestion categoryQuestion) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// update
			session.update(categoryQuestion);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// method để delete thông tin đối tượng thuộc bảng CategoryQuestion, tìm theo ID
	public void deleteCategoryQuestion(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// get department
			CategoryQuestion categoryQuestion = (CategoryQuestion) session.load(CategoryQuestion.class, id);
			// delete
			session.delete(categoryQuestion);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// method để kiểm tra và lấy thông tin đối tượng thuộc bảng CategoryQuestion, tìm theo ID
	public boolean isCategoryQuestionExistsByID(short id) {
		// get CategoryQuestion
		CategoryQuestion categoryQuestion = getCategoryQuestionByID(id);
		// return result
		if (categoryQuestion == null) {
			return false;
		}
		return true;
	}

	// method để kiểm tra và lấy thông tin đối tượng thuộc bảng CategoryQuestion, tìm theo Name
	public boolean isCategoryQuestionExistsByName(String name) {
		CategoryQuestion categoryQuestion = getCategoryQuestionByName(name);
		if (categoryQuestion == null) {
			return false;
		}
		return true;
	}
}
