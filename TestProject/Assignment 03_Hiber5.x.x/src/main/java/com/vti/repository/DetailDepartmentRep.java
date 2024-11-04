package com.vti.repository;

import com.vti.entity.Department;
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
    public void createDepartment(DetailDepartment department) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            // create
            session.save(department);
            session.getTransaction().commit();
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
}
