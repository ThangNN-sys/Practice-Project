package com.vti.repository;

import com.vti.entity.Account;
import com.vti.entity.Position;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PositionRepository {

	private HibernateUtils hibernateUtils;

	public PositionRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	// 1 - Method để tạo mới 1 đối tượng vào bảng Position

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

	//	2 - Method để lấy thông tin toàn bộ đối tượng thuộc bảng Position

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

	// 3 - Method để lấy thông tin đối tượng thuộc bảng Position theo ID
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

	// 4 - method để lấy thông tin toàn đối tượng thuộc bảng Position theo position name
	public Position getPositionByName(String name) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// create hql query
			Query<Position> query = session.createQuery("FROM Position WHERE name = :nameParameter");
			// set parameter
			query.setParameter("nameParameter", name);
			// get result
			Position position = query.uniqueResult();
			return position;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

//	// 5 - method để update thông tin đối tượng thuộc bảng Position - Cách 1
//	public void updatePosition(short id, String name) {
//		Session session = null;
//		try {
//			// get session
//			session = hibernateUtils.openSession();
//			session.beginTransaction();
//			// get position
//			Position position = (Position) session.load(Position.class, id);
//			// update
//			position.setName(name);
//			session.getTransaction().commit();
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//	}

	// 6 - method để delete thông tin đối tượng thuộc bảng Position, tìm theo ID
	public void deletePosition(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// get Position
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
