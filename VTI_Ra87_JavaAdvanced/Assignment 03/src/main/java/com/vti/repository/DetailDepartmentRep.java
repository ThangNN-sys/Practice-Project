package com.vti.repository;

import com.vti.entity.Account;
import com.vti.entity.DetailDepartment;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;


public class DetailDepartmentRep {

    private final HibernateUtils hibernateUtils;

    public DetailDepartmentRep() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    // 1 - Method để tạo mới 1 đối tượng vào bảng DetailDepartment
    public void createDetailDepartment(DetailDepartment detailDepartment) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // create
            session.save(detailDepartment);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // 2 - Method để lấy thông tin toàn bộ đối tượng thuộc bảng DetailDepartment
    public List<DetailDepartment> getAllDetailDepartment() {
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

    // 3 - method để lấy thông tin đối tượng thuộc bảng DetailDepartment theo DepartmentID
    public List<DetailDepartment> getDetailByDepartmentId(short name) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // create hql query
            Query<DetailDepartment> query = session.createQuery("FROM DetailDepartment WHERE department = :nameParameter");
            // set parameter
            query.setParameter("nameParameter", name);
            // get result list
            List<DetailDepartment> detailDepartments = query.list();
            if (detailDepartments.isEmpty()) {
                return null;
            }
            return detailDepartments;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // 4 - method để lấy thông tin đối tượng thuộc bảng DetailDepartment theo AddressID
    public List<DetailDepartment> getDetailByAddressId(short name) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // create hql query
            Query<DetailDepartment> query = session.createQuery("FROM DetailDepartment WHERE address = :nameParameter");
            // set parameter
            query.setParameter("nameParameter", name);
            // get result list
            List<DetailDepartment> detailDepartments = query.list();
            if (detailDepartments.isEmpty()) {
                return null;
            }
            return detailDepartments;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // 5 - method để update thông tin đối tượng thuộc bảng DetailDepartment - Cách 1
    public void updateDetailDepartment(String department, String address, short emulationPoint) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            // find DetailDepartment by DepartmentID and AddressID
            Query<DetailDepartment> query = session.createQuery("FROM DetailDepartment WHERE department = :depId AND address = :addId", DetailDepartment.class);
            query.setParameter("depId", department);
            query.setParameter("address", address);

            DetailDepartment detailDepartment = query.uniqueResult(); // dùng uniqueResult để lấy đối tượng duy nhất

            // check if DetailDepartment is found
            if (detailDepartment != null) {
                // update DetailDepartment details
                detailDepartment.setEmulationPoint(emulationPoint);
                session.getTransaction().commit();
            } else {
                System.out.println("Account not found with DepartmentID: " + department + " and AddressID: " + address);
            }
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
