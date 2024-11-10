package com.vti.repository;

import com.vti.entity.DetailDepartment;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Class quản lý các phương thức
 * Dùng để khai báo phương thức xử lý thông tin bảng DetailDepartment trên DB
 */

public class DetailDepartmentRepository {

	private HibernateUtils hibernateUtils;

	public DetailDepartmentRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	/**
	 * 1. Phương thức để tạo mới 1 đối tượng vào bảng DetailDepartment
	 */
	public void createDetailDepartment(DetailDepartment detailDepartment) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(detailDepartment);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 2 - Method để lấy thông tin toàn bộ đối tượng thuộc bảng DetailDepartment
	 */
	public List<DetailDepartment> getAllDetailDepartments() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<DetailDepartment> query = session.createQuery("FROM DetailDepartment");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}



}
