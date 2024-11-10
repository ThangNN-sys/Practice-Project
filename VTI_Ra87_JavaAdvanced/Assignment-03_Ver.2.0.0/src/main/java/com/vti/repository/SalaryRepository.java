package com.vti.repository;

import com.vti.entity.Salary;
import com.vti.entity.enumerate.SalaryName;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Class quản lý các phương thức
 * Dùng để khai báo phương thức xử lý thông tin bảng Position trên DB
 */

public class SalaryRepository {

	private HibernateUtils hibernateUtils;

	public SalaryRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	/**
	 * 1. Phương thức để tạo mới 1 đối tượng vào bảng Salary
	 */
	public void createSalary(Salary salary) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(salary);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 2. Phương thức để lấy thông tin toàn bộ đối tượng thuộc bảng Salary
	 */
	public List<Salary> getAllSalaries() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Salary> query = session.createQuery("FROM Salary");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 3. Phương thức để lấy thông tin đối tượng thuộc bảng Salary theo ID
	 */
	public Salary getSalaryByID(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// get Salary by id
			Salary salary = session.get(Salary.class, id);
			return salary;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 4. Phương thức để update thông tin đối tượng thuộc bảng Salary
	 */
	public void updateSalary(short id, String salaryName) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// get Salary
			Salary salary = session.load(Salary.class, id);
			// update
			salary.setSalaryName(SalaryName.valueOf(salaryName));
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 5. Phương thức để delete thông tin đối tượng thuộc bảng Salary, tìm theo ID
	 */
	public void deleteSalary(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// get Salary
			Salary salary = session.load(Salary.class, id);
			// delete
			session.delete(salary);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
