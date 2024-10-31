package com.vti.repository;

import com.vti.entity.DetailDepartment;
import com.vti.entity.Employee;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;


public class EmployeeRep {

    private final HibernateUtils hibernateUtils;

    public EmployeeRep() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    // 1 - Method để tạo mới 1 đối tượng vào bảng EmployeeRep
    public void createEmployee(Employee account) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            // create
            session.save(account);
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
