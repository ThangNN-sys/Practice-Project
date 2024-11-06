package com.vti.repository;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AccountRepository {

	private HibernateUtils hibernateUtils;

	public AccountRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	/**
	 * 1 - Method để tạo mới 1 đối tượng vào bảng Account
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
	 * @param name
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

	/**
	 * 10 - Method để tạo mới 1 đối tượng vào bảng Account có kèm Department
	 */
	public void createAccountWithDep(Account Account) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(Account);

			// Tìm Department đã có trong database với ID cụ thể
			Long departmentId = 1L; // Giả sử department có ID là 1
			Department department = session.get(Department.class, departmentId);

			if (department != null) {
				// Tạo mới một Account và gán Department đã tìm thấy
				Account account = new Account("new_user", department);

				session.save(account);
				session.getTransaction().commit();
				System.out.println("Account created successfully with department!");
			} else {
				System.out.println("Department not found!");
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
