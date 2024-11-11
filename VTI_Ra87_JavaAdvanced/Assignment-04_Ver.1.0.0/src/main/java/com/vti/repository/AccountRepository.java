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
 * Class quản lý các phương thức CRUD
 * Dùng để xử lý thông tin bảng Account
 */

public class AccountRepository {

    private final HibernateUtils hibernateUtils;

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

        } catch (Exception e) {

			// check if any session are open, abort transaction to ensure data consistency
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }

        } finally {

			// ensures that the session will be closed even if an error occurs
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

			// create hql query get Department by id
            Query<Department> query = session.createQuery("FROM Department WHERE departmentId = :id", Department.class);
            query.setParameter("id", id);

			// get result (same with inline variable: return query.uniqueResult();)
			Department department = session.get(Department.class, id);
			return department;

        } finally {
			if (session != null) {
				session.close();
			}
        }
    }

    // Phương thức để tìm Position theo ID
    public Position findPositionById(short id) {
        Session session = null;
        try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query get Position by ID
			Query<Position> query = session.createQuery("FROM Position WHERE positionId = :id", Position.class);
			query.setParameter("id", id);

			// get result (same with inline variable: return query.uniqueResult();)
			Position position = session.get(Position.class, id);
			return position;

        } finally {
			if (session != null) {
				session.close();
			}
        }
    }

    // Phương thức để tìm Salary theo ID
    public Salary findSalaryById(short id) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

			// create hql query get Salary by ID
            Query<Salary> query = session.createQuery("FROM Salary WHERE salaryId = :id", Salary.class);
            query.setParameter("id", id);

			// get result (same with inline variable: return query.uniqueResult();)
			Salary salary = session.get(Salary.class, id);
			return salary;

        } finally {
			if (session != null) {
				session.close();
			}
        }
    }

    /**
     * 2. Phương thức để lấy thông tin toàn bộ đối tượng từ bảng Account
     */
    public List<Account> getAllAccounts() {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
			session.beginTransaction();

            // create hql query get all Account
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
     * 4 - method để lấy thông tin đối tượng thuộc bảng Account theo username
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
            // get result (same with inline variable: return query.uniqueResult();)
            Account account = query.uniqueResult();
            return account;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * 5. Phương thức để lấy thông tin toàn đối tượng thuộc bảng Account theo firstname
     * @return accountList
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
            List<Account> accountList = query.list();
            if (accountList.isEmpty()) {
                return null;
            }
            return accountList;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * 6. Phương thức để lấy thông tin toàn đối tượng thuộc bảng Account theo lastname
	 * @return accountList
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
            List<Account> accountList = query.list();
            if (accountList.isEmpty()) {
                return null;
            }
            return accountList;
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
     *
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
     *
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
