package com.vti.repository;

import com.vti.entity.Position;
import com.vti.entity.enumerate.PositionName;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Class quản lý các phương thức
 * Dùng để khai báo phương thức xử lý thông tin bảng Position trên DB
 */

public class PositionRepository {

	private HibernateUtils hibernateUtils;

	public PositionRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	/**
	 * 1. Phương thức để tạo mới 1 đối tượng vào bảng Position
	 */
	public void createPosition(Position position) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(position);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 2. Phương thức để lấy thông tin toàn bộ đối tượng thuộc bảng Position
	 */
	public List<Position> getAllPositions() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Position> query = session.createQuery("FROM Position");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 3. Phương thức để lấy thông tin đối tượng thuộc bảng Position theo ID
	 */
	public Position getPositionByID(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// get Position by id
			Position position = session.get(Position.class, id);
			return position;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 4. Phương thức để update thông tin đối tượng thuộc bảng Position
	 */
	public void updatePosition(short id, String positionName) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// get position
			Position position = session.load(Position.class, id);
			// update
			position.setPositionName(PositionName.valueOf(positionName));
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 5. Phương thức để delete thông tin đối tượng thuộc bảng Position, tìm theo ID
	 * @param id
	 */
	public void deletePosition(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// get position
			Position position = session.load(Position.class, id);
			// delete
			session.delete(position);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
