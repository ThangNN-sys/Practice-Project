package com.vti.repository;

import java.util.List;

import com.vti.entity.Account;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;



public class AccountRepository {

	private HibernateUtils hibernateUtils;

	public AccountRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	// method để tạo mới 1 đối tượng vào bảng Account
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

	// method để lấy thông tin toàn bộ đối tượng thuộc bảng Account
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

	// method để lấy thông tin toàn đối tượng thuộc bảng Account theo ID
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

	// method để lấy thông tin toàn đối tượng thuộc bảng Account theo username
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
}
