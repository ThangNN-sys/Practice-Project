package com.vti.repository;

import com.vti.entity.Address;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;


public class AddressRep {

    private final HibernateUtils hibernateUtils;

    public AddressRep() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    // 1 - Method để tạo mới 1 đối tượng vào bảng Address
    public void createAddress(Address address) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // create
            session.save(address);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // 2 - Method để lấy thông tin toàn bộ đối tượng thuộc bảng Address
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

    // 3 - Method để lấy thông tin đối tượng thuộc bảng Address theo ID
    public Address getAddressById(short id) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // get Address by id
            Address address = session.get(Address.class, id);
            return address;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // 4 - method để lấy thông tin đối tượng thuộc bảng Address theo Address Name
    public Address getAddressByAddressName(String name) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // create hql query
            Query<Address> query = session.createQuery("FROM Address WHERE name = :nameParameter");
            // set parameter
            query.setParameter("nameParameter", name);
            // get result
            Address address = query.uniqueResult();
            return address;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // 5a - method để update thông tin đối tượng thuộc bảng Address - Cách 1
    public void updateAddress(short id, String addressName) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            // get Address
            Address address = session.load(Address.class, id);
            // update
            address.setName(addressName);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // 5b - method để update thông tin đối tượng thuộc bảng Account - Cách 2
//    public void updateAccount(Account account) {
//        Session session = null;
//        try {
//            // get session
//            session = hibernateUtils.openSession();
//            session.beginTransaction();
//            // update
//            session.update(account);
//            session.getTransaction().commit();
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//    }

    // 6 - method để delete thông tin đối tượng thuộc bảng Address, tìm theo ID
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
