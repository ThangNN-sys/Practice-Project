package com.vti.repository;

import com.vti.entity.Employee;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;


public class EmployeeRep {

    private HibernateUtils hibernateUtils;

    public EmployeeRep() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    // 1 - Method để tạo mới 1 đối tượng vào bảng Account
    public void creatAccount(Employee employee) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            // create
            session.save(employee);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // 2 - Method để lấy thông tin toàn bộ đối tượng thuộc bảng EmployeeRep
    public List<Employee> getAllEmployees() {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // create hql query
            Query<Employee> query = session.createQuery("FROM Employee");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
