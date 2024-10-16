package com.vti.frontend;

import com.vti.entity.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        // Tạo ra các Session
        Session session = null;
        try {
            session = buildSessionFactory().openSession();
            // Hiển thị danh sách phòng ban trong DB
            String hqlselectDepartment = "FROM Department";
            Query<Department> query = session.createQuery(hqlselectDepartment);
            // hàm query.list() lấy dữ liệu từ DB, tạo ra resulSet, sau đó chuyển đổi thành List<Department>
            List<Department> listDepartments = query.list();
            for (Department department : listDepartments) {
                System.out.println(department.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    // hàm tạo SessionFactory cho chương trình, quản lý các session kết nối tới DB
    private static SessionFactory buildSessionFactory() {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        // đăng ký các đối tượng Pojo trong chương trình
        config.addAnnotatedClass(Department.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        return config.buildSessionFactory(serviceRegistry);

    }
}
