package com.vti.repository;

import com.vti.entity.Account;
import com.vti.entity.Employee;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Class quản lý các phương thức
 * Dùng để khai báo phương thức xử lý thông tin bảng Employee trên DB
 */

public class EmployeeRepository {

	private HibernateUtils hibernateUtils;

	public EmployeeRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	/**
	 * 1. Phương thức để tạo mới 1 đối tượng vào bảng Employee
	 */
	public void createEmployee(Employee employee) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(employee);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// Phương thức để tìm Account theo ID
	public Account findAccountById(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			Query<Account> query = session.createQuery("FROM Account WHERE accountId = :id", Account.class);
			query.setParameter("id", id);
			return query.uniqueResult();
		} finally {
			session.close();
		}
	}

	/**
	 * 2 - Method để lấy thông tin toàn bộ đối tượng thuộc bảng Employee
	 */
	public List<Employee> getAllEmployees() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Employee> query = session.createQuery("FROM Employee");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

//	public void createAccount(Employee employee) {
//
//		Session session = null;
//
//		try {
//
//			// get session
//			session = hibernateUtils.openSession();
//			session.beginTransaction();
//
//			// create
//			session.save(employee);
//
//			session.getTransaction().commit();
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//	}
}
