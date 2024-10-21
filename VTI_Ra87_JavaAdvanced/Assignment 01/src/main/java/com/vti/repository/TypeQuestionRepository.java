package com.vti.repository;

import com.vti.entity.Department;
import com.vti.entity.TypeQuestion;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TypeQuestionRepository {

	private HibernateUtils hibernateUtils;

	public TypeQuestionRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	// method để tạo mới 1 đối tượng vào bảng TypeQuestion
	public void createTypeQuestion(TypeQuestion typeQuestion) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// create
			session.save(typeQuestion);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// method để lấy thông tin toàn bộ đối tượng thuộc bảng Department
	public List<Department> getAllDepartments() {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// create hql query
			Query<Department> query = session.createQuery("FROM Department");
			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// method để lấy thông tin đối tượng thuộc bảng Department theo ID
	public Department getDepartmentByID(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// get department by id
			Department department = session.get(Department.class, id);
			return department;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// method để lấy thông tin toàn đối tượng thuộc bảng Department theo Name
	public Department getDepartmentByName(String name) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// create hql query
			Query<Department> query = session.createQuery("FROM Department WHERE name = :nameParameter");
			// set parameter
			query.setParameter("nameParameter", name);
			// get result
			Department department = query.uniqueResult();
			return department;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// method để update thông tin đối tượng thuộc bảng Department - Cách 1
	public void updateDepartment(short id, String newName) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// get department
			Department department = (Department) session.load(Department.class, id);
			// update
			department.setName(newName);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// method để update thông tin đối tượng thuộc bảng Department - Cách 2
	public void updateDepartment(Department department) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// update
			session.update(department);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// method để delete thông tin đối tượng thuộc bảng Department, tìm theo ID
	public void deleteDepartment(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// get department
			Department department = (Department) session.load(Department.class, id);
			// delete
			session.delete(department);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// method để kiểm tra và lấy thông tin đối tượng thuộc bảng Department, tìm theo ID
	public boolean isDepartmentExistsByID(short id) {
		// get department
		Department department = getDepartmentByID(id);
		// return result
		if (department == null) {
			return false;
		}
		return true;
	}

	// method để kiểm tra và lấy thông tin đối tượng thuộc bảng Department, tìm theo Name
	public boolean isDepartmentExistsByName(String name) {
		Department department = getDepartmentByName(name);
		if (department == null) {
			return false;
		}
		return true;
	}

}
