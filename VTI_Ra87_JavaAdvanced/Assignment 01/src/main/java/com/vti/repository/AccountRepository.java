package com.vti.repository;

import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;



public class AccountRepository {

	private HibernateUtils hibernateUtils;

	public AccountRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

// 1 - Method để tạo mới 1 đối tượng vào bảng Account
	public void createAccount(Account account) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// create
			session.save(account);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

// 2 - Method để lấy thông tin toàn bộ đối tượng thuộc bảng Account
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

// 3 - Method để lấy thông tin đối tượng thuộc bảng Account theo ID
	public Account getAccountByID(short id) {
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

// 4 - method để lấy thông tin đối tượng thuộc bảng Account theo username
	public Account getAccountByUserName(String name) {
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

// 5 - method để lấy thông tin toàn đối tượng thuộc bảng Account theo firstname
	public Account getAccountByFirstName(String name) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// create hql query
			Query<Account> query = session.createQuery("FROM Account WHERE firstName = :nameParameter");
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
// 6 - method để lấy thông tin toàn đối tượng thuộc bảng Account theo lastname
	public Account getAccountByLastName(String name) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// create hql query
			Query<Account> query = session.createQuery("FROM Account WHERE lastName = :nameParameter");
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
// 7 - method để update thông tin đối tượng thuộc bảng Account - Cách 1
	public void updateAccount(short id, String firstName, String lastName) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// get account
			Account account = (Account) session.load(Account.class, id);
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

// 8 - method để update thông tin đối tượng thuộc bảng Account - Cách 2
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

// 9 - method để delete thông tin đối tượng thuộc bảng Account, tìm theo ID
	public void deleteAccount(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// get account
			Account account = (Account) session.load(Account.class, id);
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
