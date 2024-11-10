package com.vti.repository;

import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Class quản lý các phương thức
 * Dùng để khai báo phương thức xử lý thông tin bảng Department trên DB
 */

public class DepartmentRepository {

	private HibernateUtils hibernateUtils;

	public DepartmentRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	/**
	 * 1. Phương thức khởi tạo mới 1 phòng ban và lưu vào DB
     */
	public void createDepartment(Department department) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(department);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 2. Phương thức lấy thông tin toàn bộ phòng ban đang có trên DB
	 */
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

	/**
	 * 3. Phương thức lấy thông tin 1 phòng ban đang có trên DB theo ID
	 */
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

	/**
	 * 4. Phương thức lấy thông tin 1 phòng ban đang có trên DB theo tên
	 */
	public Department getDepartmentByName(String name) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Department> query = session.createQuery("FROM Department WHERE departmentName = :nameParameter");

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

	/**
	 * 5. Phương thức cập nhật thông tin 1 phòng ban đang có trên DB tìm theo ID
	 */
	public void updateDepartment(short id, String newName) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Department department = (Department) session.load(Department.class, id);

			// update
			department.setDepartmentName(newName);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

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

	/**
	 * 6. Phương thức xóa 1 phòng ban đang có trên DB tìm theo ID
	 */
	public void deleteDepartment(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Department department = session.load(Department.class, id);

			// delete
			session.delete(department);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isDepartmentExistsByID(short id) {

		// get department
		Department department = getDepartmentByID(id);

		// return result
		if (department == null) {
			return false;
		}

		return true;
	}

	public boolean isDepartmentExistsByName(String name) {
		Department department = getDepartmentByName(name);

		if (department == null) {
			return false;
		}
		return true;
	}

}
