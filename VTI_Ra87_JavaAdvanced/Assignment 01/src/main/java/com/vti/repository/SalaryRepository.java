package com.vti.repository;

import com.vti.entity.Account;
import com.vti.entity.Salary;
import com.vti.entity.enumerate.SalaryName;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SalaryRepository {

	private HibernateUtils hibernateUtils;

	public SalaryRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	// 1 - Method để tạo mới 1 đối tượng vào bảng Salary

	public void createSalary(Salary Salary) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// create
			session.save(Salary);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// 2 - Method để lấy thông tin toàn bộ đối tượng thuộc bảng Salary

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

	// 3 - Method để lấy thông tin đối tượng thuộc bảng Salary theo ID

	public Salary getSalaryById(short id) {
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

	// 4 - method để lấy thông tin đối tượng thuộc bảng Salary theo name

	public Salary getSalaryByName(String name) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// create hql query
			Query<Salary> query = session.createQuery("FROM Salary WHERE 'SalaryName' = :nameParameter");
			// set parameter
			query.setParameter("nameParameter", name);
			// get result
			Salary salary = query.uniqueResult();
			return salary;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// 5 - method để update thông tin đối tượng thuộc bảng Salary - Cách 1

//	public void updateSalary(short id, String salaryName) {
//		Session session = null;
//		try {
//			// get session
//			session = hibernateUtils.openSession();
//			session.beginTransaction();
//			// get salary
//			Salary salary = session.load(Salary.class, id);
//			// update
//			salary.getName(salaryName);
//			session.getTransaction().commit();
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//	}

	// 6 - method để delete thông tin đối tượng thuộc bảng Salary, tìm theo ID
	public void deleteSalary(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// get salary
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
