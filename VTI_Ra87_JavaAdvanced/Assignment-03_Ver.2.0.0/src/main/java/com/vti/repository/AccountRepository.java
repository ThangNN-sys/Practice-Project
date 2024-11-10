package com.vti.repository;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.entity.Salary;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Class quản lý các phương thức
 * Dùng để khai báo phương thức xử lý thông tin bảng Account trên DB
 */

public class AccountRepository {

	private HibernateUtils hibernateUtils;

	public AccountRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	/**
	 * 1. Phương thức để tạo mới 1 đối tượng vào bảng Account
	 */
	public void createAccount(Account Account) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(Account);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// Phương thức để tìm Department theo ID
	public Department findDepartmentById(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			Query<Department> query = session.createQuery("FROM Department WHERE departmentId = :id", Department.class);
			query.setParameter("id", id);
			return query.uniqueResult();
		} finally {
			session.close();
		}
	}

	// Phương thức để tìm Position theo ID
	public Position findPositionById(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			Query<Position> query = session.createQuery("FROM Position WHERE positionId = :id", Position.class);
			query.setParameter("id", id);
			return query.uniqueResult();
		} finally {
			session.close();
		}
	}

	// Phương thức để tìm Salary theo ID
	public Salary findSalaryById(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			Query<Salary> query = session.createQuery("FROM Salary WHERE salaryId = :id", Salary.class);
			query.setParameter("id", id);
			return query.uniqueResult();
		} finally {
			session.close();
		}
	}

	/**
	 * 2 - Method để lấy thông tin toàn bộ đối tượng thuộc bảng Account
	 */
	public List<Account> getAllAccounts() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Account> query = session.createQuery("FROM Account");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	/**
	 * 3 - Method để lấy thông tin đối tượng thuộc bảng Account theo ID
	 */
	public Account getAccByID(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// get Account by id
			Account account = session.get(Account.class, id);
			return account;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 *  4 - method để lấy thông tin đối tượng thuộc bảng Account theo username
	 */
	public Account getAccByUserName(String name) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// create hql query
			Query<Account> query = session.createQuery("FROM Account WHERE username = :nameParameter");
			// set parameter
			query.setParameter("nameParameter", name);
			// get result
			Account account = query.uniqueResult();
			return account;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 5 - method để lấy thông tin toàn đối tượng thuộc bảng Account theo firstname
	 * @return accounts
	 */
	public List<Account> getAccByFirstName(String name) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// create hql query
			Query<Account> query = session.createQuery("FROM Account WHERE firstName = :nameParameter");
			// set parameter
			query.setParameter("nameParameter", name);
			// get result list
			List<Account> accounts = query.list();
			if (accounts.isEmpty()) {
				return null;
			}
			return accounts;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 6 - Method để lấy thông tin toàn đối tượng thuộc bảng Account theo lastname nhiều kết quả
	 * @return accounts
	 */
	public List<Account> getAccByLastName(String name) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// create hql query
			Query<Account> query = session.createQuery("FROM Account WHERE lastName = :nameParameter");
			// set parameter
			query.setParameter("nameParameter", name);
			// get result list
			List<Account> accounts = query.list();
			if (accounts.isEmpty()) {
				return null;
			}
			return accounts;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 7 - method để update thông tin đối tượng thuộc bảng Account - Cách 1
	 */
	public void updateAccount(short id, String firstName, String lastName) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// get account
			Account account = session.load(Account.class, id);
			// update
			account.setFirstName(firstName);
			account.setLastName(lastName);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 8 - method để update thông tin đối tượng thuộc bảng Account - Cách 2
	 * @param account
	 */
	public void updateAccount(Account account) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// update
			session.update(account);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 9 - Method để delete thông tin đối tượng thuộc bảng Account, tìm theo ID
	 * @param id
	 */
	public void deleteAccount(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// get account
			Account account = session.load(Account.class, id);
			// delete
			session.delete(account);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
