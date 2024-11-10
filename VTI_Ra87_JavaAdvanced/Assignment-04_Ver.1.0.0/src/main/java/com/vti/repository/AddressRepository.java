package com.vti.repository;

import com.vti.entity.Address;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Class quản lý các phương thức
 * Dùng để khai báo phương thức xử lý thông tin bảng Address trên DB
 */

public class AddressRepository {

	private HibernateUtils hibernateUtils;

	public AddressRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	/**
	 * 1. Phương thức để tạo mới 1 đối tượng vào bảng Address
	 */
	public void createAddress(Address address) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(address);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 2. Phương thức để lấy thông tin toàn bộ đối tượng thuộc bảng Address
	 */
	public List<Address> getAllAddresses() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Address> query = session.createQuery("FROM Address");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 3. Phương thức để lấy thông tin 1 đối tượng thuộc bảng Address tìm theo ID
	 */
	public Address getAddressByID(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get address by id
			Address address = session.get(Address.class, id);

			return address;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 4. Phương thức để update thông tin 1 đối tượng thuộc bảng Address tìm theo ID
	 */
	public void updateAddress(short id, String addressName) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// get address
			Address address = session.load(Address.class, id);
			// update
			address.setAddressName(addressName);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 5. Phương thức để delete thông tin 1 đối tượng thuộc bảng Address tìm theo ID
	 */
	public void deleteAddress(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// get address
			Address address = session.load(Address.class, id);
			// delete
			session.delete(address);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
